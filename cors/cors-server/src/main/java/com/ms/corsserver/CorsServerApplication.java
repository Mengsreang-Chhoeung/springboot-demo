package com.ms.corsserver;

import com.ms.corsserver.model.request.post.PostRequest;
import com.ms.corsserver.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class CorsServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CorsServerApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PostRepository postRepository) {
		return args -> {
			PostRequest post1 = new PostRequest("Post 1", "post-1", "Welcome to Post One!", "mengsreang-chhoeung", LocalDateTime.of(2022, 11, 25, 20, 20));
			PostRequest post2 = new PostRequest("Post 2", "post-2", "Welcome to Post Two!", "mengsreang-chhoeung", LocalDateTime.of(2022, 10, 25, 20, 20));
			PostRequest post3 = new PostRequest("Post 3", "post-3", "Welcome to Post Three!", "mengsreang-chhoeung", LocalDateTime.of(2022, 11, 12, 20, 20));
			PostRequest post4 = new PostRequest("Post 4", "post-4", "Welcome to Post Four!", "mengsreang-chhoeung", LocalDateTime.of(2022, 10, 21, 20, 20));
			postRepository.save(post1.toEntity());
			postRepository.save(post2.toEntity());
			postRepository.save(post3.toEntity());
			postRepository.save(post4.toEntity());
		};
	}

}
