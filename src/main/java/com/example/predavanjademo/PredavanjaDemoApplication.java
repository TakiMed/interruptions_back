package com.example.predavanjademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication // @Configuration + @ComponentScan koji skenira bean-ova automatske
// na nivou projekta dje je Demo klasa skenira Bean-ove
public class PredavanjaDemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(PredavanjaDemoApplication.class, args);
    }

}
