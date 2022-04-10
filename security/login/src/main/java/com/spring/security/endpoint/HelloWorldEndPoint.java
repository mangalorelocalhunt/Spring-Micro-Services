package com.spring.security.endpoint;

import com.spring.security.model.Sampled;
import com.spring.security.service.GoogleOAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
public class HelloWorldEndPoint {

    @Autowired
    GoogleOAuthService googleOAuthService;

    @GetMapping("api/user")
    public String helloUser() {
        return "Hello User";
    }

    @GetMapping("api/admin")
    public String helloAdmin() {
        return "Hello Admin";
    }
}
