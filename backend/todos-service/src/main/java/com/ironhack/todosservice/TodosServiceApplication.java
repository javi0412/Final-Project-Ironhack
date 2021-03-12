package com.ironhack.todosservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TodosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodosServiceApplication.class, args);
	}

}
