package com.works;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MacademiaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MacademiaProjectApplication.class, args);
    }

}
