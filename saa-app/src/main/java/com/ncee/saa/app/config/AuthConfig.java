package com.ncee.saa.app.config;

import com.ncee.saa.core.config.BasicAuthenticationConfigure;
import com.ncee.saa.core.matcher.MatcherManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class AuthConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private BasicAuthenticationConfigure basicAuthenticationConfigure;
    @Autowired
    private MatcherManager matcherManager;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        basicAuthenticationConfigure.configure(http);
        matcherManager.configMatcher(http.authorizeRequests());
    }
}
