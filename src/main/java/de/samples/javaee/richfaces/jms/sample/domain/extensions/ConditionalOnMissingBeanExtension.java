package de.samples.javaee.richfaces.jms.sample.domain.extensions;

import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.spi.*;

import java.util.HashMap;
import java.util.Map;

/*
 * Blatantly ignores producers!
 * Is lightly tested, so there are probably evil corner cases, so BEWARE!
 */
public class ConditionalOnMissingBeanExtension implements Extension {

  private final Map<Class<?>, AnnotatedType<?>> map = new HashMap<>();

  <T> void processAnnotatedType(@Observes ProcessAnnotatedType<T> pat) {
    AnnotatedType<?> annotatedType = pat.getAnnotatedType();
    ConditionalOnMissingBean annotation = annotatedType.getAnnotation(ConditionalOnMissingBean.class);
    if( annotation != null ) {
      map.put(annotation.value(), annotatedType);
      pat.veto();
    }
  }

  void afterBeanDiscovery(@Observes AfterBeanDiscovery abd, BeanManager beanManager) {
    map.entrySet().stream()
      .filter(e -> doesNotHaveBeanOfType(beanManager, e.getKey()))
      .map(e -> defineBean(beanManager, e.getValue()))
      .forEach(abd::addBean);
    map.clear();
  }

  private boolean doesNotHaveBeanOfType(BeanManager beanManager, Class<?> type) {
    return beanManager.getBeans(type).isEmpty();
  }

  private <T> Bean<T> defineBean(BeanManager beanManager, AnnotatedType<T> annotatedType) {
    BeanAttributes<T> beanAttributes = beanManager.createBeanAttributes(annotatedType);
    InjectionTargetFactory<T> injectionTargetFactory = beanManager.getInjectionTargetFactory(annotatedType);
    return beanManager.createBean(beanAttributes, annotatedType.getJavaClass(), injectionTargetFactory);
  }
}
