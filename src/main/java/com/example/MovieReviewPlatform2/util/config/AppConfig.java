package com.example.MovieReviewPlatform2.util.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public AppConfig restTemplate() {
        return new AppConfig();
    }
}
