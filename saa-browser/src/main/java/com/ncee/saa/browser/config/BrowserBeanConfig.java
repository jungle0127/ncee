package com.ncee.saa.browser.config;

import com.ncee.saa.browser.respository.ValidateCodeRepositoryImpl;
import com.ncee.saa.core.validate.respository.ValidateCodeRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BrowserBeanConfig {
    @Bean
    @ConditionalOnMissingBean(ValidateCodeRepository.class)
    private ValidateCodeRepository validateCodeRepository(){
        return new ValidateCodeRepositoryImpl();
    }
}