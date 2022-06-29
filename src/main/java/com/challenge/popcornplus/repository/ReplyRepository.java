package com.challenge.popcornplus.repository;

import com.challenge.popcornplus.entities.Movie;
import com.challenge.popcornplus.entities.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
}
