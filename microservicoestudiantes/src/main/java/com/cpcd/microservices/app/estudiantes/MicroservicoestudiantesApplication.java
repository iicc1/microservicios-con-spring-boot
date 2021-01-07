package com.cpcd.microservices.app.estudiantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroservicoestudiantesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicoestudiantesApplication.class, args);
	}

}
