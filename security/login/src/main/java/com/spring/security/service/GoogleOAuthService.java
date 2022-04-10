package com.spring.security.service;

import com.spring.security.model.MyMateUser;

import java.io.IOException;
import java.security.GeneralSecurityException;

public interface GoogleOAuthService {

public void verify(String idTokenString);

}
