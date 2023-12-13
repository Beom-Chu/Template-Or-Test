package com.kbs.templateortest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringConfig {

    @Bean
    public String customString() {
        return new String("abcde");
    }
}
