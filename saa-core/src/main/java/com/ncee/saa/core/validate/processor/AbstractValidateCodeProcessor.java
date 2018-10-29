package com.ncee.saa.core.validate.processor;

import com.ncee.saa.core.validate.code.ValidateCode;
import com.ncee.saa.core.validate.code.ValidateCodeType;
import com.ncee.saa.core.validate.exception.ValidateCodeException;
import com.ncee.saa.core.validate.exception.ValidateCodeMissingException;
import com.ncee.saa.core.validate.generator.ValidateCodeGenerator;
import com.ncee.saa.core.validate.respository.ValidateCodeRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;
import java.util.Map;

public abstract class AbstractValidateCodeProcessor<T extends ValidateCode> implements ValidateCodeProcessor {
    @Autowired
    private ValidateCodeRepository validateCodeRepository;
    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGeneratorMap;

    @Override
    public void process(ServletWebRequest request) throws IOException, ServletRequestBindingException {
        T validateCode = create(request);
        save(request, validateCode);
        send(request, validateCode);
    }

    @Override
    public boolean validate(ServletWebRequest request) {
        ValidateCodeType validateCodeType = getValidateCodeType(request);
        T validateCodeStored = (T) validateCodeRepository.getValidateCode(request,validateCodeType);
        String codeInRequest = null;
        try{
            codeInRequest = ServletRequestUtils.getRequiredStringParameter(request.getRequest(),validateCodeType.getTypeOnValidate());
        } catch (ServletRequestBindingException e){
            throw new ValidateCodeMissingException(e.getMessage());
        }
        if(validateCodeStored == null){
            throw new ValidateCodeException("Validate code doesn't exist in cache.");
        }
        if(StringUtils.isBlank(codeInRequest)){
            throw new ValidateCodeException("Validate code can not be null.");
        }
        if(validateCodeStored.isExpired()){
            validateCodeRepository.remove(request,validateCodeType);
            throw new ValidateCodeException("Validate code expired.");
        }
        if(!StringUtils.equalsIgnoreCase(codeInRequest,validateCodeStored.getCode())){
            throw new ValidateCodeException("Validate code does not match.");
        }
        validateCodeRepository.remove(request,validateCodeType);
        return true;
    }
    private ValidateCodeType getValidateCodeType(ServletWebRequest request){
        String type = StringUtils.substringBefore(getClass().getSimpleName(),"ValidateCodeProcessor");
        return ValidateCodeType.valueOf(type.toUpperCase());
    }
    private T create(ServletWebRequest request) {
        ValidateCodeType validateCodeType = this.getValidateCodeType(request);
        ValidateCodeGenerator validateCodeGenerator = validateCodeGeneratorMap.get(validateCodeType.toString().toLowerCase() + "CodeGenerator");
        if(validateCodeGenerator == null){
            throw new ValidateCodeException("Validate code generator doesn't exist.");
        }
        return (T) validateCodeGenerator.generate(request);
    }

    private void save(ServletWebRequest request, T validateCode) {
        validateCodeRepository.save(request,validateCode,getValidateCodeType(request));
    }

    /**
     * Send validate code out
     * @param request
     * @param validateCode
     */
    public abstract void send(ServletWebRequest request, T validateCode) throws IOException, ServletRequestBindingException;
}
