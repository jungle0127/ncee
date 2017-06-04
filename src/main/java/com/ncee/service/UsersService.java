package com.ncee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncee.dao.domain.UsersMapper;
import com.ncee.dao.model.Users;

@Service("userService")
public class UsersService implements IUsersService {
	@Autowired
	private UsersMapper userMapper;
	public List<Users> getAllUsers(){
		return this.userMapper.selectAll();
	}
}
