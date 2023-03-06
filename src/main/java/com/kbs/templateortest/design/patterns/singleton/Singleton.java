package com.kbs.templateortest.design.patterns.singleton;

public final class Singleton {
    private static Singleton instance;
    public String value;

    public Singleton(String value) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if(instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }
}
