package com.arifacar.reactiveapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@Configuration
@ComponentScan("com.arifacar")
public class ReactiveApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveApiApplication.class, args);
	}

}
