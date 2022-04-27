package com.spring.security.endpoint;

import com.spring.security.model.Sampled;
import com.spring.security.service.google.impl.GoogleOAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/google")
public class GoogleLoginEndPoint {

    @Autowired
    GoogleOAuthService googleOAuthService;

    @PostMapping("verify")
    public void googleAccessCodeVerify(@RequestBody Sampled sampled) {
        googleOAuthService.verify(sampled.getVal());
    }

}
