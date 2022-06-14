package com.stayshubh.blogapp.backend.service;

import com.stayshubh.blogapp.backend.dto.PostDto;
import com.stayshubh.blogapp.backend.entity.Post;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);

    List<PostDto> retrieveAllPosts();

    PostDto getPostById(long id);

    PostDto updatePostById(PostDto postDto, Long id);

    void deletePostById(Long id);


}
