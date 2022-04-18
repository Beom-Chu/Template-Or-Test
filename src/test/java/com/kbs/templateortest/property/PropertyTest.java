package com.kbs.templateortest.property;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

/* 다양한 방법으로 프로퍼티 가져오기 가능
* Environment, ApplicationContext, @Value
*/

// 프로그램 환경 변수
//--spring.profiles.active=local

@SpringBootTest
public class PropertyTest {

    @Autowired
    private Environment env;

    @Autowired
    private ApplicationContext ctx;

    @Value("${spring.config.activate.on-profile}")
    private String profile;

    @Value("${application.test}")
    private String applicationTest;
    

    @Test
    public void testEnvironment() {
        String[] activeProfiles = env.getActiveProfiles();

        if(activeProfiles.length == 0) {
            System.out.println("no activeProfile");
        } else {
            for (String activeProfile : activeProfiles) {
                System.out.println("[[[activeProfile = " + activeProfile);
            }
        }

        String applicationTest = env.getProperty("application.test");
        System.out.println("[[[applicationTest = " + applicationTest);
    }

    @Test
    public void testApplicationContext(){
        Environment env = ctx.getEnvironment();

        String[] activeProfiles = env.getActiveProfiles();

        if(activeProfiles.length == 0) {
            System.out.println("no activeProfile");
        } else {
            for (String activeProfile : activeProfiles) {
                System.out.println("[[[activeProfile = " + activeProfile);
            }
        }

        String applicationTest = env.getProperty("application.test");
        System.out.println("[[[applicationTest = " + applicationTest);
    }

    @Test
    public void testValue(){
        System.out.println("[[[profile = " + profile);
        System.out.println("[[[applicationTest = " + applicationTest);
    }
}
