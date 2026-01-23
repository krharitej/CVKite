package com.cvkite.cvkite_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

//Registers User account
@Data
public class RegisterRequest {

    //validation annotations form validation dependency to validate user inputs
    @Email(message = "Enter a valid email")
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Password is required")
    @Size(min = 8, message = "Password should be at least 8 characters")
    private String password;
    private String profileImgUrl;

}
