package dev.gxsoft.blogrestjpa.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long postId;
    private long userId;
    private String title;
    private String description;
    private String body;
    private String createdDate;
    private String modifiedDate;
    private String type;

    @OneToMany(mappedBy = "postId")
    private List<Comment> comments;

    public Post() {
        this.createdDate = LocalDate.now().toString();
    }

    public Post(String title, String description, String body, String type) {
        this.title = title;
        this.description = description;
        this.body = body;
        this.type = type;
        this.createdDate = LocalDate.now().toString();
    }
}
