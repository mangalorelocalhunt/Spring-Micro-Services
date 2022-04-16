package com.spring.security.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalAuthModel {
    private String googleAccessCode;
    private String device;
    private String deviceId;
    private String jwtToken;
    private String username;
    private Boolean isGoogleSignedIn;
}
