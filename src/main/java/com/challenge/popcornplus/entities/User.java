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
@Table(name = "tb_user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nickname;
    private String email;
    private Integer ranking;
    private Integer score;


    public User(Integer id, String nickname, String email, Integer ranking, Integer score) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.ranking = ranking;
        this.score = score;
    }
}
