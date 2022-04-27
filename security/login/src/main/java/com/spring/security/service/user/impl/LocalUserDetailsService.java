package com.spring.security.service.user.impl;

import com.spring.security.model.user.ApplicationUser;
import com.spring.security.repository.UserInfoRepository;
import com.spring.security.service.user.LocalUserService;
import com.spring.security.service.user.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LocalUserDetailsService implements UserDetailsService, LocalUserService {

    final UserInfoRepository userInfoRepository;
    final UserInfoService userInfoService;

    @Autowired
    public LocalUserDetailsService(UserInfoRepository userInfoRepository, UserInfoService userInfoService) {
        this.userInfoRepository = userInfoRepository;
        this.userInfoService = userInfoService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public void registerUser(ApplicationUser user) {
        userInfoRepository.insert(this.userInfoService.getUserInfo(user));
    }
}
