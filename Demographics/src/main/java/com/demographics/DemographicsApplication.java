package com.demographics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.domain.base")
public class DemographicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemographicsApplication.class, args);
	}
}
