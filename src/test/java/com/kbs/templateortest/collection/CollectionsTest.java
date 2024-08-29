package com.kbs.templateortest.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {

    @Test
    @DisplayName("Collections 메소드 shuffle 테스트")
    void testShuffle() {

        SecureRandom secureRandom = new SecureRandom();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Collections.shuffle(list, secureRandom);
        System.out.println("list = " + list);
        Collections.shuffle(list, secureRandom);
        System.out.println("list = " + list);
        Collections.shuffle(list, secureRandom);
        System.out.println("list = " + list);
    }
}
