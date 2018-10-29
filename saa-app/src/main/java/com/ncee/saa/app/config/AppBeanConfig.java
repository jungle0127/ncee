package com.ncee.saa.app.config;

import com.ncee.saa.app.validate.code.repository.ValidateCodeRepositoryImpl;
import com.ncee.saa.core.validate.respository.ValidateCodeRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppBeanConfig {
    @Bean
    @ConditionalOnMissingBean(ValidateCodeRepository.class)
    public ValidateCodeRepository validateCodeRepository(){
        return new ValidateCodeRepositoryImpl();
    }
}
