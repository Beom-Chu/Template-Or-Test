package com.kbs.templateortest.lombok;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lombok")
public class LombokTestController {

    @GetMapping("/boolean-is-prefix")
    public void testLombokBooleanIsPrefix(@RequestBody User user) {

        /*
        test Body 샘플
        {
            "id":1,
            "name":"kbs",
            "isAdult":true,
            "isKorean":true,
            "isTest":true
        }

        정상적으로 Body의 boolean 값을 받아오기 위한 방법
        1. Boolean 타입을 사용
        2. setIs[필드명], getIs[필드명] 으로 getter, setter 를 만들어준다.

         */

        System.out.println("[[[user.isAdult = " + user.isAdult());

        System.out.println("[[[user.getIsKorean() = " + user.getIsKorean());

        System.out.println("[[[user.getIsTest() = " + user.getIsTest());
    }
}
