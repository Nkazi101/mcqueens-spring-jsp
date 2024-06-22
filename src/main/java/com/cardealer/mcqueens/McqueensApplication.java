package com.cardealer.mcqueens;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cardealer")
public class McqueensApplication {

	public static void main(String[] args) {
		SpringApplication.run(McqueensApplication.class, args);
	}

}
