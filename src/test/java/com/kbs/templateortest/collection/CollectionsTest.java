package com.kbs.templateortest.collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class CollectionsTest {

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

    @Test
    @DisplayName("frequency 테스트")
    void testFrequency() {

        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "b", "c", "d", "e", "e", "e", "f", "g"));

        // 리스트 내에 b의 빈도수
        int frequencyB = Collections.frequency(list, "b");
        System.out.println("frequencyB = " + frequencyB);

        // 리스트 내에 e의 빈도수
        int frequencyE = Collections.frequency(list, "e");
        System.out.println("frequencyE = " + frequencyE);
    }

    @Test
    @DisplayName("removeIf 테스트")
    void testRemoveIf() {

        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "b", "c", "d", "e", "e", "e", "f", "g"));
        // a로 시작하는 문자 제거
        list.removeIf(s -> s.startsWith("a"));
        System.out.println("list = " + list);

        // 리스트 내에 중복되는 문자 제거
        // 리스트 내에 빈도수가 1 이상인 문자 제거
        list.removeIf(s -> Collections.frequency(list, s) > 1);
        System.out.println("list = " + list);
    }
}
