package com.ncee.saa.core.matcher.impl;

import com.ncee.saa.core.matcher.MatcherProvider;
import com.ncee.saa.core.properties.SAAConstants;
import com.ncee.saa.core.properties.SAAProperties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Order(Integer.MIN_VALUE)
public class MatcherProviderImpl implements MatcherProvider, ApplicationContextAware {
    @Autowired
    private SAAProperties saaProperties;
    private WebApplicationContext applicationContext;
    @Override
    public void configMatcher(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {

        config.antMatchers(saaProperties.getBrowser().getLoginPage(),
                "/validate/code/*",
                applicationContext.getServletContext().getContextPath() + SAAConstants.VALIDATE_CODE_IMAGE_URL,
                applicationContext.getServletContext().getContextPath() + SAAConstants.VALIDATE_CODE_SMS_URL,
                saaProperties.getBrowser().getLoginProcessingUrl()).permitAll();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = (WebApplicationContext) applicationContext;
    }
}
