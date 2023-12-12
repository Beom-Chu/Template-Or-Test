package com.kbs.templateortest.etc;

import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.DisplayName;
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
//        System.out.println(i2 == i1);
    }

    @Test
    public void testParseLong() {

        Long partyId = null;
        String temp = "undefined";
        if (Strings.isNotBlank(temp)) {
            partyId = Long.parseLong(temp);
        }

        System.out.println("[[[partyId = " + partyId);
        // java.lang.NumberFormatException: For input string: "undefined"
    }

    @Test
    @DisplayName("null이 포함된 Long 데이터 비교")
    public void testNullEquals() {

        Long null1 = null;
        Long null2 = null;
        Long long1 = 10L;

        // Objects.equals 은 null과 null도 비교 가능
        System.out.print("Objects.equals => not null vs null : ");
        printNullEqualsResult(Objects.equals(long1, null1));

        System.out.print("Objects.equals => null vs not null : ");
        printNullEqualsResult(Objects.equals(null1, long1));

        System.out.print("Objects.equals => null vs null : ");
        printNullEqualsResult(Objects.equals(null1, null2));


        // Long.equals은 비교 주체가 null이면 에러 발생
        System.out.print("Long.equals => not null vs null : ");
        printNullEqualsResult(long1.equals(null1));

        System.out.print("Long.equals => null vs not null : ");
        printNullEqualsResult(null1.equals(long1));

        System.out.print("Long.equals => null vs null : ");
        printNullEqualsResult(null1.equals(null2));

    }

    public void printNullEqualsResult(Boolean b) {
        try {
            System.out.print(b);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println();
        }
    }
}
