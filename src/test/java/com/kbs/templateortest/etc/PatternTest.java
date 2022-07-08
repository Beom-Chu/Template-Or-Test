package com.kbs.templateortest.etc;

import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;

import java.util.regex.Matcher;

public class PatternTest {
    @Test
    public void test() {


        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("\\.[a-zA-Z0-9]+Api\\.");
        String name = "kr.co.test.abc.def.member.info.noAuthApi.noApi.TestabcdApi";
        Matcher matcher = pattern.matcher(name);

        matcher.find(); // 복수 매치되더라도 첫번째 것만 체크한다.

        System.out.println("[[[matcher = " + matcher.start());
        System.out.println("[[[matcher.end() = " + matcher.end());

        String partnerName = name.substring(matcher.start() + 1, matcher.end() - 4);

        System.out.println("[[[partnerName = " + partnerName);
    }
}
