package com.kbs.templateortest.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) /* 테스트 순서 @Order 로 설정 */
public class JunitTest {


    @DisplayName("일반 테스트")
    @Test
    @Order(1)
    public void test1(){
        System.out.println("JunitTest.test1");
    }

    @Order(3)
    @Disabled /* 테스트 비활성화 */
    @Test
    public void test2(){
        System.out.println("JunitTest.test2");
    }

    @Order(4)
    @DisplayName("지정 배열의 값을 파라미터로 전달받아 순서대로 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,5,7})
    public void testParameterizedTest(int number) {
        System.out.println("JunitTest.testParameterizedTest");
        System.out.println("[[[number = " + number);
    }

    @Order(2)
    @DisplayName("반복 테스트")
    @RepeatedTest(2)
    public void testRepeatedTest(){
        System.out.println("JunitTest.testRepeatedTest");
    }

    
    


    @DisplayName("모든 테스트 실행 전에 한번 실행 [static 필수]")
    @BeforeAll
    public static void testBeforeAll(){
        System.out.println("JunitTest.testBeforeAll");
    }

    @DisplayName("각 테스트 실행 전에 한번씩 실행")
    @BeforeEach
    public void testBeforeEach(){
        System.out.println("JunitTest.testBeforeEach");
    }

    @DisplayName("모든 테스트 실행 후에 한번 실행 [static 필수")
    @AfterAll
    public static void testAfterAll(){
        System.out.println("JunitTest.testAfterAll");
    }

    @DisplayName("각 테스트 실행 후에 한번씩 실행")
    @AfterEach
    public void testAfterEach(){
        System.out.println("JunitTest.testAfterEach");
    }
    
    
    
    @DisplayName("Assertions 테스트")
    @Test
    public void testAssert(){

        List<Integer> list1 = List.of(1, 3, 5);
        List<Integer> list2 = List.of(1, 3, 5);

        Assertions.assertEquals(list1, list2);  /* 값이 같은지 확인 */
        Assertions.assertNotSame(list1, list2); /* 같은 객체가 아닌지 확인 */

        Integer[] ints1 = new Integer[]{1,3,5};
        Integer[] ints2 = new Integer[]{1,3,5};

        Assertions.assertNotEquals(ints1,ints2);
        Assertions.assertArrayEquals(ints1, ints2); /* 같은 배열 값인지 확인 */
    }

    @DisplayName("에러 발생 Assert")
    @Test
    public void testAssertThrows(){
        Assertions.assertThrows(NullPointerException.class, () -> {
           String s = null;
           s.toString();
        });

        Assertions.assertThrows(Exception.class, this::testMethod);

    }

    public void testMethod() throws Exception {
        throw new Exception("testException");
    }
}
