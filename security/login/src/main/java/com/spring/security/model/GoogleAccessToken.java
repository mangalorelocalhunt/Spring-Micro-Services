package com.spring.security.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoogleAccessToken {
    private String azp;
    private String aud;
    private String sub;
    private String scope;
    private String exp;
    private String expiresIn;
    private String email;
    private Boolean emailVerified;
    private String accessType;
}
