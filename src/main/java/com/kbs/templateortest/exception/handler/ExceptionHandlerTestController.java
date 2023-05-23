package com.kbs.templateortest.exception.handler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exceptionHandler")
public class ExceptionHandlerTestController {

    @GetMapping("/test")
    public String exceptionHandlerTest() {
        System.out.println("ExceptionHandlerTestController.exceptionHandlerTest");

        throw new NullPointerException("오류 테스트!!");

//        return "OK";
    }

}
