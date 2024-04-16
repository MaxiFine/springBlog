package com.maxBlog.BlogApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CommentEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String text;  // comment

    // Join user to the comment entity
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    // Many comments can belong to one blog
    @ManyToOne
    @JoinColumn(name = "blog_id")
    private BlogEntity blog;

    // If you want to allow multiple users to comment on the same blog entity,
    // you can remove the @JoinColumn from the User entity and add a ManyToOne
    // relationship with User.
//    @ManyToOne
//    private User commentator;

}
