package com.ms.jpasecurity.service;

import com.ms.jpasecurity.model.entity.PostEntity;
import com.ms.jpasecurity.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository _postRepository) {
        this.postRepository = _postRepository;
    }

    public List<PostEntity> findAll() {
        return this.postRepository.findAll();
    }

    public Optional<PostEntity> findOne(Long id) {
        return this.postRepository.findById(id);
    }
}
