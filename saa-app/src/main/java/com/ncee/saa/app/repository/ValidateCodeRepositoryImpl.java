package com.ncee.saa.app.repository;

import com.ncee.saa.core.validate.code.ValidateCode;
import com.ncee.saa.core.validate.code.ValidateCodeType;
import com.ncee.saa.core.validate.exception.ValidateCodeException;
import com.ncee.saa.core.validate.respository.ValidateCodeRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.concurrent.ConcurrentHashMap;
@Repository
public class ValidateCodeRepositoryImpl implements ValidateCodeRepository {
    private ConcurrentHashMap<String,ValidateCode> validatecodeStore = new ConcurrentHashMap<>();

    @Override
    public ValidateCode getValidateCode(ServletWebRequest request, ValidateCodeType validateCodeType) {
        return this.validatecodeStore.get(this.generateKey(request,validateCodeType));
    }

    @Override
    public void save(ServletWebRequest request, ValidateCode validateCode, ValidateCodeType validateCodeType) {
        String key = generateKey(request,validateCodeType);
        this.validatecodeStore.put(key,validateCode);
    }

    @Override
    public void remove(ServletWebRequest request, ValidateCodeType validateCodeType) {
        this.validatecodeStore.remove(this.generateKey(request,validateCodeType));
    }
    private String generateKey(ServletWebRequest request, ValidateCodeType type) {
        String deviceId = request.getHeader("clientId");
        if (StringUtils.isBlank(deviceId)) {
            throw new ValidateCodeException("Request header should include clientId as a parameter.");
        }
        return "key:" + type.toString().toLowerCase() + ":" + deviceId;
    }

}
