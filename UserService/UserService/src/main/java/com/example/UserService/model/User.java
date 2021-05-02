package com.example.UserService.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    private String username;
    private String password;
}
