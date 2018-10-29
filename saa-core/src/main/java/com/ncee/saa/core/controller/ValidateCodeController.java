package com.ncee.saa.core.controller;

import com.ncee.saa.core.validate.processor.ValidateCodeProcessorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/validate/code")
public class ValidateCodeController {
    @Autowired
    private ValidateCodeProcessorManager validateCodeProcessorManager;
    @GetMapping("/{type}")
    public void createCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws IOException, ServletRequestBindingException {
        this.validateCodeProcessorManager.findValidateCodeProcessor(type).process(new ServletWebRequest(request,response));
    }
}
