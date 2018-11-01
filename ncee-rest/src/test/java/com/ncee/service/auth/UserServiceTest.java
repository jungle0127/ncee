package com.ncee.service.auth;

import com.ncee.dao.model.Users;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getUserByUserName() {
        Users pojo = this.userService.getUserByUserName("ps");
        Assert.assertNotNull(pojo);
    }
}