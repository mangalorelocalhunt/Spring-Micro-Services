package com.spring.security.endpoint;

import com.spring.security.model.user.ApplicationUser;
import com.spring.security.service.user.LocalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoEndpoint {

    final LocalUserService localUserService;

    @Autowired
    public UserInfoEndpoint(LocalUserService localUserService) {
        this.localUserService = localUserService;
    }

    @PostMapping("createUser")
    public ResponseEntity createUser(@RequestBody ApplicationUser applicationUser) {
        this.localUserService.registerUser(applicationUser);
        return ResponseEntity.noContent().build();
    }
}
