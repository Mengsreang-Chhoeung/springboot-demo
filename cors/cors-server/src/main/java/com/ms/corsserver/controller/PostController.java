package com.ms.corsserver.controller;

import com.ms.corsserver.model.response.post.PostResponse;
import com.ms.corsserver.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService _poPostService) {
        this.postService = _poPostService;
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> findAll() {
        List<PostResponse> data = postService.findAll().stream().map(PostResponse::fromEntity).toList();

        return ResponseEntity.status(HttpStatus.OK).body(data);
    }
}
