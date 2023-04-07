package com.kbs.templateortest.etc;

import org.junit.jupiter.api.Test;

public class MathTest {

    @Test
    public void test() {

        Integer realSubscriptionSettleCount = 7;

        double ceil = Math.ceil(realSubscriptionSettleCount / 12.0);
        System.out.println("[[[ceil = " + ceil);
    }
}
