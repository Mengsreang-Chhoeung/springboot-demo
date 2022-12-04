package com.ms.jpasecurity.controller;

import com.ms.jpasecurity.model.entity.PostEntity;
import com.ms.jpasecurity.model.response.post.PostResponse;
import com.ms.jpasecurity.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService _postService) {
        this.postService = _postService;
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping
    public ResponseEntity<List<PostResponse>> findAll() {
        List<PostResponse> data = this.postService.findAll().stream().map(PostResponse::fromEntity).toList();

        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> findOne(@PathVariable Long id) {
        PostEntity data = this.postService.findOne(id).orElse(new PostEntity());

        return ResponseEntity.status(HttpStatus.OK).body(PostResponse.fromEntity(data));
    }
}
