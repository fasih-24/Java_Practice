package com.faiz.blog.controller;

import com.faiz.blog.entity.Post;
import com.faiz.blog.payload.PostDto;
import com.faiz.blog.payload.PostResponse;
import com.faiz.blog.service.PostService;
import com.faiz.blog.service.impl.PostServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    //Create Post API
    @PostMapping("/createPost")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto dto){
        PostDto response = postService.createPost(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPost(){
        return new ResponseEntity<List<PostDto>>(postService.getAllPost(),HttpStatus.OK);
    }
    //Pagination support API
    @GetMapping()
    public PostResponse getAllPostWithPagination(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10",required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy
    ){
        return postService.getAllPosts(pageNo, pageSize, sortBy);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }
    //Update Post by Id
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable(name = "id") long id){
        PostDto res = postService.updatePost(postDto, id);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    //Delete Post API
    @DeleteMapping("/{id}")
    public ResponseEntity deletePost(@PathVariable long id){
        postService.delete(id);
        return new ResponseEntity<>("Post Entity Dleted Successfully", HttpStatus.OK);
    }

}
