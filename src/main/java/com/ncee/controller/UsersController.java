package com.ncee.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ncee.dao.model.Users;
import com.ncee.service.IUsersService;

@Controller
public class UsersController {
	@Autowired
	@Qualifier("userService")
	private IUsersService usersService;
	
	@RequestMapping(value="/users")
	public ModelAndView login(String loginName,String password,ModelAndView mv,HttpSession session){
		Users user = this.usersService.getAllUsers().get(0);
		return null;
	}
}
