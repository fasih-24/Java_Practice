package com.faiz.blog.service.impl;

import com.faiz.blog.entity.Post;
import com.faiz.blog.exception.ResourseNotFoundException;
import com.faiz.blog.payload.PostDto;
import com.faiz.blog.payload.PostResponse;
import com.faiz.blog.repository.PostRepository;
import com.faiz.blog.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto dto) {

        // convert PostDto to Entity
        Post post = mapToPost(dto);

        Post resPost = postRepository.save(post);

        // convert Entity to PostDto
        PostDto postDto = mapToPostDto(resPost);

        return postDto;
    }

    @Override
    public List<PostDto> getAllPost() {

        List<Post> postList = postRepository.findAll();
        List<PostDto> list = postList.stream().map(post->mapToPostDto(post)).collect(Collectors.toList());
        return list;
    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("post", "id", id));
        return mapToPostDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post getPost = postRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("post", "id", id));
        getPost.setTitle(postDto.getTitle());
        getPost.setContent(postDto.getContent());
        getPost.setDescription(postDto.getDescription());
        Post post = postRepository.save(getPost);
        return mapToPostDto(post);
    }

    @Override
    public void delete(long id) {
        Post post = postRepository.findById(id).orElseThrow(()-> new ResourseNotFoundException("post", "id", id));
        postRepository.delete(post);
    }

    @Override
    public PostResponse getAllPosts(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

        Page<Post> posts = postRepository.findAll(pageable);
        List<Post> postList = posts.getContent();
        List<PostDto> list = postList.stream().map(post->mapToPostDto(post)).collect(Collectors.toList());
        PostResponse postResponse = new PostResponse();
        postResponse.setContent(list);
        postResponse.setPageNo(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setTotalElements(posts.getNumberOfElements());
        postResponse.setTotalPages(posts.getTotalPages());
        postResponse.setLast(posts.isLast());


        return postResponse;
    }


    private Post mapToPost(PostDto dto){
        Post post = new Post();
        post.setId(dto.getId());
        post.setTitle(dto.getTitle());
        post.setDescription(dto.getDescription());
        post.setContent(dto.getContent());
        return post;
    }
    private PostDto mapToPostDto(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }


}
