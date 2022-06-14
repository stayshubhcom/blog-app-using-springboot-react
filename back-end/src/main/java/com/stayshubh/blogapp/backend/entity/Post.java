package com.stayshubh.blogapp.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name =  "post", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"}), @UniqueConstraint(columnNames = {"slug"})})
public class Post {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "authorId", columnDefinition = "bigint NOT NULL")
    private Long authorId;

    @Column(name = "parentPostId", columnDefinition = "bigint DEFAULT NULL")
    private Long parentPostId;

    @Column(name = "title", columnDefinition = "nvarchar(100) NOT NULL")
    private String title;

    @Column(name = "thumbnail", columnDefinition = "nvarchar(500) DEFAULT NULL")
    private String thumbnail;

    @Column(name = "metaTitle", columnDefinition = "nvarchar(100) DEFAULT NULL")
    private String metaTitle;

    @Column(name = "slug", columnDefinition = "nvarchar(100) NOT NULL")
    private String slug;

    @Column(name = "summary", columnDefinition = "text DEFAULT NULL")
    private String summary;

    @Column(name = "published", columnDefinition = "tinyint(1) NOT NULL DEFAULT 0")
    private int published;

    @Column(name = "createdAt", columnDefinition = "datetime NOT NULL")
    private Date createdAt;

    @Column(name = "updatedAt", columnDefinition = "datetime NULL DEFAULT NULL")
    private Date updatedAt;

    @Column(name = "publishedAt", columnDefinition = "datetime DEFAULT NULL")
    private Date publishedAt;

    @Column(name = "content", columnDefinition = "text DEFAULT NULL")
    private String content;
}
