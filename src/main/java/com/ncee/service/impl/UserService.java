package com.ncee.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncee.dao.domain.UsersMapper;
import com.ncee.dao.model.Users;
import com.ncee.service.IUserService;

@Service("userService")
public class UserService implements IUserService {
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
		return this.userMapper.selectByLogin(userPojo);
	}
}
