package com.challenge.popcornplus.resource;

import com.challenge.popcornplus.entities.Movie;
import com.challenge.popcornplus.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> findAll(){
        List<Movie> movieList = movieService.findAll();
        return ResponseEntity.ok().body(movieList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> findById(@PathVariable Integer id){
        Movie movie = movieService.findById(id);
        return ResponseEntity.ok().body(movie);
    }
}