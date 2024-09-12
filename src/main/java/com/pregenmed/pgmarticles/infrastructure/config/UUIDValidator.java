package com.pregenmed.pgmarticles.infrastructure.config;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UUIDValidatorImpl.class)
public @interface UUIDValidator {
    String message() default "{validation.uuid.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}