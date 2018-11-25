package com.ncee.service.auth;

import com.ncee.dao.domain.UsersMapper;
import com.ncee.dao.model.Users;
import com.ncee.dao.repository.UserRepository;
import com.ncee.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Boolean addUser(User user){
        Users userDO = new Users();
        userDO.setPassword(user.getPassword());
        userDO.setPhoneNumber(user.getPhoneNumber());
        userDO.setRoleid(user.getRoleId());
        userDO.setUsername(user.getUserName());
        return this.userRepository.addUser(userDO);
    }
}
