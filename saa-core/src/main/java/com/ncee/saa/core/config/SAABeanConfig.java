package com.ncee.saa.core.config;

import com.ncee.saa.core.handler.DefaultAuthenticationFailureHandler;
import com.ncee.saa.core.handler.DefaultAuthenticationSuccessHandler;
import com.ncee.saa.core.properties.SAAProperties;
import com.ncee.saa.core.service.DefaultUserDetailsService;
import com.ncee.saa.core.validate.sender.SMSCodeSender;
import com.ncee.saa.core.validate.sender.impl.DefaultSMSCodeSenderImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class SAABeanConfig {
    @Bean
    @ConditionalOnMissingBean(PasswordEncoder.class)
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    @ConditionalOnMissingBean(AuthenticationSuccessHandler.class)
    public AuthenticationSuccessHandler authenticationSuccessHandler(){
        return new DefaultAuthenticationSuccessHandler();
    }
    @Bean
    @ConditionalOnMissingBean(AuthenticationFailureHandler.class)
    public AuthenticationFailureHandler authenticationFailureHandler(){
        return new DefaultAuthenticationFailureHandler();
    }
    @Bean
    @ConditionalOnMissingBean(UserDetailsService.class)
    public UserDetailsService userDetailsService(){
        return new DefaultUserDetailsService();
    }

    @Bean
    @ConditionalOnMissingBean(SMSCodeSender.class)
    public SMSCodeSender smsCodeSender(){
        return new DefaultSMSCodeSenderImpl();
    }
}
