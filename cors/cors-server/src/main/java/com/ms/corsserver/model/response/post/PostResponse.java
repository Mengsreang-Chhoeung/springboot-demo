package com.ms.corsserver.model.response.post;

import com.ms.corsserver.model.entity.PostEntity;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.time.ZoneId;

@AllArgsConstructor
public class PostResponse implements Serializable {
    public Long id;
    public String title;
    public String slug;
    public String content;
    public String author;
    public Long publishedOn;

    public static PostResponse fromEntity(PostEntity entity) {
        return new PostResponse(entity.getId(), entity.getTitle(), entity.getSlug(), entity.getContent(), entity.getAuthor(), entity.getPublishedOn().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
    }
}
