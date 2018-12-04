package com.ncee.validator;

import org.springframework.validation.annotation.Validated;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StringMaxValidator.class)
public @interface StringMax {
    int max() default Integer.MAX_VALUE;
    String message();
}
