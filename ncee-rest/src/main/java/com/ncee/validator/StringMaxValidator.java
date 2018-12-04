package com.ncee.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringMaxValidator implements ConstraintValidator<StringMax,String> {
    private Integer max;
    @Override
    public void initialize(StringMax constraintAnnotation) {
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.length() > this.max){
            return false;
        }
        return true;
    }
}
