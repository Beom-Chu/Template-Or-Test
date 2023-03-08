package com.kbs.templateortest.design.patterns.singleton;

public class DemoSingleThread {
    public static void main(String[] args) {
        Singleton singletonOne = Singleton.getInstance("One");
        Singleton singletonTwo = Singleton.getInstance("Two");

        /* 같은 value를 반환하면 하나의 인스턴스를 사용한 것 */
        System.out.println("[[[singletonOne.value = " + singletonOne.value);
        System.out.println("[[[singletonTwo.value = " + singletonTwo.value);
    }
}
