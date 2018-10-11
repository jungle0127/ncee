package com.ncee.saa.core.matcher.impl;

import com.ncee.saa.core.matcher.MatcherProvider;
import com.ncee.saa.core.properties.SAAProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

@Component
@Order(Integer.MIN_VALUE)
public class MatcherProviderImpl implements MatcherProvider {
    @Autowired
    private SAAProperties saaProperties;
    @Override
    public void configMatcher(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config.antMatchers(saaProperties.getLoginPage(),
                saaProperties.getLoginProcessingUrl()).permitAll();
    }
}
