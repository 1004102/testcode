package com.sparta.newsfeedhw.controller;

import com.sparta.newsfeedhw.dto.NewsFeedRequestDto;
import com.sparta.newsfeedhw.dto.NewsFeedResponseDto;
import com.sparta.newsfeedhw.security.UserDetailsImpl;
import com.sparta.newsfeedhw.service.NewsFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class NewsFeedController {

    public final NewsFeedService newsFeedService;

    //게시물 작성
    @PostMapping("/newsfeeds")
    @ResponseBody
    public NewsFeedResponseDto createNewsFeed(@RequestBody NewsFeedRequestDto request, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return newsFeedService.createNewsFeed(request, userDetails.getUser());
    }

    //전체 게시물 조최 : 누구든 조회 가능
    @GetMapping("/newsfeeds")
    public ResponseEntity<List<NewsFeedResponseDto>> getNewsfeedList(){
        List<NewsFeedResponseDto> response = newsFeedService.getNewsfeedList();
        return ResponseEntity.ok(response);
    }


    //개별 게시물 조회 : 누구든 조회 가능
    @GetMapping("/newsfeeds/{id}")
    public ResponseEntity<NewsFeedResponseDto> getNewsfeed(@PathVariable Long id) {
        NewsFeedResponseDto response = newsFeedService.getNewsfeed(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/newsfeeds/{id}")
    public NewsFeedResponseDto updateNewsFeed (@PathVariable Long id, @RequestBody  NewsFeedRequestDto requestDto, @AuthenticationPrincipal UserDetails userDetails) {
        return newsFeedService.updateNewsFeed(id, requestDto, userDetails);
    }


    //게시물 삭제
    @DeleteMapping("/newsfeeds/{id}")
    public ResponseEntity<String> deleteNewsFeed(@PathVariable Long id,
                                                 @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return newsFeedService.deleteNewsFeed(id,userDetails);
    }

    @GetMapping("/newsfeeds/find")
    public ResponseEntity<?> getAllNewsFeeds() {
        List<NewsFeedResponseDto> newsFeeds = newsFeedService.getAllNewsFeeds();
        if (newsFeeds.isEmpty()) {
            return ResponseEntity.ok("먼저 작성하여 소식을 알려보세요!");
        } else return ResponseEntity.ok(newsFeeds);
    }

}