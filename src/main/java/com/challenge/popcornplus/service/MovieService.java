package com.challenge.popcornplus.service;

import com.challenge.popcornplus.entities.Movie;
import com.challenge.popcornplus.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Movie findById(Integer id) {
        Optional<Movie> obj = movieRepository.findById(id);
        return obj.get();
    }
}