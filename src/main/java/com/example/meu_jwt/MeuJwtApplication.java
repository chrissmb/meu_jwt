package com.example.meu_jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication//(exclude = SecurityAutoConfiguration.class)
public class MeuJwtApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeuJwtApplication.class, args);
	}

}
