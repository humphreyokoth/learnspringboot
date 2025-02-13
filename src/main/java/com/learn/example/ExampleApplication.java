package com.learn.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);

		MyFirstClass myfirstclass = new MyFirstClass();
		System.out.println(myfirstclass.sayHello());
	}

	@Bean
	public MyFirstClass myFirstClass(){
		return new MyFirstClass();
	}

}
