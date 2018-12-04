package com.ncee.service.auth;

import com.ncee.dao.model.Users;
import com.ncee.dao.repository.UserRepository;
import com.ncee.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Boolean addUser(User user){
        Users userDO = new Users();
        userDO.setPassword(user.getPassword());
        userDO.setPhoneNumber(user.getPhoneNumber());
        userDO.setRoleid(user.getRoleId());
        userDO.setUsername(user.getUserName());
        userDO.setActive(1);
        return this.userRepository.addUser(userDO);
    }
}
