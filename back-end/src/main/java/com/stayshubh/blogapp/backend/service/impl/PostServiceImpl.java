package com.stayshubh.blogapp.backend.service.impl;

import com.stayshubh.blogapp.backend.dto.PostDto;
import com.stayshubh.blogapp.backend.entity.Post;
import com.stayshubh.blogapp.backend.exception.ResourceNotFoundException;
import com.stayshubh.blogapp.backend.repository.PostRepository;
import com.stayshubh.blogapp.backend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        //Convert Dto to entity
        Post post = mapToEntity(postDto);

        Post newPost = postRepository.save(post);

        //Convert Entity to Dto

        PostDto postResponse = mapToDto(newPost);


        return postResponse;
    }

    @Override
    public List<PostDto> retrieveAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
        return mapToDto(post);
    }

    @Override
    public PostDto getPostBySlug(String slug) {
        Post post = postRepository.findBySlug(slug);
        return mapToDto(post);
    }

    @Override
    public PostDto updatePostById(PostDto postDto, Long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
        post.setAuthorId(postDto.getAuthorId());
        post.setParentPostId(postDto.getParentPostId());
        post.setTitle(postDto.getTitle());
        post.setThumbnail(postDto.getThumbnail());
        post.setMetaTitle(postDto.getMetaTitle());
        post.setSlug(postDto.getSlug());
        post.setSummary(postDto.getSummary());
        post.setPublished(postDto.getPublished());
        post.setCreatedAt(postDto.getCreatedAt());
        post.setUpdatedAt(postDto.getUpdatedAt());
        post.setPublishedAt(postDto.getPublishedAt());
        post.setContent(postDto.getContent());

        Post updatedPost = postRepository.save(post);
        return mapToDto(updatedPost);
    }

    @Override
    public void deletePostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post", "id", id));
        postRepository.delete(post);
    }

    private PostDto mapToDto(Post post){
        PostDto postDto = new PostDto();

        postDto.setId(post.getId());
        postDto.setAuthorId(post.getAuthorId());
        postDto.setParentPostId(post.getParentPostId());
        postDto.setTitle(post.getTitle());
        postDto.setThumbnail(post.getThumbnail());
        postDto.setMetaTitle(post.getMetaTitle());
        postDto.setSlug(post.getSlug());
        postDto.setSummary(post.getSummary());
        postDto.setPublished(post.getPublished());
        postDto.setCreatedAt(post.getCreatedAt());
        postDto.setUpdatedAt(post.getUpdatedAt());
        postDto.setPublishedAt(post.getPublishedAt());
        postDto.setContent(post.getContent());
        return postDto;
    }

    //Dto to Entity
    private Post mapToEntity(PostDto postDto){
        Post post = new Post();
        post.setAuthorId(postDto.getAuthorId());
        post.setParentPostId(postDto.getParentPostId());
        post.setTitle(postDto.getTitle());
        post.setThumbnail(postDto.getThumbnail());
        post.setMetaTitle(postDto.getMetaTitle());
        post.setSlug(postDto.getSlug());
        post.setSummary(postDto.getSummary());
        post.setPublished(postDto.getPublished());
        post.setCreatedAt(postDto.getCreatedAt());
        post.setUpdatedAt(postDto.getUpdatedAt());
        post.setPublishedAt(postDto.getPublishedAt());
        post.setContent(postDto.getContent());
        return post;
    }
}
