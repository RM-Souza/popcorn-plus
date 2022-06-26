package com.challenge.popcornplus.repository;

import com.challenge.popcornplus.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
