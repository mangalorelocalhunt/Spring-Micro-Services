package com.spring.security.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldEndPoint {
    @GetMapping("user")
    public String helloUser() {
        return "Hello User";
    }

    @GetMapping("admin")
    public String helloAdmin() {
        return "Hello Admin";
    }
}
