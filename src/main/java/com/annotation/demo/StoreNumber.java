package com.annotation.demo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
@Target({ ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StoreNumberValidator.class)
public @interface StoreNumber {
	String message() default "must be a 4 digit number";
	Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
