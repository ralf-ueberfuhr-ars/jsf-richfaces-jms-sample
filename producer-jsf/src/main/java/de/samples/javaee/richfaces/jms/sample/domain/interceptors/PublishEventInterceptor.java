package de.samples.javaee.richfaces.jms.sample.domain.interceptors;

import jakarta.annotation.Priority;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;
import lombok.SneakyThrows;

@Priority(5) // do this before validation to allow publishing events on exception too
@Interceptor
@PublishEvent(Object.class)
public class PublishEventInterceptor {

  @Inject
  private Event<Object> eventPublisher;

  @SneakyThrows
  private static <T> T createEventObject(InvocationContext invocation, Class<T> eventType) {
    return eventType
      .getConstructor(invocation.getMethod().getParameterTypes())
      .newInstance(invocation.getParameters());
  }

  @AroundInvoke
  public Object fireEvent(InvocationContext invocation) throws Exception {
    final var annotation = AnnotationUtils
      .findAnnotation(invocation.getMethod(), PublishEvent.class);
    @SuppressWarnings("unchecked") final var eventType = AnnotationUtils
      .findAnnotation(invocation.getMethod(), PublishEvent.class)
      .map((PublishEvent publishEvent) -> (Class<Object>) publishEvent.value());
    final var mode = annotation
      .map(PublishEvent::mode)
      .orElse(PublishEvent.PublishingMode.SYNC_AND_ASYNC);
    final var event = eventType
      .map(clazz -> createEventObject(invocation, clazz));
    // if something is wrong until here, we do not invoke the service's create-method
    // now, we invoke the service
    final var result = invocation.proceed();
    // if an exception occured, the event is not fired
    // now, we fire the event

    // eventPublisher.select(eventType).fire(e)
    event.ifPresent(
      e -> eventType
        .map(eventPublisher::select)
        .ifPresent(publisher -> {
          if(mode.isFireSync()) {
            publisher.fire(e);
          }
          if(mode.isFireAsync()) {
            publisher.fireAsync(e);
          }
        })
    );
    // and we need to return the service's result to the invoker (the controller)
    return result;
  }

}
