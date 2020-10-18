package com.profectus.business.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class CorsFilterConfiguration extends WebMvcConfigurationSupport {
    @Override
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").
                allowCredentials(false)
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*");
        super.addCorsMappings(registry);
    }
}