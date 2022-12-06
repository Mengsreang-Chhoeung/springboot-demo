package com.ms.corsserver.model.request.post;

import com.ms.corsserver.model.entity.PostEntity;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
public class PostRequest implements Serializable {
    public String title;
    public String slug;
    public String content;
    public String author;
    public LocalDateTime publishedOn;

    public PostEntity toEntity() {
        PostEntity post = new PostEntity();
        post.setTitle(this.title);
        post.setSlug(this.slug);
        post.setContent(this.content);
        post.setAuthor(this.author);
        post.setPublishedOn(this.publishedOn);

        return post;
    }
}
