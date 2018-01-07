package com.gokhantamkoc.personanlwebpage.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.gokhantamkoc.personanlwebpage.backend")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
