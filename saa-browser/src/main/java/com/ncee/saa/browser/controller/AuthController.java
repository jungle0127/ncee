package com.ncee.saa.browser.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/authentication")
public class AuthController {
    @PostMapping("/authenticate")
    public void authenticate(HttpServletRequest request){

    }

}
