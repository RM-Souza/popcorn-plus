package com.challenge.popcornplus.config;

import com.challenge.popcornplus.dto.MovieDTO;
import com.challenge.popcornplus.entities.Comment;
import com.challenge.popcornplus.entities.Movie;
import com.challenge.popcornplus.entities.Reply;
import com.challenge.popcornplus.entities.User;
import com.challenge.popcornplus.entities.enums.UserRanking;
import com.challenge.popcornplus.repository.CommentRepository;
import com.challenge.popcornplus.repository.MovieRepository;
import com.challenge.popcornplus.repository.ReplyRepository;
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
    private ReplyRepository replyRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "r2d2", "r2d2@gmail.com");
        User u2 = new User(null, "bb8", "bb8@gmail.com");
        User u3 = new User(null, "c3po", "c3po@gmail.com");
        User u4 = new User(null, "lola", "lola@gmail.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));

        Movie m1 = new Movie(null, "Star Wars - Episode IV", 1977);
        Movie m2 = new Movie(null, "Star Wars - Episode IX", 2019);

        movieRepository.saveAll(Arrays.asList(m1, m2));

        Comment c1 = new Comment(5, "Great Movie! I miss Leia so much :(", 2, 1, m1, u1);
        Comment c3 = new Comment(3, "My favorite movie too!", 5, 3, m1, u2);
        Comment c2 = new Comment(2, "My favorite movie!", 3, 3, m2, u2);

        commentRepository.saveAll(Arrays.asList(c1, c2, c3));

        Reply r1 = new Reply("I agree, R2. Princess Leia was the best!", 2, 1, c1, u3);
        Reply r2 = new Reply("C'mon... The Kenobi series is better!", 3, 3, c2, u4);

        replyRepository.saveAll(Arrays.asList(r1, r2));

    }
}