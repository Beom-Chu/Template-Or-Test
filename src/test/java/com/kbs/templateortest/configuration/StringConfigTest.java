package com.kbs.templateortest.configuration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = StringConfig.class)
class StringConfigTest {

    @Autowired
    private String customString;

    @Test
    public void test() {

        String s = customString.toString();
        System.out.println("[[[s = " + s);
    }
}