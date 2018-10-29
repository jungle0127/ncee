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

public class SMSCodeFilter extends OncePerRequestFilter {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ValidateCodeProcessorManager validateCodeProcessorManager;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = httpServletRequest.getRequestURI();
        String requestMethod = httpServletRequest.getMethod();
        String loginProcessingUrl = httpServletRequest.getContextPath() + SAAConstants.DEFAULT_SMS_SIGN_IN_PROCESSING_URL;
        if(StringUtils.equals(requestURI,loginProcessingUrl) && StringUtils.equalsIgnoreCase(requestMethod,"POST")){
            try{
                validateCodeProcessorManager.findValidateCodeProcessor(ValidateCodeType.SMS).validate(new ServletWebRequest(httpServletRequest));
            } catch (Exception e){
                logger.error(String.format("Validate sender code failed with exception:%s",e.getMessage()));
                return;
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);

    }

}
