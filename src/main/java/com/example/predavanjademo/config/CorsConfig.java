package com.example.predavanjademo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry)
    {
        registry
                .addMapping("/**")
                .exposedHeaders("cache-control,content-length,content-type,expires,pragma,x-file-name")
                .allowedMethods("*")
                .allowedHeaders("*")
                // .allowedHeaders("*")
                .allowedOrigins("*");
    }
}
