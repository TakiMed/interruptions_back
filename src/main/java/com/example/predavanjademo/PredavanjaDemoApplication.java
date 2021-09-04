package com.example.predavanjademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // @Configuration + @ComponentScan koji skenira bean-ova automatske
// na nivou projekta dje je Demo klasa skenira Bean-ove
public class PredavanjaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PredavanjaDemoApplication.class, args);
    }

}
