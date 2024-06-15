package com.sparta.newsfeedhw.dto;

import com.sparta.newsfeedhw.entity.NewsFeed;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class NewsFeedResponseDto {
    private Long id;
    private String contents;

    public NewsFeedResponseDto(NewsFeed newsFeed) {
        this.id = newsFeed.getId();
        this.contents=newsFeed.getContents();
    }
}