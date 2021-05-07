package com.spring.security.filter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        AbstractAuthenticationToken abstractAuthenticationToken =new UsernamePasswordAuthenticationToken(
                request.getParameter("username"),
                request.getParameter("password")
        );
        return this.authenticationManager.authenticate(abstractAuthenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String key="sample!@TTTt%$^%4645645645645645645645";
        var token = Jwts.builder().setSubject(authResult.getName())
                .claim("authorities",authResult.getAuthorities())
                .setIssuedAt(Date.from(LocalDate.now().atStartOfDay(ZoneId.of(ZoneId.SHORT_IDS.get("IST"))).toInstant()))
                .setExpiration(Date.from(LocalDate.now().atStartOfDay(ZoneId.of(ZoneId.SHORT_IDS.get("IST"))).plusMinutes(20)
                        .toInstant()))
                .signWith(Keys.hmacShaKeyFor(key.getBytes()))
                .compact();
        response.addHeader(HttpHeaders.AUTHORIZATION, token);
    }
}
