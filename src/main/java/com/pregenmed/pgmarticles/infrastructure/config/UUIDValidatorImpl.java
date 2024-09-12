package com.pregenmed.pgmarticles.infrastructure.config;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.UUID;

public class UUIDValidatorImpl implements ConstraintValidator<UUIDValidator, UUID> {

    @Override
    public void initialize(UUIDValidator constraintAnnotation) {
    }

    @Override
    public boolean isValid(UUID value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        try {
            UUID.fromString(value.toString());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
