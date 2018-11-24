package com.ncee.aop;

import com.ncee.dto.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.Valid;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestResponse<String> handleException(RuntimeException e){
        RestResponse<String> response = new RestResponse<>(null);
        response.setMessage(e.getMessage());
        response.setCode("-1");
        return response;
    }
    @ExceptionHandler(ValidateException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public RestResponse<String> handleValidationException(ValidateException e){
        List<ObjectError> errorList = e.getErrors();
        StringBuilder exceptionInfoBuilder = new StringBuilder();
        for(ObjectError error: errorList){
            exceptionInfoBuilder.append(error.getDefaultMessage());
            exceptionInfoBuilder.append("   ");
        }
        RestResponse<String> response = new RestResponse<>(null);
        response.setCode("-1");
        response.setMessage(exceptionInfoBuilder.toString());
        return response;
    }
}
