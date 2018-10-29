package com.ncee.saa.browser.config;

import com.ncee.saa.browser.respository.ValidateCodeRepositoryImpl;
import com.ncee.saa.core.validate.respository.ValidateCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
public class BrowserBeanConfig {
    @Bean
    @ConditionalOnMissingBean(ValidateCodeRepository.class)
    public ValidateCodeRepository validateCodeRepository(){
        return new ValidateCodeRepositoryImpl();
    }
    @Autowired
    public DataSource dataSource;

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        jdbcTokenRepository.setCreateTableOnStartup(false);
        return jdbcTokenRepository;
    }
}
