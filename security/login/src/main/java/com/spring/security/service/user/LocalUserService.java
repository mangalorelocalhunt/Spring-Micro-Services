package com.spring.security.service.user;

import com.spring.security.model.LocalUser;

public interface LocalUserService {

    public LocalUser registerUser(String username,String email);

}
