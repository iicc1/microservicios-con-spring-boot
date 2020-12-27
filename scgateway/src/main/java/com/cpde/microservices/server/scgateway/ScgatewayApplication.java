package com.cpde.microservices.server.scgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient 
@SpringBootApplication
public class ScgatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScgatewayApplication.class, args);
	}

}
