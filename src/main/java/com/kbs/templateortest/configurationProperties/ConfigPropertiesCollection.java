package com.kbs.templateortest.configurationProperties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties("config.properties")
@Data
public class ConfigPropertiesCollection {

    private List<User> users;
    private Map<String, String> contact;

    @Data
    static class User {
        private String name;
        private Long age;
    }
}
