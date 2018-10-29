package com.ncee.saa.core.validate.filter;

import com.ncee.saa.core.properties.SAAConstants;
import com.ncee.saa.core.validate.code.ValidateCodeType;
import com.ncee.saa.core.validate.processor.ValidateCodeProcessorManager;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ImageCodeFilter extends OncePerRequestFilter {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ValidateCodeProcessorManager validateCodeProcessorManager;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String requestMethod = request.getMethod();
        String contextPath = request.getContextPath();
        String loginProcessingUrl = contextPath + SAAConstants.DEFAULT_FORM_SIGN_IN_PROCESSING_URL;
        if(StringUtils.equalsIgnoreCase(requestURI,loginProcessingUrl) && StringUtils.equalsIgnoreCase(requestMethod,"POST")){
            try{
                validateCodeProcessorManager.findValidateCodeProcessor(ValidateCodeType.IMAGE).validate(new ServletWebRequest(request));
            } catch (Exception e){
                logger.error(String.format("Validate image code failed with exception:%s",e.getMessage()));
                return;
            }
        }
        filterChain.doFilter(request,response);
    }
}
