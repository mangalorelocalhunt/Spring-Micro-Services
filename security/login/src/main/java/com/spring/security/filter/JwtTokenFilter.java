package com.spring.security.filter;

import com.spring.security.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;



@Component
public class JwtTokenFilter /*extends OncePerRequestFilter*/ {

    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserDetailsService userDetailsService;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        if(SecurityContextHolder.getContext().getAuthentication() == null) {
//            final String token = request.getHeader(HttpHeaders.AUTHORIZATION);
//            if (jwtService.isValid(token)) {
//                UserDetails userDetails = jwtService.getUserDetailsByToken(token);
//                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }
//        filterChain.doFilter(request, response);
//    }
}
