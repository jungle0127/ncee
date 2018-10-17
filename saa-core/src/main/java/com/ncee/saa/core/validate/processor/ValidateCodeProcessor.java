package com.ncee.saa.core.validate.processor;

import org.springframework.web.context.request.ServletWebRequest;

import java.io.IOException;

public interface ValidateCodeProcessor {
    String SESSION_KEY_PREFIX = "SESSION_KEY_CODE_";
    void process(ServletWebRequest request) throws IOException;
}
