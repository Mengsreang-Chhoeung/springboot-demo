package com.ms.corsserver.service;

import com.ms.corsserver.model.entity.PostEntity;
import com.ms.corsserver.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository _postRepository) {
        this.postRepository = _postRepository;
    }

    public List<PostEntity> findAll() {
        return postRepository.findAll();
    }
}
