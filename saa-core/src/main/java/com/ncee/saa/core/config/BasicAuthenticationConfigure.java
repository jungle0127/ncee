package com.ncee.saa.core.config;

import com.ncee.saa.core.properties.SAAConstants;
import com.ncee.saa.core.properties.SAAProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class BasicAuthenticationConfigure {
    @Autowired
    private SAAProperties saaProperties;
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;
    public void configure(HttpSecurity http) throws Exception {
//        http.httpBasic().configure(http);
        http.formLogin()
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                .loginPage(SAAConstants.AUTHENTICATION_URL)
                .loginProcessingUrl(saaProperties.getBrowser().getLoginProcessingUrl());
    }
}
