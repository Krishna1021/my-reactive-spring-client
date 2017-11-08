package com.example.ffsmyclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FfsMyClientApplication {


@org.springframework.context.annotation.Bean
	org.springframework.web.reactive.function.client.WebClient webClient(){

		return  org.springframework.web.reactive.function.client.WebClient.create("http://localhost:8888/movies");
	}

	@org.springframework.context.annotation.Bean
	org.springframework.boot.CommandLineRunner demo(org.springframework.web.reactive.function.client.WebClient webClient){

		return ars->{

			webClient.get().uri("").exchange().flatMapMany(response->response.bodyToFlux(Movie.class)).filter
					(movie-> movie.getName().equalsIgnoreCase("My Reactive on plane")).subscribe(movie -> webClient.get()
					.uri("/{id}/events",
					movie.getId()).exchange().flatMapMany(clientResponse -> clientResponse.bodyToFlux(MovieEvent
							.class)).subscribe(System.out::println));
		};


	}



	public static void main(String[] args) {
		SpringApplication.run(FfsMyClientApplication.class, args);
	}



}
