package com.kbs.templateortest.interceptor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/interceptor")
public class InterceptorController {

    @GetMapping("/test")
    public String test() {
        System.out.println("인터셉트 테스트 : /test");
        return "인터셉트 포함 path 패턴";
    }

    @GetMapping("/excludePath")
    public String excludePath() {
        System.out.println("인터셉트 테스트 : /excludePath");
        return "인터셉트 제외 path 패턴";
    }
}
