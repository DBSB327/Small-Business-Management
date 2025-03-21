package com.pm.smallbusinessmanagement.dto;

import lombok.Data;

@Data
public class SignUpRequest {

    private String username;
    private String email;
    private String phoneNumber;
    private String password;

}
