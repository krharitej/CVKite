package com.cvkite.cvkite_service.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

//Data class to store user data for sessions and logins
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collation = "users")
public class User {

    private String id;
    private String name;
    private String email;
    private String password;
    private String profileImgUrl;
    private String subscriptionPlan = "basic";
    private String verificationToken;

    private boolean emailVerified = false;

    private LocalDateTime verificationExpiry;

    //annotations to automatically update the fields when a new entry is created or updated i the database
    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

}
