package com.ms.jpasecurity;

import com.ms.jpasecurity.model.entity.PostEntity;
import com.ms.jpasecurity.model.request.post.PostRequest;
import com.ms.jpasecurity.model.request.user.UserRequest;
import com.ms.jpasecurity.repository.PostRepository;
import com.ms.jpasecurity.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@SpringBootApplication
public class JpaSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaSecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PostRepository postRepository, UserRepository userRepository, PasswordEncoder encoder) {
		return args -> {
			UserRequest user1 = new UserRequest("user", encoder.encode("123456"), "ROLE_USER");
			UserRequest user2 = new UserRequest("admin", encoder.encode("123456"), "ROLE_ADMIN");
			PostRequest post1 = new PostRequest("Post 1", "post-1", "Welcome to Post One!", "mengsreang-chhoeung", LocalDateTime.of(2022, 11, 25, 20, 20));
			PostRequest post2 = new PostRequest("Post 2", "post-2", "Welcome to Post Two!", "mengsreang-chhoeung", LocalDateTime.of(2022, 10, 25, 20, 20));
			userRepository.save(user1.toEntity());
			userRepository.save(user2.toEntity());
			postRepository.save(post1.toEntity());
			postRepository.save(post2.toEntity());
		};
	}

}
