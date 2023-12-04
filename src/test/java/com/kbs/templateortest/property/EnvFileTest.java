package com.kbs.templateortest.property;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = {Environment.class, ApplicationContext.class})
@ActiveProfiles("local") /* 테스트시 profile 선택 */
public class EnvFileTest {

    @Value("${config.properties.env1:}")
    private String env1;
    @Value("${config.properties.env2:}")
    private String env2;
    @Value("${config.properties.env3:}")
    private String env3;
    @Value("${config.properties.env4:}")
    private String env4;

    @Test
    public void test () {

        System.out.println("[[[env1 = " + env1);
        System.out.println("[[[env2 = " + env2);
        System.out.println("[[[env3 = " + env3);
        System.out.println("[[[env4 = " + env4);
    }
}
