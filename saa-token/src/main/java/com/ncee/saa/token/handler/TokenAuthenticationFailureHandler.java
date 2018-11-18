package com.ncee.saa.token.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncee.saa.core.support.RestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component("authenticationFailureHandler")
public class TokenAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        logger.info("Login failed.");
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(this.objectMapper.writeValueAsString(new RestResponse<String>(exception.getMessage())));
    }
}
