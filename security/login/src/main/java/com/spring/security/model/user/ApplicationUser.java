package com.spring.security.model.user;

import com.spring.security.enums.UserProfile;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplicationUser {
    private String email;
    private UserProfile profileType;
    private String aadharNo;
    private String phoneNo;
}
