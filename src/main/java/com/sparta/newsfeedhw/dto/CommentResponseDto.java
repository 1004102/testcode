package com.sparta.newsfeedhw.dto;

import com.sparta.newsfeedhw.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {
    private String comment;

    public CommentResponseDto(Comment comment) {
        this.comment = comment.getComment();
    }
}
