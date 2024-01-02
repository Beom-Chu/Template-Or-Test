package com.kbs.templateortest.java.exception;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
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

    @Test
    @DisplayName("오류 발생시 재시도(while)")
    public void testRetryExceptionWhile() throws Exception {
        int max = 10, current = 1;

        while (current <= max) {
            try {
                // 여기에 실행하고자 하는 메서드 호출
                randomException();
                // 메서드가 정상적으로 실행되면 루프를 빠져나감
                break;
            } catch (Exception e) {
                // 예외가 발생하면 재시도 횟수를 증가시키고 로그 출력
                log.error(e.getMessage() + " 발생, 재시도 횟수 : " + (current++));

                // 최대 재시도 횟수에 도달하면 예외를 다시 throw하여 상위 호출자에게 전달
                if (current > max) {
                    throw e;
                }
            }
        }
    }

    @Test
    @DisplayName("오류 발생시 재시도(for)")
    public void testRetryExceptionFor() throws Exception {
        for (int current = 1, max = 10; current <= max; current++) {
            try {
                randomException();
                break;
            } catch (Exception e) {
                log.error(e.getMessage() + " 발생, 재시도 횟수 : " + current);
                if (current == max) {
                    throw e;
                }
            }
        }
    }

    private void randomException() throws Exception {

        double i = Math.random() * 10;
        System.out.println(i);
        if(i > 0) {
            throw new Exception("에러!");
        }
    }
}
