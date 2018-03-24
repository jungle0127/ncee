package com.ncee.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseSetups;
//import com.github.springtestdbunit.annotation.DbUnitConfiguration;

@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration
@TestExecutionListeners({
	DependencyInjectionTestExecutionListener.class,
	DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class,
	DbUnitTestExecutionListener.class})
//@DbUnitConfiguration(databaseConnection = "primaryDataSource")
@AutoConfigureMockMvc
public class UsersServiceTest {
	@Autowired
	private MockMvc mockMvc;
	@Test
	@DatabaseSetups(value= {
			@DatabaseSetup("classpath:dbunit/users.xml"),
			@DatabaseSetup("classpath:dbunit/userrole.xml")
	})
	public void testGetAllUsers() {
		try {
			this.mockMvc.perform(MockMvcRequestBuilders.get("/catalog/provinces").contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
