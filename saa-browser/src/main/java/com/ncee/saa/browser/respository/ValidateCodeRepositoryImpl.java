package com.ncee.saa.browser.respository;

import com.ncee.saa.core.validate.code.ValidateCode;
import com.ncee.saa.core.validate.code.ValidateCodeType;
import com.ncee.saa.core.validate.respository.ValidateCodeRepository;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * TODO: idle now
 */
public class ValidateCodeRepositoryImpl implements ValidateCodeRepository {
    private String SESSION_KEY_PREFIX = "VALIDATE_CODE_SESSION_KEY_";
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Override
    public ValidateCode getValidateCode(ServletWebRequest request, ValidateCodeType validateCodeType) {
        return (ValidateCode) sessionStrategy.getAttribute(request,getSessionKey(validateCodeType));
    }

    @Override
    public void save(ServletWebRequest request, ValidateCode validateCode, ValidateCodeType validateCodeType) {
        sessionStrategy.setAttribute(request,getSessionKey(validateCodeType),validateCode);
    }

    @Override
    public void remove(ServletWebRequest request, ValidateCodeType validateCodeType) {
        sessionStrategy.removeAttribute(request,getSessionKey(validateCodeType));
    }

    private String getSessionKey(ValidateCodeType validateCodeType){
        return SESSION_KEY_PREFIX + validateCodeType.getTypeOnValidate().toUpperCase();
    }
}
