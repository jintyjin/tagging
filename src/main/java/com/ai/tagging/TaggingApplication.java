package com.ai.tagging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TaggingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaggingApplication.class, args);
	}

}
