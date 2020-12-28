package com.cpde.microservices.app.autores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroservicioautoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioautoresApplication.class, args);
	}

}
