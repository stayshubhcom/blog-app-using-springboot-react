package com.stayshubh.blogapp.backend.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class PostDto {
    private Long id;
    private Long authorId;
    private Long parentPostId;
    private String title;
    private String thumbnail;
    private String metaTitle;
    private String slug;
    private String summary;
    private int published;
    private Date createdAt;
    private Date updatedAt;
    private Date publishedAt;
    private String content;
}
