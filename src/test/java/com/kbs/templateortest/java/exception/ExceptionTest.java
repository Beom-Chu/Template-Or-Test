package com.kbs.templateortest.java.exception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExceptionTest {

    @Test
    @DisplayName("catch 구문에 Exception을 throw 해도 finally 구문 처리 되는지 테스트 ")
    public void test() {

        try {
            String s = null;

            if(s.equals("")) {
                System.out.println("[[[s equals \"\" ");
            }

        } catch (Exception e) {
            System.out.println("[[[Exception 발생");
            throw e;
        } finally {
            System.out.println("[[[finally !!");
        }
    }

    @Test
    @DisplayName("catch 구문에 return 해도 finally 구문 처리 되는지 테스트 ")
    public void test2() {

        String s = returnString();
        System.out.println("[[[s = " + s);
    }

    public String returnString() {

        String s = null;
        try {

            if(s.equals("")) {
                System.out.println("[[[s equals \"\" ");
            }

        } catch (Exception e) {
            System.out.println("[[[Exception 발생");
            return s;
        } finally {
            System.out.println("[[[finally !!");
        }
        return s;
    }
}
