package com.kbs.templateortest.etc;

import org.junit.jupiter.api.Test;

import java.util.Objects;


public class LongTest {


    /*
    Long은 -128에서 127까지의 범위의 경우 상수 풀을 유지
    그러므로 비교시 equals 를 사용!!!
     */
    @Test
    public void test() {

        Long l1 = 156L;
        Long l2 = 156L;
        Long l3 = 10L;
        Long l4 = 10L;
        long l5 = 156;
        long l6 = 156;

        System.out.println(l1 == l2);
        System.out.println(l1.equals(l2));
        System.out.println(Objects.equals(l1, l2));

        System.out.println(l3 == l4);
        System.out.println(l3.equals(l4));
        System.out.println(Objects.equals(l3, l4));

        System.out.println(l5 == l6);
        System.out.println(Objects.equals(l5, l6));
    }

    @Test
    public void test2() {
        Long l1 = 1L;
        Long l2 = 1L;
        System.out.println(l1.equals(l2)); // true

        Long l3 = 128L;
        Long l4 = 128L;
        System.out.println(l3 == l4); // false
        System.out.println(l3.equals(l4)); // true
    }
}
