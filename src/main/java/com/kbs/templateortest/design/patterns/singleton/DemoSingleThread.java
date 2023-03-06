package com.kbs.templateortest.design.patterns.singleton;

public class DemoSingleThread {
    public static void main(String[] args) {
        Singleton singletonOne = Singleton.getInstance("One");
        Singleton singletonTwo = Singleton.getInstance("Two");

        System.out.println("[[[singletonOne.value = " + singletonOne.value);
        System.out.println("[[[singletonTwo.value = " + singletonTwo.value);
    }
}
