package com.kbs.templateortest.profile;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
/* ActiveProfiles에 설정한 profile에 맞춰서 빈이 등록 */
//@ActiveProfiles("test")
@ActiveProfiles("local")
public class ProfileTest {

    @Autowired
    private ProfileConfig profileConfig;

    @Test
    public void testProfileTest() {

        String profile = profileConfig.getProfile();
        System.out.println("[[[profile = " + profile);

    }
}
