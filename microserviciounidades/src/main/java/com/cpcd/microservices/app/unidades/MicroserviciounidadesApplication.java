package com.cpcd.microservices.app.unidades;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviciounidadesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciounidadesApplication.class, args);
	}

}
