package com.kbs.templateortest.java;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;

class RunnableTest {

    @Test
    void test() {

        Runnable runnable = () -> System.out.println("run runnable!");
        runnable.run();

        Callable<DateTime> callable = () -> DateTime.now();
        try {
            DateTime call = callable.call();
            System.out.println(call);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
