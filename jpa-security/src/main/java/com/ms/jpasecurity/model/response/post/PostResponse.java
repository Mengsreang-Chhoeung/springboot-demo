package com.ms.jpasecurity.model.response.post;

import com.ms.jpasecurity.model.entity.PostEntity;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
public class PostResponse implements Serializable {
    public Long id;
    public String title;
    public String slug;
    public String content;
    public String author;
    public LocalDateTime publishedOn;

    public static PostResponse fromEntity(PostEntity entity) {
        return new PostResponse(entity.getId(), entity.getTitle(), entity.getSlug(), entity.getContent(), entity.getAuthor(), entity.getPublishedOn());
    }
}
