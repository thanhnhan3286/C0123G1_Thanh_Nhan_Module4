package com.example.ungdungblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class UngDungBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(UngDungBlogApplication.class, args);
    }

}
