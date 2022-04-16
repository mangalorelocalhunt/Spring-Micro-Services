package com.spring.security.service.user.impl;

import com.spring.security.model.LocalUser;
import com.spring.security.service.user.LocalUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class LocalUserDetailsService implements UserDetailsService, LocalUserService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public LocalUser registerUser(String username, String email) {
        return null;
    }
}
