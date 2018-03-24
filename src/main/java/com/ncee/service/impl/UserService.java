package com.ncee.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncee.dao.domain.UsersMapper;
import com.ncee.dao.model.Users;
import com.ncee.service.IUserService;

@Service("userService")
public class UserService implements IUserService {
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UsersMapper userMapper;
	@Override
	public List<Users> getAllUsers(){
		return this.userMapper.selectAll();
	}
	@Override
	public Users login(String loginName,String password){
		Users userPojo = new Users();
		userPojo.setUsername(loginName);
		userPojo.setPassword(password);
		logger.info("Login in with user name:{}",loginName);
		return this.userMapper.selectByLogin(userPojo);
	}
}
