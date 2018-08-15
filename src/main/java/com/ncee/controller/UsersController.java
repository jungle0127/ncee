package com.ncee.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncee.dao.model.Users;
import com.ncee.service.IUserService;

@RestController
@RequestMapping("/users")
public class UsersController {
	private final static Logger logger = LogManager.getLogger(UsersController.class);
	@Autowired
	@Qualifier("userService")
	private IUserService usersService;
	
	@GetMapping("/user/{loginName}/{password}}")
	public boolean login(@PathVariable String loginName,@PathVariable String password){
		logger.info("login method");
		Users user = this.usersService.login(loginName, password);
		if(null != user){
			logger.info("Login success with user:{}",user.getUsername());
			return true;
		}
		else{
			return false;
		}
	}
	@GetMapping("/user/{loginName}")
	public Users getUserDetailInfo(@PathVariable String loginName) {
		return null;
	}
}
