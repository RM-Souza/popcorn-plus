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
        int i = 0;
        for (Comment c : commentList) {
            i++;
        }
        return i;
    }

    public Double getMovieScore() {
        double avg = 0.0;
        for (Comment c : commentList) {
             avg += c.getMyStarScore();
        }
        return avg / commentList.size();
    }
}