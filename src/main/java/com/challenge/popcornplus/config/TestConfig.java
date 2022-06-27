package com.challenge.popcornplus.config;

import com.challenge.popcornplus.entities.Comment;
import com.challenge.popcornplus.entities.Movie;
import com.challenge.popcornplus.entities.User;
import com.challenge.popcornplus.entities.enums.UserRanking;
import com.challenge.popcornplus.repository.CommentRepository;
import com.challenge.popcornplus.repository.MovieRepository;
import com.challenge.popcornplus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "bb8", "bb8@gmail.com");
        User u2 = new User(null, "r2d2", "r2d2@gmail.com");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Movie m1 = new Movie(null,"Star Wars - Episode IV",1977,10);
        Movie m2 = new Movie(null, "Star Wars - Episode IX",2019,20);

        movieRepository.saveAll(Arrays.asList(m1, m2));

        Comment c1 = new Comment(5,"Great Movie!", 2, 1, m1, u1);
        Comment c2 = new Comment(2,"Bad Movie!", 3, 3, m2, u2);

        commentRepository.saveAll(Arrays.asList(c1, c2));
    }
}