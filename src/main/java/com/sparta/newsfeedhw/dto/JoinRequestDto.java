package com.sparta.newsfeedhw.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class JoinRequestDto {
    private String username;
    private String password;
}