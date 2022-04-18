package com.spring.security.service.user.impl;

import com.spring.security.document.UserInfo;
import com.spring.security.model.LocalUser;
import com.spring.security.repository.UserInfoRepository;
import com.spring.security.service.user.LocalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LocalUserDetailsService implements UserDetailsService, LocalUserService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public LocalUser registerUser(String username, String email) {
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail(email);
        userInfoRepository.insert(userInfo);
        return null;
    }
}
