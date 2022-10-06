package com.prajeeth.crud_thymeleaf_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class CrudThymeleafSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudThymeleafSpringbootApplication.class, args);
	}
}