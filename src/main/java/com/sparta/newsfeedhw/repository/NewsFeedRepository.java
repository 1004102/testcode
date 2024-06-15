package com.sparta.newsfeedhw.repository;

import com.sparta.newsfeedhw.entity.NewsFeed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsFeedRepository extends JpaRepository<NewsFeed, Long> {
    List<NewsFeed> findAllByOrderByCreatedAtDesc();


}
