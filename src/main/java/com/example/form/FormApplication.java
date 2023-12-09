package com.example.form;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.example.form.user.Laborant;
import com.example.form.user.UserRepository;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class FormApplication {

	public static void main(String[] args) {
		SpringApplication.run(FormApplication.class, args);
	}

	@Bean

	CommandLineRunner laborantCreator(UserRepository userRepository) {
		return (args) -> {
			for (var i = 1; i <= 9; i++) {
				Laborant laborant = new Laborant();
				laborant.setIsim("user" + i);
				laborant.setLabKimlik("423415" + i);
				userRepository.save(laborant);
			}
		};
	}
}
