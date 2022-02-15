package com.myspringapps.firstspringapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class FirstspringappApplication {

	public static void main(String[] args) {
		//SpringApplication.run(FirstspringappApplication.class, args);
		new SpringApplicationBuilder(FirstspringappApplication.class).run(args);
	}

}
