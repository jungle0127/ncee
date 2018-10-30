package com.ncee.service.auth;

import com.ncee.dao.domain.UsersMapper;
import com.ncee.dao.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users getUserByUserName(String userName){
        return usersMapper.selectByLoginName(userName);
    }

    public boolean addUser(Users userPojo){
        String password = this.passwordEncoder.encode(userPojo.getPassword());
        userPojo.setPassword(password);
        Integer affectedRows = this.usersMapper.insert(userPojo);
        if(affectedRows > 0){
            return true;
        }
        return false;
    }
}
