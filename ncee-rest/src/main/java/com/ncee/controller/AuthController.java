package com.ncee.controller;

import com.ncee.dto.RestResponse;
import com.ncee.dto.User;
import com.ncee.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authorization")
public class AuthController {
    @Autowired
    private UserService userService;
    @PostMapping("/user")
    public RestResponse<Boolean> addUser(User userDto){
        return null;
    }
}
