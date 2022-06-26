package com.challenge.popcornplus.config;

import com.challenge.popcornplus.entities.User;
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

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "bb8", "bb8@gmail.com",1,1);
        User u2 = new User(null, "r2d2", "r2d2@gmail.com",1,1);

        userRepository.saveAll(Arrays.asList(u1, u2));
    }

}