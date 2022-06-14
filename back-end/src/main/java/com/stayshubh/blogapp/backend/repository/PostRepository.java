package com.stayshubh.blogapp.backend.repository;

import com.stayshubh.blogapp.backend.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
}
