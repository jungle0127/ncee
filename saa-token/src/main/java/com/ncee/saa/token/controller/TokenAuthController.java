package com.ncee.saa.token.controller;

import com.ncee.saa.core.properties.SAAConstants;
import com.ncee.saa.core.properties.SAAProperties;
import com.ncee.saa.core.support.RestResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class TokenAuthController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private RequestCache requestCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Autowired
    private SAAProperties saaProperties;

    @RequestMapping(SAAConstants.AUTHENTICATION_URL)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public RestResponse<String> authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            logger.info(String.format("target url %s", targetUrl));
            redirectStrategy.sendRedirect(request, response, saaProperties.getBrowser().getLoginPage());
        }
        return new RestResponse<String>("The resource needs authentication, please redirect to login page.");
    }
}
