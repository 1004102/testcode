package com.sparta.newsfeedhw.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateInfoRequestDto {
    private String password;
    private String introduce;
}
