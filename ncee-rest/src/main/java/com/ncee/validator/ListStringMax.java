package com.ncee.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ListStringMaxValidator.class)
public @interface ListStringMax {
    int max() default Integer.MAX_VALUE;

    String message();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String field() default "";
}
