package com.kbs.templateortest.design.patterns.singleton;

public class MultiCheckSingleton {

    private static volatile MultiCheckSingleton instance;
    public String value;

    private MultiCheckSingleton(String value) {
        this.value = value;
    }

    public static MultiCheckSingleton getInstance(String value) {
        if(instance == null) {
            synchronized (MultiCheckSingleton.class) {
                if(instance == null) {
                    instance = new MultiCheckSingleton(value);
                }
            }
        }
        return instance;
    }
}
