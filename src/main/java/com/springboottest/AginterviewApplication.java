package com.springboottest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.springboottest.controllers", "com.springboottest.service","com.springboottest"})
public class AginterviewApplication {


	public static void main(String[] args) {
		SpringApplication.run(AginterviewApplication.class, args);
	}

}
