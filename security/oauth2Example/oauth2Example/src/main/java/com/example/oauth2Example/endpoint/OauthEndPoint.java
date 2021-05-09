package com.example.oauth2Example.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OauthEndPoint {

    @Autowired
    private ClientRegistrationRepository clientRegistrationRepository;
    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;

    @GetMapping("user")
    public String getUser(Authentication authentication) {
        ClientRegistration oktaRegistration =
                this.clientRegistrationRepository.findByRegistrationId("google");
        OAuth2AuthorizedClient authorizedClient =
                this.authorizedClientService.loadAuthorizedClient("okta", authentication.getName());
        OAuth2AccessToken accessToken = authorizedClient.getAccessToken();
        return "Hello USER";
    }

    @GetMapping("users")
    public String getUser() {
        return "Hello USER";
    }
}
