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
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_reply")
public class Reply implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReply;
    private String description;
    private Integer thumbsUp;
    private Integer thumbsDown;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "reply_id")
    private Comment replyId;


    @ManyToOne
    @JoinColumn(name = "userReplies_id")
    private User userReply;

    public Reply(String description, Integer thumbsUp, Integer thumbsDown, Comment replyId, User userReply) {
        this.description = description;
        this.thumbsUp = thumbsUp;
        this.thumbsDown = thumbsDown;
        this.replyId = replyId;
        this.userReply = userReply;
    }
}