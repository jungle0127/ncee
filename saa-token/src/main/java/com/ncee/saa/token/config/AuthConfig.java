package com.ncee.saa.token.config;

import com.ncee.saa.core.config.BasicAuthenticationConfigure;
import com.ncee.saa.core.matcher.MatcherManager;
import com.ncee.saa.core.validate.filter.ImageCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@Configuration
public class AuthConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private BasicAuthenticationConfigure basicAuthenticationConfigure;
    @Autowired
    private MatcherManager matcherManager;
    @Autowired
    private ImageCodeFilter imageCodeFilter;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        this.basicAuthenticationConfigure.configure(http);
        this.matcherManager.configMatcher(http.authorizeRequests());
        http.authorizeRequests().antMatchers("/oauth/authorize","/oauth/token").permitAll();

        http.authorizeRequests().anyRequest().authenticated()
                .and().csrf().disable();
    }
}
