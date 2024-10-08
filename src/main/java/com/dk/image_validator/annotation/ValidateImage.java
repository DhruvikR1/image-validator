package com.dk.image_validator.annotation;

import com.dk.image_validator.validator.ImageFileValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ImageFileValidator.class)
public @interface ValidateImage {
    String message() default "Invalid Image..";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
