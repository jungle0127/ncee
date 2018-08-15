package com.ncee.service.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseSetups;
import com.ncee.dao.model.Users;
//import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.ncee.service.IUserService;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
// @DbUnitConfiguration(databaseConnection = "primaryDataSource")
public class UsersServiceTest {
	@Autowired
	private IUserService userService;

	@Test
	@DatabaseSetups(value = { @DatabaseSetup("classpath:dbunit/users.xml"),
			@DatabaseSetup("classpath:dbunit/userrole.xml") })
	public void testGetAllUsers() {
		List<Users> userList = this.userService.getAllUsers();
		Assert.assertTrue(userList.size() > 0);
	}

	@Test
	@DatabaseSetups(value = { @DatabaseSetup("classpath:dbunit/users.xml"),
			@DatabaseSetup("classpath:dbunit/userrole.xml") })
	public void testGetUserByLoginName() {
		Users pojo = this.userService.selectUserByLoginName("admin");
		Assert.assertEquals("admin", pojo.getUsername());
	}
}
