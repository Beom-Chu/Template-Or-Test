package com.kbs.templateortest.design.patterns;

import com.kbs.templateortest.design.patterns.builder.User;
import com.kbs.templateortest.design.patterns.builder.builder.SaladBuilder;
import com.kbs.templateortest.design.patterns.builder.concretbuilder.Chef;
import com.kbs.templateortest.design.patterns.builder.director.SaladMaker;
import com.kbs.templateortest.design.patterns.builder.product.Salad;
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

    @Test
    public void test2() {
        SaladBuilder builder = new Chef();
        SaladMaker saladMaker = new SaladMaker(builder);
        Salad salad = saladMaker.makeSalad();

        System.out.println("[[[salad = " + salad);
    }
}
