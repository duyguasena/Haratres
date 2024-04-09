package com.example.Haratres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;



@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class HaratresApplication {

	public static void main(String[] args) {
		SpringApplication.run(HaratresApplication.class, args);
	}

}
