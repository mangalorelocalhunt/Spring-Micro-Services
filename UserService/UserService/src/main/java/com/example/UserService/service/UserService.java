package com.example.UserService.service;

import com.example.UserService.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User getUser() {
        return User.builder().username("suman").password("password").build();
    }
}
