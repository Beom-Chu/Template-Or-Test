package com.kbs.templateortest.design.patterns;

import com.kbs.templateortest.design.patterns.builder.User;
import org.junit.jupiter.api.Test;

public class BuilderTest {

    @Test
    public void test() {
        User user = new User.UserBuilder()
                .age(10)
                .name("kbs")
                .phone("010-0000-0000")
                .email("kbs@test.com")
                .build();

        System.out.println("[[[user = " + user);

        User user2 = new User.UserBuilder()
                .name("ljs")
                .email("ljs@test.com")
                .build();

        System.out.println("[[[user2 = " + user2);
    }
}
