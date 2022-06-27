package com.challenge.popcornplus.resource;

import com.challenge.popcornplus.dto.MovieDTO;
import com.challenge.popcornplus.entities.Movie;
import com.challenge.popcornplus.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDTO>> findAll(){
        List<Movie> movieList = movieService.findAll();
        List<MovieDTO> listDto = movieList
                .stream()
                .map(MovieDTO::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> findById(@PathVariable Integer id){
        Movie movie = movieService.findById(id);
        return ResponseEntity.ok().body(movie);
    }
}