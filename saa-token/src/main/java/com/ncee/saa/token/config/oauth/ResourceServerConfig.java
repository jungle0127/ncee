package com.ncee.saa.token.config.oauth;

import com.ncee.saa.core.config.BasicAuthenticationConfigure;
import com.ncee.saa.core.config.SMSCodeAuthenticationSecurityConfig;
import com.ncee.saa.core.matcher.MatcherManager;
import com.ncee.saa.core.properties.SAAConstants;
import com.ncee.saa.core.properties.SAAProperties;
import com.ncee.saa.core.validate.filter.ImageCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private BasicAuthenticationConfigure basicAuthenticationConfigure;
    @Autowired
    private SMSCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
    @Autowired
    private SAAProperties saaProperties;
    @Autowired
    private MatcherManager matcherManager;
    @Autowired
    private ImageCodeFilter imageCodeFilter;
    @Override
    public void configure(HttpSecurity http) throws Exception {
        basicAuthenticationConfigure.configure(http);
        matcherManager.configMatcher(http.authorizeRequests());
        http.addFilterBefore(imageCodeFilter, AbstractPreAuthenticatedProcessingFilter.class);
        http.apply(smsCodeAuthenticationSecurityConfig)
                .and()
                .authorizeRequests()
                .antMatchers( SAAConstants.VALIDATE_CODE_SMS_URL,
                        SAAConstants.VALIDATE_CODE_IMAGE_URL,
                        SAAConstants.AUTHENTICATION_URL,
                        SAAConstants.DEFAULT_FORM_SIGN_IN_PROCESSING_URL,
                        SAAConstants.DEFAULT_SMS_SIGN_IN_PROCESSING_URL,
                        saaProperties.getBrowser().getLoginProcessingUrl(),
                        saaProperties.getBrowser().getLoginPage())
                .permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }

}
