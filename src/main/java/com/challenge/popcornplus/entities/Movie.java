package com.challenge.popcornplus.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_movie")
public class Movie implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    private Integer id;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("Year")
    private Integer releaseDate;

    @OneToMany(mappedBy = "movie")
    private List<Comment> commentList = new ArrayList<>();

    public Movie(Integer id, String title,
                 Integer releaseDate) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
    }

    @JsonIgnore
    public Integer getCommentsNumber() {
        return commentList.size();
    }

    public OptionalDouble getMovieScore() {
        return commentList.stream().mapToDouble(Comment::getMyStarScore).average();
    }
}