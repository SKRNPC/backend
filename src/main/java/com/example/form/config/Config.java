// package com.example.form.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class Config {
// 	@Bean
// 	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
// 		http
// 				.authorizeHttpRequests((requests) -> requests
// 						.requestMatchers("/", "/home").permitAll()
// 						.anyRequest().authenticated());
				
				

// 		return http.build();

// 	}
// }