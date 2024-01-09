package com.kbs.templateortest.retryable;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

@Component
@EnableRetry
public class RetryableMethod {
    @Retryable(value = {Exception.class}, maxAttemptsExpression = "${retry.max.attempts:5}", backoff = @Backoff(delay = 1000))
    public void randomExceptionMethod() throws Exception {

        double i = Math.random() * 10;
        System.out.println("RetryableMethod.randomExceptionMethod => random:" + i);

        if (i > 2) {
            throw new Exception("에러!");
        }
    }
}
