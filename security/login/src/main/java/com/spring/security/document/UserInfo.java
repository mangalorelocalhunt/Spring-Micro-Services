package com.spring.security.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Data
@Document("user_info")
public class UserInfo {
    @Id
private String userId;
    private String userName;
    private String profileType;
    private String email;
    private String password;
    private String aadharNo;
    private String phoneNo;
    private Boolean isProfileCompleted;
    private Boolean isPhotoUploaded;
    private Boolean isPaid;
    private String isKYCCompleted;
    private Boolean isActive;
    private LocalDateTime createOn;
    private LocalDateTime UpdatedOn;
}
