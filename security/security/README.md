# Spring-Micro-Services
Exploring Spring boot features


---------------------------------- JWT TOKEN ------------------------------------------------------
use /login with username and password parameters 
response will return jwt berear token in header by adding it to authorization key
whenever invoking invoke with same token



---------------------------------- OAUTH2 CLIENT ------------------------------------------------------

To Invoke login with google manual user need to enter below link in address bar
http://localhost:8080/oauth2/authorization/google

Initially user need to create project to get secret key from google
https://console.cloud.google.com/apis/credential

then enter redirect URL in google

http://localhost:8080/login/oauth2/code/google

    private ClientRegistration googleClientRegistration() {
        return ClientRegistration.withRegistrationId("google")
                .clientId("1024563174309-qmdmlfbtg5j4mbq01shl302dr3ugij2a.apps.googleusercontent.com")
                .clientSecret("j-BErF_z9-fNf-2Ttz0ucPX5")
                .clientAuthenticationMethod(ClientAuthenticationMethod.BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .redirectUri("http://localhost:8080/login/oauth2/code/google")
                .scope("openid", "profile", "email", "address", "phone")
                .authorizationUri("https://accounts.google.com/o/oauth2/v2/auth")
                .tokenUri("https://www.googleapis.com/oauth2/v4/token")
                .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
                .userNameAttributeName(IdTokenClaimNames.SUB)
                .jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
                .clientName("Google")
                .build();
    }


OAuth2LoginAuthenticationFilter is responsible to attempt authentication

CommonOAuth2Provider class have all the details about providers like google, facebook etc 