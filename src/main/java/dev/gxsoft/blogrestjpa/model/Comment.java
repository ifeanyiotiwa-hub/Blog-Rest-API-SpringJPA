package dev.gxsoft.blogrestjpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "comments")
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long commentId;


    private long postId;

    private long userId;

    @Column(name = "body", nullable = false)
    private String commentBody;
    private LocalDateTime time;


    public Comment() {
        this.time = LocalDateTime.now();
    }

    public Comment(int commentId, int userId, int postId, String commentBody) {
        this.commentId = commentId;
        this.userId = userId;
        this.postId = postId;
        this.commentBody = commentBody;
        this.time = LocalDateTime.now();
    }
}
