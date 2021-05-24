package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class FirstentityApplication {

	@Bean
	public WebClient.Builder getWebClienBuilder() {
		return WebClient.builder();
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(FirstentityApplication.class, args);
	}

}
