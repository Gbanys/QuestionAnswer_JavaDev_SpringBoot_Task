package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.java.Log;

@Log
@SpringBootApplication
public class SpringSample1Application {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(SpringSample1Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(UserRepository userRepository, QuestionServiceImplementation questionServiceImpl, QuestionRepository questionRepository) {
		return (args) -> {
			log.info("Demo is working");
			
			/*
			User user = userRepository.findByuserid(28);
			Set<Question> questions = user.getQuestions();
			
			for(Question x : questions) {
				
				log.info(x.toString());
			}
			*/
		};
	}

}
