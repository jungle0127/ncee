package com.ncee.autoconfig;

import com.ncee.support.AutoconfigureConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@Configuration
public class NCEEUIAutoconfiguration implements WebMvcConfigurer {
    private final String WEB_UI_DIR_NAME = AutoconfigureConstants.WEB_UI_DIR_NAME;

    @Value("classpath:"+WEB_UI_DIR_NAME+"/index.html")
    Resource indexHtml;
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter() {
            @Override
            protected boolean shouldNotFilter(HttpServletRequest request) {
                return request.getServletPath().endsWith(".png") ||
                        request.getServletPath().endsWith(".jpg") ||
                        request.getServletPath().endsWith(".svg");
            }
        };
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(WEB_UI_DIR_NAME+"/**")
                .addResourceLocations("classpath:/"+WEB_UI_DIR_NAME+"/")
                .setCachePeriod((int) TimeUnit.DAYS.toSeconds(365));
    }
}
