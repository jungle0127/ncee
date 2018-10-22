package com.ncee.saa.browser.config;

import com.ncee.saa.browser.respository.ValidateCodeRepositoryImpl;
import com.ncee.saa.core.validate.respository.ValidateCodeRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class BrowserBeanConfig {
    @Bean
    @ConditionalOnMissingBean(ValidateCodeRepository.class)
    public ValidateCodeRepository validateCodeRepository(){
        return new ValidateCodeRepositoryImpl();
    }

}
