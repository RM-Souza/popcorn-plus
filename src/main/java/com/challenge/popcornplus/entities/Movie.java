package com.challenge.popcornplus.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    private Integer id;
    private String title;
    private Integer releaseDate;
    private Integer popcornPlusScore;

    @OneToMany(mappedBy = "movie")
    private List<Comment> commentList = new ArrayList<>();

    public Movie(Integer id,
                 String title,
                 Integer releaseDate,
                 Integer popcornPlusScore) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.popcornPlusScore = popcornPlusScore;
    }
}