package com.kbs.templateortest.java;

import org.junit.jupiter.api.Test;

public class FindEnumTest {

    @Test
    void test() {
        String representation = "*";
        Operator operator = Operator.find(representation);

        System.out.println("[[[operator = " + operator);
        System.out.println("[[[operator.getRepresentation() = " + operator.getRepresentation());
    }
}
