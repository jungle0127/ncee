package com.ncee.saa.core.matcher.impl;

import com.ncee.saa.core.matcher.MatcherManager;
import com.ncee.saa.core.matcher.MatcherProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MatcherManagerImpl implements MatcherManager {
    @Autowired
    private List<MatcherProvider> matcherProviderList;
    @Override
    public void configMatcher(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        for(MatcherProvider matcherProvider : matcherProviderList){
            matcherProvider.configMatcher(config);
        }
        config.anyRequest().authenticated();
    }
}
