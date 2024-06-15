package com.sparta.newsfeedhw.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserInfoResponseDto {
    String username;
    String name;
    String email;
    String introduce;
}