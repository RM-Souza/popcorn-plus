package com.challenge.popcornplus.dto;

import com.challenge.popcornplus.entities.Movie;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.OptionalDouble;

@Getter
@Setter
@NoArgsConstructor
public class MovieDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;
    private Integer year;
    @JsonProperty("MovieScore")
    private OptionalDouble movieScore;
    private Integer comments;

    public MovieDTO(Movie movie) {
        id = movie.getId();
        title = movie.getTitle();
        year = movie.getReleaseDate();
        movieScore = movie.getMovieScore();
        comments = movie.getCommentsNumber();
    }
}
