package com.spring.security.service.user.impl;

import com.spring.security.model.document.UserInfo;
import com.spring.security.model.user.ApplicationUser;
import com.spring.security.service.user.UserInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Override
    public UserInfo getUserInfo(ApplicationUser user) {
            UserInfo userInfo = new UserInfo();
            userInfo.setUserId(user.getEmail().substring(0, user.getEmail().indexOf('@')));
            userInfo.setAadharNo(user.getAadharNo());
            userInfo.setUserName(user.getEmail().substring(0, user.getEmail().indexOf('@')));
            userInfo.setIsActive(false);
            userInfo.setIsPaid(false);
            userInfo.setIsKYCCompleted(false);
            userInfo.setIsPhotoUploaded(false);
            userInfo.setIsProfileCompleted(false);
            userInfo.setPhoneNo(user.getPhoneNo());
            userInfo.setProfileType(user.getProfileType().name());
            return userInfo;
    }
}
