package com.sparta.newsfeedhw.repository;

import com.sparta.newsfeedhw.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
