package com.ncee.service.auth;

import com.ncee.dao.domain.UsersMapper;
import com.ncee.dao.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
public class UserService {
    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private final String REGEX_MOBILE = "((^(13|15|18)[0-9]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";
    public Users getUserByUserName(String userName){
        if(isMobile(userName)){
            return usersMapper.selectByPhoneNumber(userName);
        }
        else{
            return usersMapper.selectByLoginName(userName);
        }
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

    private boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }
}
