package com.spring.security.service.user;

import com.spring.security.model.document.UserInfo;
import com.spring.security.model.user.ApplicationUser;

public interface UserInfoService {

    public UserInfo getUserInfo(ApplicationUser user);
}
