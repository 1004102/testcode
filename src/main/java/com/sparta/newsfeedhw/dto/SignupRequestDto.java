package com.sparta.newsfeedhw.dto;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SignupRequestDto {
    private String username;
    private String password;
    private String name;
    @Email
    private String email;
    private String introduce;
    private boolean isRole = false;
    private String role = "";
    private String refreshToken = "";
}

