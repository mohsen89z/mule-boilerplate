package xyz.homapay.hampay.core.server.service.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by sima on 10/4/15.
 * sima.ahmadvand@gmail.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Retry {

    Class<? extends Exception>[] on();

    int times() default 1;
}