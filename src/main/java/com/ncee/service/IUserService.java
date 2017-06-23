package com.ncee.service;

import java.util.List;

import com.ncee.dao.model.Users;

public interface IUserService {
	List<Users> getAllUsers();
	Users login(String loginName,String password);
}
