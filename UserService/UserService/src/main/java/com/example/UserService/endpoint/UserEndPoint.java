package com.example.UserService.endpoint;

import com.example.UserService.model.User;
import com.example.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserEndPoint {

    private final UserService userService;

    @Autowired
    public UserEndPoint(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public User getUser() {
        return this.userService.getUser();
    }
}
