package com.challenge.popcornplus.dto;

import com.challenge.popcornplus.entities.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class MovieDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;
    private Integer year;
    private Double movieScore;
    private Integer comments;

    public MovieDTO(Movie movie) {
        id = movie.getId();
        title = movie.getTitle();
        year = movie.getReleaseDate();
        movieScore = movie.getMovieScore();
        comments = movie.getCommentsNumber();
    }
}
