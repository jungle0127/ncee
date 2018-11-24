package com.ncee.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

@Aspect
@Component
public class RequestValidationAspect {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Around("execution(* com.ncee.controller..*Controller.*(..))")
    public Object validateRequest(ProceedingJoinPoint joinPoint) throws Throwable{
        logger.info("begin validate request.");
        Object[] parameters = joinPoint.getArgs();
        for(Object param : parameters){
            if(param instanceof BindingResult){
                BindingResult bindingResult = (BindingResult) param;
                if(bindingResult.hasErrors()){
                    throw new ValidateException(bindingResult.getAllErrors());
                }
            }
        }
        Object result = joinPoint.proceed();
        return result;
    }
}
