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

        // 원시타입 long과 참조타입 Long을 '==' 로 비교시에는 묵시적 형변환으로 정상 값을 반환
        System.out.println(l5 == l1);
        System.out.println(Objects.equals(l5, l1));
        System.out.println(l1 == l5);
        System.out.println(Objects.equals(l1, l5));
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

        Long l5 = 128L;
        long l6 = 128L;
        System.out.println(l5 == l6); // true
        System.out.println(l5.equals(l6)); // true
    }

    @Test
    public void test3() {
        int i1 = 128;
        Integer i2 = 128;
        Integer i3 = 128;

        System.out.println(i1 == i2);
        System.out.println(i2 == i1);

        System.out.println(i2 == i3);
        System.out.println(i2 == i1);
    }
}
