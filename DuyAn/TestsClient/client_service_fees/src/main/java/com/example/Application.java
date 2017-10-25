package com.example;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import com.example.configruation.JpaConfigruation;


@Import(JpaConfigruation.class)
@SpringBootApplication(scanBasePackages={"com.example"})
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}

}
