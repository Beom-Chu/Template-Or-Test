package com.kbs.templateortest.design.patterns.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoMultiThread2 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        /* 동일한 value가 출력되면 하나의 instance를 사용한 것 */
        for (int i = 0; i < 3; i++) {
            executorService.execute(new SingletonThread(i));
        }
        executorService.shutdown();
    }
    
    private static class SingletonThread implements Runnable {
        
        private int value;

        public SingletonThread(int value) {
            this.value = value;
        }

        @Override
        public void run() {
            MultiCheckSingleton instance = MultiCheckSingleton.getInstance(String.valueOf(value));
            System.out.println("[[[instance.value = " + instance.value);
        }
    }
}
