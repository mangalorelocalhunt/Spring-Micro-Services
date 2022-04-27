package com.spring.security.service.google.impl;


import com.spring.security.model.GoogleAccessToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.reactive.function.client.WebClient;

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
    public void verify(String accessToken){
        Map<String, String> keyMap = new HashMap<>();
        keyMap.put("access_token",accessToken);
        client.get().uri("https://oauth2.googleapis.com/tokeninfo?access_token="+accessToken)
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
