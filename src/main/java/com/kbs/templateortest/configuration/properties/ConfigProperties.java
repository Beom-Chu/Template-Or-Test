package com.kbs.templateortest.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("spring.rabbitmq")
@Data
public class ConfigProperties {
    private String host;
    private Integer port;
    private String username;
    private String password;
}
