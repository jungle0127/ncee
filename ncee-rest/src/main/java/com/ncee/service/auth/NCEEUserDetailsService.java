package com.ncee.service.auth;

import com.ncee.dao.model.Users;
import com.ncee.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class NCEEUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users userPojo = userRepository.findUserByUserName(username);
        if(userPojo == null){
            throw  new UsernameNotFoundException(String.format("Can not find the user with user name:%s",userPojo.getUsername()));
        }
        return new User(username,userPojo.getPassword(), AuthorityUtils.commaSeparatedStringToAuthorityList("admin,ROLE_USER"));
    }
}
