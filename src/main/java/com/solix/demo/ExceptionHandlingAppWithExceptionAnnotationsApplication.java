package com.solix.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.solix.demo.model.User;

@SpringBootApplication
public class ExceptionHandlingAppWithExceptionAnnotationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionHandlingAppWithExceptionAnnotationsApplication.class, args);
	}
	
	// In order to Store this object in Spring Container, we need to use @Bean annotation....
		@Bean
		public Map<Integer, User> createMap(){
			Map<Integer, User> usersMap = new HashMap<>();
			
			usersMap.put(101, new User(101, "Miller", "admin"));
			usersMap.put(102, new User(102, "Alice", "manager"));
			usersMap.put(103, new User(103, "Sophia", "admin"));
			
			return usersMap; 
		}

}
