package com.challenge.popcornplus.entities;

import com.challenge.popcornplus.entities.enums.UserRanking;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Table(name = "tb_user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nickname;
    private String email;
    private String ranking = UserRanking.READER.getUserRanking();
    private Double score;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Comment> commentList = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "userReply")
    private List<Reply> replyList = new ArrayList<>();

    public User(Integer id, String nickname, String email) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
    }

    //constructor for update
    public User(Integer id, UserRanking userRanking) {
        this.id = id;
        setUserRanking(userRanking);
    }

    public void setUserRanking(UserRanking userRanking) {
        if (userRanking != null) {
            this.ranking = userRanking.getUserRanking();
        }
    }
}