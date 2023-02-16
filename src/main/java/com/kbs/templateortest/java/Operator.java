package com.kbs.templateortest.java;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String representation;

    Operator(String representation) {
        this.representation = representation;
    }

    public static Operator find(String representation) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.representation.equals(representation))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산자를 찾을 수 없습니다."));
    }
}
