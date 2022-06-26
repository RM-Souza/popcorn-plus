package com.challenge.popcornplus.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

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

    public Comment(Integer id, String description, Integer thumbsUp, Integer thumbsDown) {
        this.id = id;
        this.description = description;
        this.thumbsUp = thumbsUp;
        this.thumbsDown = thumbsDown;
    }
}
