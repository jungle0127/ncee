package com.ncee.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ListStringMaxValidator implements ConstraintValidator<ListStringMax, List<String>> {
    private Integer max;
    @Override
    public void initialize(ListStringMax constraintAnnotation) {
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(List<String> value, ConstraintValidatorContext context) {

        for(String item : value){
            if(item.length() > max){
                return false;
            }
        }
        return true;
    }
}
