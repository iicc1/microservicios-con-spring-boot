package com.cpcd.microservices.app.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviciocursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciocursosApplication.class, args);
	}

}
