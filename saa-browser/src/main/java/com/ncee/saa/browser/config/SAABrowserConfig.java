package com.ncee.saa.browser.config;

import com.ncee.saa.core.config.BasicAuthenticationConfigure;
import com.ncee.saa.core.config.SMSCodeAuthenticationSecurityConfig;
import com.ncee.saa.core.matcher.MatcherManager;
import com.ncee.saa.core.properties.SAAProperties;
import com.ncee.saa.core.validate.filter.ImageCodeFilter;
import com.ncee.saa.core.validate.filter.SMSCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
public class SAABrowserConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SAAProperties saaProperties;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private BasicAuthenticationConfigure basicAuthenticationConfigure;
    @Autowired
    private MatcherManager matcherManager;
    @Autowired
    private PersistentTokenRepository persistentTokenRepository;
    @Autowired
    private SMSCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;
    @Autowired
    private ImageCodeFilter imageCodeFilter;
    @Autowired
    private SMSCodeFilter smsCodeFilter;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        basicAuthenticationConfigure.configure(http);
        matcherManager.configMatcher(http.authorizeRequests());
        http.addFilterBefore(imageCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(imageCodeFilter,UsernamePasswordAuthenticationFilter.class);

        http.rememberMe()
                .tokenRepository(persistentTokenRepository)
                .tokenValiditySeconds(saaProperties.getBrowser().getRememberMeSeconds())
                .userDetailsService(userDetailsService);
        http.authorizeRequests().anyRequest().authenticated()
                .and().csrf().disable();
        http.apply(smsCodeAuthenticationSecurityConfig);
    }
}
