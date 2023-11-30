package com.kbs.templateortest.property;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import java.util.List;

/* 다양한 방법으로 프로퍼티 가져오기 가능
* Environment, ApplicationContext, @Value
*/

// 프로그램 환경 변수
//--spring.profiles.active=local

@SpringBootTest(classes = {Environment.class, ApplicationContext.class})
//@ActiveProfiles("local") /* 테스트시 profile 선택 */
public class PropertyTest {

    @Autowired
    private Environment env;

    @Autowired
    private ApplicationContext ctx;

    @Value("${spring.config.activate.on-profile}")
    private String profile;

    @Value("${application.test}")
    private String applicationTest;

    // @Value 사용 프로퍼티 미설정 오류 방지를 위한 default 값 설정 테스트
    @Value("${ums.api.baseUrl:ums.api.baseUrl is undefined.}")
    String umsApiBaseUrl;
    @Value("${ums.api.key:ums.api.key is undefined.}")
    String umsApiKey;
    @Value("${ums.api.secret:ums.api.secret is undefined.}")
    String umsApiSecret;
    @Value("${config.properties.list:}")
    List<String> list;

    @Value("${config.properties.list2:}")
    List<String> list2;

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

    @Test
    @DisplayName("@Value 사용 프로퍼티 미설정 오류 방지를 위한 default 값 설정 테스트")
    public void testUndefinedValue(){
        System.out.println("[[[umsApiBaseUrl = " + umsApiBaseUrl);
        System.out.println("[[[umsApiKey = " + umsApiKey);
        System.out.println("[[[umsApiSecret = " + umsApiSecret);
    }

    @Test
    public void testActiveProfiles() {

    }

    
    @Test
    @DisplayName("Property List 사용 테스트")
    public void testListProperties() {
        System.out.println("[[[list.size() = " + list.size());
        for(String s1 : list) {
            System.out.println("[[[s1 = " + s1);
        }

        // config.properties.list2 는 테스트 실행시 환경 변수로 설정 후 테스트
        // config.properties.list2=abc,def
        System.out.println("[[[list2.size() = " + list2.size());
        for(String s2 : list2) {
            System.out.println("[[[s2 = " + s2);
        }
    }
}
