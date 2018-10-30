package com.ncee.saa.app.config;

import com.ncee.saa.app.validate.code.repository.ValidateCodeRepositoryImpl;
import com.ncee.saa.core.validate.respository.ValidateCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
public class AppBeanConfig {
    @Autowired
    private DataSource dataSource;
    @Bean
    @ConditionalOnMissingBean(ValidateCodeRepository.class)
    public ValidateCodeRepository validateCodeRepository(){
        return new ValidateCodeRepositoryImpl();
    }
    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        jdbcTokenRepository.setCreateTableOnStartup(false);
        return jdbcTokenRepository;
    }
}
