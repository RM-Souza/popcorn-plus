package com.challenge.popcornplus.service;

import com.challenge.popcornplus.entities.Comment;
import com.challenge.popcornplus.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    public Comment findById(Integer id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.get();
    }
}
