package com.challenge.popcornplus.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_comment")
public class Comment implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private Integer thumbsUp;
    private Integer thumbsDown;
    private Integer myStarScore;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User user;

    public Comment(Integer myStarScore, String description, Integer thumbsUp,
                   Integer thumbsDown, Movie movie, User user) {
        this.myStarScore = myStarScore;
        this.description = description;
        this.thumbsUp = thumbsUp;
        this.thumbsDown = thumbsDown;
        this.movie = movie;
        this.user = user;
    }
}