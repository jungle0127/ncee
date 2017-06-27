package com.ncee.controller;


import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ncee.dao.model.Users;
import com.ncee.service.IUserService;

@Controller
public class UsersController {
	private final static Logger logger = LogManager.getLogger(UsersController.class);
	@Autowired
	@Qualifier("userService")
	private IUserService usersService;
	
	@RequestMapping(value="/login",method={RequestMethod.POST})
	public ModelAndView login(@RequestParam("loginName") String loginName, @RequestParam("password") String password,ModelAndView mv,HttpSession session){
		System.out.println("UserController login method.");
		Users user = this.usersService.login(loginName, password);
		if(null != user){
			logger.info("Login success with user:{}",user.getUsername());
			mv.setViewName("welcome");
			return mv;
		}
		else{
			mv.addObject("message","User name or password invalid.");
			mv.setViewName("index");
			return mv;
		}
	}
}
