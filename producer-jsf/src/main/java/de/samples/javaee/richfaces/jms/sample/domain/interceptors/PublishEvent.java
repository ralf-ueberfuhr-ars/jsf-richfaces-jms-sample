package de.samples.javaee.richfaces.jms.sample.domain.interceptors;

import jakarta.enterprise.util.Nonbinding;
import jakarta.interceptor.InterceptorBinding;

import java.lang.annotation.*;

/**
 * Annotate a method to get an event fired after method execution.
 */
@Inherited
@Documented
@InterceptorBinding
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PublishEvent {

  /**
   * The event class. This class needs a constructor with the same parameters as the method.
   *
   * @return the event class
   */
  @Nonbinding Class<?> value();

}
