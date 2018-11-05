package com.ncee.saa.app.validate.code.repository;

import com.ncee.saa.core.validate.code.ValidateCode;
import com.ncee.saa.core.validate.code.ValidateCodeType;
import com.ncee.saa.core.validate.respository.ValidateCodeRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.concurrent.ConcurrentHashMap;
@Component
@CacheConfig
@ConditionalOnMissingBean(ValidateCodeRepository.class)
public class ValidateCodeRepositoryImpl implements ValidateCodeRepository {
    private ConcurrentHashMap<String,ValidateCode> validatecodeStore = new ConcurrentHashMap<>();

    @Cacheable
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
