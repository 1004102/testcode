package com.sparta.newsfeedhw.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private Long newsfeedId;
    private String contents;
}
