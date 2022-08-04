package com.kbs.templateortest.configurationProperties;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ConfigPropertiesTest {

    @Autowired
    ConfigProperties configProperties;

    @Autowired
    ConfigPropertiesCollection configPropertiesCollection;

    @Test
    public void testConfigProperties(){
        System.out.println("[[[configProperties = " + configProperties);
    }

    @Test
    public void testConfigPropertiesList(){

        List<ConfigPropertiesCollection.User> users = configPropertiesCollection.getUsers();
        for(ConfigPropertiesCollection.User user : users) {
            System.out.println("[[[user = " + user);
        }

        System.out.println("[[[getContact = " + configPropertiesCollection.getContact());
    }
}