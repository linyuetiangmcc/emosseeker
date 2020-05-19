package com.gmcc.emosseeker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class EmosseekerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmosseekerApplication.class, args);
    }

}
