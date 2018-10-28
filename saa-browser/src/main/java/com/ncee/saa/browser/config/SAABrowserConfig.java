package com.ncee.saa.browser.config;

import com.ncee.saa.core.config.BasicAuthenticationConfigure;
import com.ncee.saa.core.matcher.MatcherManager;
import com.ncee.saa.core.properties.SAAProperties;
import com.ncee.saa.core.validate.filter.ImageCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        basicAuthenticationConfigure.configure(http);
        matcherManager.configMatcher(http.authorizeRequests());
        http.addFilterBefore(new ImageCodeFilter(), UsernamePasswordAuthenticationFilter.class);
        http.userDetailsService(userDetailsService)
                .authorizeRequests().anyRequest().authenticated()
                .and()
                .csrf().disable();
    }
}
