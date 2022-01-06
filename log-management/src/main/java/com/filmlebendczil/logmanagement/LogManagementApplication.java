package com.filmlebendczil.logmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.filmlebendczil.entities")
@ComponentScan("com.filmlebendczil.repository")
public class LogManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogManagementApplication.class, args);
	}

}
