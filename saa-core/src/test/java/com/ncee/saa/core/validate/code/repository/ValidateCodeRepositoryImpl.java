package com.ncee.saa.core.validate.code.repository;

import com.ncee.saa.core.validate.code.ValidateCode;
import com.ncee.saa.core.validate.code.ValidateCodeType;
import com.ncee.saa.core.validate.respository.ValidateCodeRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
@Component
public class ValidateCodeRepositoryImpl implements ValidateCodeRepository {
    @Override
    public ValidateCode getValidateCode(ServletWebRequest request, ValidateCodeType validateCodeType) {
        return null;
    }

    @Override
    public void save(ServletWebRequest request, ValidateCode validateCode, ValidateCodeType validateCodeType) {

    }

    @Override
    public void remove(ServletWebRequest request, ValidateCodeType validateCodeType) {

    }
}
