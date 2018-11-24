package com.ncee.controller;

import com.ncee.dto.RestResponse;
import com.ncee.dto.User;
import com.ncee.service.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class StudentsController {
    @Autowired
    private UserService userService;
    @PostMapping("/user")
    public RestResponse<Boolean> addUser(@Valid @RequestBody  User user, BindingResult bindingResult){

        return new RestResponse<>(false);
    }
}
