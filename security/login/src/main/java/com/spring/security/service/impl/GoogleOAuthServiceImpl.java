package com.spring.security.service.impl;


import com.spring.security.model.GoogleAccessToken;
import com.spring.security.model.MyMateUser;
import com.spring.security.service.GoogleOAuthService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Service
public class GoogleOAuthServiceImpl implements GoogleOAuthService {

    private WebClient client;

    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String googleClientId;

    public GoogleOAuthServiceImpl() {
        client = WebClient.create();
    }

    @Override
    public void verify(String idTokenString){
        Map<String, String> keyMap = new HashMap<>();
        keyMap.put("access_token",idTokenString);
        client.get().uri("https://oauth2.googleapis.com/tokeninfo?access_token="+idTokenString)
        .retrieve().bodyToMono(GoogleAccessToken.class)
                .subscribe(this::isValidGoogleAccessToken);
    }

    private void isValidGoogleAccessToken(GoogleAccessToken googleAccessToken) {
        Assert.notNull(googleAccessToken, "Google Access Token must not be null");
        if(Objects.equals(googleClientId,googleAccessToken.getAud()) &&
                Objects.equals(googleClientId,googleAccessToken.getAzp())) {
            System.out.println(googleAccessToken.getExpiresIn());
            System.out.println(googleAccessToken.getScope());
        } else {
            throw new RuntimeException("Invalid  Google Access Token ");
        }
    }
}
