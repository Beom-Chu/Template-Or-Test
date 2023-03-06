package com.kbs.templateortest.design.patterns.singleton;

public class DemoMultiThread {

    public static void main(String[] args) {

        Thread threadOne = new Thread(new ThreadOne());
        Thread threadTwo = new Thread(new ThreadTwo());
        threadOne.start();
        threadTwo.start();
    }

    static class ThreadOne implements Runnable {

        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("One");
            System.out.println("[[[singleton.value = " + singleton.value);
        }
    }

    static class ThreadTwo implements Runnable {

        @Override
        public void run() {
            Singleton singleton = Singleton.getInstance("Two");
            System.out.println("[[[singleton.value = " + singleton.value);
        }
    }
}
