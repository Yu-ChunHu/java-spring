package com.codingcat.happy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(WebConfig.class)
public class SpringRestSample1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestSample1Application.class, args);
	}
}
