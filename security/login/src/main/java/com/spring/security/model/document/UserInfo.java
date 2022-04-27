package com.spring.security.model.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;


@Data
@Document("user_info")
@CompoundIndexes({
        @CompoundIndex(name = "email_aadharNo_phoneNo_idx", def = "{'email' : 1,'aadharNo': 1, 'phoneNo':1}", unique = true, background = true)})
public class UserInfo {

    @Id
    private String id;
    @Indexed(unique=true)
    private String email;
    @Indexed(unique=true)
    private String userId;
    private String userName;
    private String profileType;
    private String password;
    @Indexed(unique=true)
    private String aadharNo;
    @Indexed(unique=true)
    private String phoneNo;
    private Boolean isProfileCompleted;
    private Boolean isPhotoUploaded;
    private Boolean isPaid;
    private Boolean isKYCCompleted;
    private Boolean isActive;
    private LocalDateTime createOn;
    private LocalDateTime UpdatedOn;
}
