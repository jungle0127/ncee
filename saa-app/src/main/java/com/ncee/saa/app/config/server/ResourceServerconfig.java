package com.ncee.saa.app.config.server;

import com.ncee.saa.core.config.BasicAuthenticationConfigure;
import com.ncee.saa.core.config.SMSCodeAuthenticationSecurityConfig;
import com.ncee.saa.core.properties.SAAConstants;
import com.ncee.saa.core.properties.SAAProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
@Configuration
@EnableResourceServer
public class ResourceServerconfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private BasicAuthenticationConfigure basicAuthenticationConfigure;
    @Autowired
    private SMSCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
    @Autowired
    private SAAProperties saaProperties;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        basicAuthenticationConfigure.configure(http);
        http.apply(smsCodeAuthenticationSecurityConfig)
                .and()
                .authorizeRequests()
                .antMatchers( SAAConstants.VALIDATE_CODE_SMS_URL,
                        SAAConstants.VALIDATE_CODE_IMAGE_URL,
                        SAAConstants.AUTHENTICATION_URL,
                        saaProperties.getBrowser().getLoginProcessingUrl(),
                        saaProperties.getBrowser().getLoginPage())
                .permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
