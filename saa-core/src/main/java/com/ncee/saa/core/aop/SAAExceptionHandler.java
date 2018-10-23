package com.ncee.saa.core.aop;

import com.ncee.saa.core.support.RestResponse;
import com.ncee.saa.core.validate.exception.ValidateCodeException;
import com.ncee.saa.core.validate.exception.ValidateCodeMissingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SAAExceptionHandler {
    @ExceptionHandler(ValidateCodeException.class)
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ResponseBody
    RestResponse<String> handlerValidateException(ValidateCodeException e){
        RestResponse<String> restResponse = new RestResponse<>(e.getMessage());
        return restResponse;
    }
    @ExceptionHandler(ValidateCodeMissingException.class)
    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    @ResponseBody
    RestResponse<String> handleValidateCodeMissingException(ValidateCodeMissingException e){
        RestResponse<String> restResponse = new RestResponse<>(e.getMessage());
        return restResponse;
    }
}
