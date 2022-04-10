package com.spring.security.service;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Service
public class JwtService {
    private static final String JWT_SECRET_KEY = "sample!@TTTt%$^%4645645645645645645645";
    private static final String JWT_SUBJECT = " TOKEN_AUTH";
    private static final String USERNAME_CLAIM = "username";
    private static final String BEARER = "Bearer";
    private static final String ERROR_MSG = "Invalid Token";
    private final UserDetailsService userDetailsService;

    public JwtService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public String generate(UserDetails userDetails) {
        return BEARER + Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject(userDetails.getUsername() + JWT_SUBJECT)
                .claim(USERNAME_CLAIM, userDetails.getUsername())
                .setIssuedAt(Date.from(LocalDate.now().atStartOfDay(ZoneId.of(ZoneId.SHORT_IDS.get("IST"))).toInstant()))
                .setExpiration(Date.from(LocalDate.now().atStartOfDay(ZoneId.of(ZoneId.SHORT_IDS.get("IST"))).plusDays(1)
                        .toInstant()))
                .signWith(getSecretKey())
                .compact();
    }

    public SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(JWT_SECRET_KEY.getBytes(StandardCharsets.UTF_8));
    }

    public boolean isValid(String token) {
        return (Objects.nonNull(token) && token.startsWith(BEARER)) ?
             Optional.ofNullable(getUserDetails(String.valueOf(getJwtBody(token).get("username")))).isPresent()
        :         Boolean.FALSE;
    }

    private UserDetails getUserDetails(String username) {
        return userDetailsService.loadUserByUsername(username);
    }

    public UserDetails getUserDetailsByToken(String token) {
        return userDetailsService.loadUserByUsername(String.valueOf(getJwtBody(token).get("username")));
    }

    private Map getJwtBody(String token) {
        token = removeBerear(token);
        Jwt jwt = Jwts.parserBuilder().setSigningKey(JWT_SECRET_KEY.getBytes(StandardCharsets.UTF_8)).build().parse(token);
        return (Map<String, Object>) jwt.getBody();
    }


    private String removeBerear(String token) {
        return token.replace(BEARER, "");
    }
}
