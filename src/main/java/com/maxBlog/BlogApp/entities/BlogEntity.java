package com.maxBlog.BlogApp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BlogEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String title;
    private String text;

    // ForiegnKey for user that creates a blog
    // join the user to the created blog
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    // Blog can take many comments from any user
    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<CommentEntity> comments;
}