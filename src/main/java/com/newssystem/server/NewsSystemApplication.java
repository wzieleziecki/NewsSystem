package com.newssystem.server;

import com.newssystem.server.domain.Comment;
import com.newssystem.server.domain.News;
import com.newssystem.server.repository.CommentRepository;
import com.newssystem.server.service.CommentService;
import com.newssystem.server.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan
public class NewsSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(NewsSystemApplication.class, args);
	}

	@Autowired
	public NewsService newsService;

	@Autowired
	public CommentService commentService;

	@Override
	public void run(String... args) throws Exception {

		News newsObj = new News("to jest treść", "10.03.2017", "Urodziny","");
		newsService.create(newsObj);

		Comment commentObj = new Comment("1234", "Iza", "10.03.2017", "Wszystkiego najlepszego");
		commentService.create(commentObj);

	}
}
