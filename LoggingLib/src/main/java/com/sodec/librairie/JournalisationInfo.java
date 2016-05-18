package com.sodec.librairie;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Information 
 * @author tnguyen
 *
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)

public @interface JournalisationInfo {
   JournalisationDomaine domaine();
   String version() default "0.0";
}
