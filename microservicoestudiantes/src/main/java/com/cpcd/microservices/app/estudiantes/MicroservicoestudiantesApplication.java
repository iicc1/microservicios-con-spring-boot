package com.cpcd.microservices.app.estudiantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan(basePackages = "com.cpcd.microservices.commons.cursos.models.entity")
public class MicroservicoestudiantesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicoestudiantesApplication.class, args);
	}

}
