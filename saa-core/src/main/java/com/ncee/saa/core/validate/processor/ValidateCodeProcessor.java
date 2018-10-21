package com.ncee.saa.core.validate.processor;

import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;

public interface ValidateCodeProcessor {
    String SESSION_KEY_PREFIX = "SESSION_KEY_CODE_";

    /**
     * Process request for create, save and send a validate code.
     * @param request
     * @throws IOException
     */
    void process(ServletWebRequest request) throws IOException, ServletRequestBindingException;

    /**
     * Validate request of its validate code.
     * @param request
     */
    boolean validate(ServletWebRequest request);
}
