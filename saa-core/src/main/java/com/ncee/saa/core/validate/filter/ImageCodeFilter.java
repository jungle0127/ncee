package com.ncee.saa.core.validate.filter;

import com.ncee.saa.core.properties.SAAConstants;
import com.ncee.saa.core.properties.SAAProperties;
import com.ncee.saa.core.validate.code.ImageCode;
import com.ncee.saa.core.validate.exception.ValidateCodeException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class ImageCodeFilter extends OncePerRequestFilter {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String requestMethod = request.getMethod();
        String contextPath = request.getContextPath();
        String loginProcessingUrl = contextPath + SAAConstants.AUTHENTICATION_URL;
        if(StringUtils.equalsIgnoreCase(requestURI,loginProcessingUrl) && StringUtils.equalsIgnoreCase(requestMethod,"POST")){
            try{
                validateImageCode(new ServletWebRequest(request));
            } catch (ServletRequestBindingException e){
                logger.error(String.format("Validate image code failed with exception:%s",e.getMessage()));
                return;
            }
        }
        filterChain.doFilter(request,response);
    }

    private void validateImageCode(ServletWebRequest request) throws ServletRequestBindingException{
        ImageCode imageCodeInSession = (ImageCode) this.sessionStrategy.getAttribute(request, SAAConstants.IMAGE_CODE_SESSION_KEY);
        String imageCodeInRequest = ServletRequestUtils.getStringParameter(request.getRequest(),SAAConstants.DEFAULT_IMAGECODE_PARAMETER_NAME);
        if(StringUtils.isBlank(imageCodeInRequest)) {
            throw new ValidateCodeException("Image code can not be null.");
        }
        if(imageCodeInSession == null) {
            throw new ValidateCodeException("Image code does not exist.");
        }
        if(imageCodeInSession.isExpired()) {
            this.sessionStrategy.removeAttribute(request, SAAConstants.IMAGE_CODE_SESSION_KEY);
            throw new ValidateCodeException("Image code is expired.");
        }
        if(!StringUtils.equals(imageCodeInRequest, imageCodeInSession.getCode())) {
            throw new ValidateCodeException("Image code does not match");
        }
        this.sessionStrategy.removeAttribute(request, SAAConstants.IMAGE_CODE_SESSION_KEY);
    }
}
