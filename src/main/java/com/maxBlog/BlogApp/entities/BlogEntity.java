package com.maxBlog.BlogApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

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
    private String author;
}
