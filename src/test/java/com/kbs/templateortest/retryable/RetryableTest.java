package com.kbs.templateortest.retryable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {RetryableMethod.class})
public class RetryableTest {
    @Autowired
    private RetryableMethod retryableMethod;

    @Test
    @DisplayName("@Retryable 메소드 호출 테스트")
    public void test() throws Exception {
        retryableMethod.randomExceptionMethod();
    }
}
