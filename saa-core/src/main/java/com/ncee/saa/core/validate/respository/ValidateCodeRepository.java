package com.ncee.saa.core.validate.respository;

import com.ncee.saa.core.validate.code.ValidateCode;
import com.ncee.saa.core.validate.code.ValidateCodeType;
import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeRepository {
    ValidateCode getValidateCode(ServletWebRequest request, ValidateCodeType validateCodeType);
    void save(ServletWebRequest request,ValidateCode validateCode, ValidateCodeType validateCodeType);
    void remove(ServletWebRequest request, ValidateCode validateCode);
}
