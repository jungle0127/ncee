package com.ncee.saa.browser.config;

import com.ncee.saa.core.matcher.MatcherProvider;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

@Component
@Order(Integer.MIN_VALUE)
public class BrowserConfigureProvider implements MatcherProvider {
    @Override
    public void configMatcher(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        config.antMatchers("/**/*.js","/**/*.css",
                "/**/*.jpg","/**/*.jpeg","/**/*.png","/**/*.gif").permitAll();
    }
}
