package de.samples.javaee.richfaces.jms.sample.domain.interceptors;

import jakarta.interceptor.InterceptorBinding;

import java.lang.annotation.*;

@Inherited
@Documented
@InterceptorBinding
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validated {

}
