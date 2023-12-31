package com.example.form.configuraiton;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;

import java.util.concurrent.TimeUnit;


import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class StaticResourceConfiguration implements WebMvcConfigurer{

    
    private final String uploadDir = "uploads/photo";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Dosyaların servis edileceği yolu ve dizini belirtin
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:" + uploadDir)
                .setCacheControl(CacheControl.maxAge(365, TimeUnit.DAYS));
    }
}
