package com.kbs.templateortest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TemplateOrTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemplateOrTestApplication.class, args);
    }

}
