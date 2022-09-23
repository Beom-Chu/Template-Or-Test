package com.kbs.templateortest.etc;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Slf4j
public class Slf4jTest {

    @Test
    public void test () {

        log.error("test : {} 번 입니다" , 1);
        log.error("test : {} 번 입니다 {} !!" , 2, "^^");

        int status = 200;
        String statusText = "OK";
        log.error("Response status is OK. : status: {} , StatusText : {}" , status, statusText);

        log.error("에러 발생!", new Exception("에러 발생했슈"));


        log.error("Response body object code is not 200. code : " , "abc");
    }

    @Test
    public void test2() {

        String svcId = "ABC123";
        int result = 123;

        log.info("CrmUmsPushListener[svcId:{}] Result : {}", svcId , result);
    }
}
