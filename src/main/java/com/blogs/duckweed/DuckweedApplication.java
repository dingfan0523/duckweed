package com.blogs.duckweed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DuckweedApplication {

    public static void main(String[] args) {
        SpringApplication.run(DuckweedApplication.class, args);
    }

}
