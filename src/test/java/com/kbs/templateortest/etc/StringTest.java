package com.kbs.templateortest.etc;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class StringTest {

    @Test
    public void test(){

        /* 선언시 new 연산자 사용방식과 리터럴 방식에 따라 메모리에 할당되는 방식이 다름
         * * new 연산자 : Heap 영역
         * * 리터럴 : Heap 영역의 String Constant Pool
         * * * 리터럴로 선언한 경우 이중등호(==)로 true 값이 반환
         */
        String str1 = "text";
        String str2 = "text";
        String str3 = new String("text");
        String str4 = new String("text");

        System.out.println("[[[str1 == str2 = " + (str1 == str2));
        System.out.println("[[[str1.equals(str2) = " + (str1.equals(str2)));

        System.out.println("[[[(str3 == str4) = " + (str3 == str4));
        System.out.println("[[[(str3.equals(str4)) = " + (str3.equals(str4)));

        System.out.println("[[[(str1 == str3) = " + (str1 == str3));
        System.out.println("[[[(str1.equals(str3)) = " + (str1.equals(str3)));

    }

    @Test
    public void test2(){
        String str = (String) null;
        if(str == null) {
            System.out.println("null");
        } else {
            System.out.println("not null");
        }

        String str2 = str.toString();
        if(str2 == null) {
            System.out.println("null");
        } else {
            System.out.println("not null");
        }
    }
}
