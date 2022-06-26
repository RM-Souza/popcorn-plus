package com.challenge.popcornplus.resource;

import com.challenge.popcornplus.entities.Comment;
import com.challenge.popcornplus.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/comments")
public class CommentResource {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Comment>> findAll(){
        List<Comment> commentList = commentService.findAll();
        return ResponseEntity.ok().body(commentList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Comment> findById(@PathVariable Integer id){
        Comment comment = commentService.findById(id);
        return ResponseEntity.ok().body(comment);
    }
}