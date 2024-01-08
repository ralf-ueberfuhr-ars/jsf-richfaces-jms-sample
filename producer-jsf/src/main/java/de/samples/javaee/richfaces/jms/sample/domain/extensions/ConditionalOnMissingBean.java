package de.samples.javaee.richfaces.jms.sample.domain.extensions;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ConditionalOnMissingBean {
  Class<?> value();
}
