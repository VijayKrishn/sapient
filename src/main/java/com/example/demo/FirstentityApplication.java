package com.example.demo;

import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;

@SpringBootApplication
public class FirstentityApplication {

	@Bean
	public WebClient createWebClient() throws SSLException {
		SslContext sslContext = SslContextBuilder
				.forClient()
				.trustManager(InsecureTrustManagerFactory.INSTANCE)
				.build();
		HttpClient httpClient = HttpClient.create().secure(t -> t.sslContext(sslContext) ).followRedirect(true);
		return WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient)).build();
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(FirstentityApplication.class, args);
	}

}
