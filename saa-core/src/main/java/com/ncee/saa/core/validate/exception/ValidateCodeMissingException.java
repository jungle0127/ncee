package com.ncee.saa.core.validate.exception;

public class ValidateCodeMissingException extends RuntimeException {
    public ValidateCodeMissingException(){
        super("Can not find validate code.");
    }
    public ValidateCodeMissingException(String message){
        super(message);
    }
}
