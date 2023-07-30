package com.faiz.blog.service;

import com.faiz.blog.entity.Post;
import com.faiz.blog.payload.PostDto;
import com.faiz.blog.payload.PostResponse;

import java.util.List;

public interface PostService {

     PostDto createPost(PostDto dto);
     List<PostDto> getAllPost();
     PostDto getPostById(long id);
     PostDto updatePost(PostDto post, long id);
     void delete(long id);
     PostResponse getAllPosts(int pageNo, int pageSize, String sortBy);
}
