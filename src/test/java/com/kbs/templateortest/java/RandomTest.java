package com.kbs.templateortest.java;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class RandomTest {

    @Test
    public void testRandom() {

        for (int i = 0; i < 5; i++) {
            printRandom();
        }
    }

    public void printRandom() {
        Random ran = new Random(10);
        for(int i = 0; i < 10; i++) {
            System.out.printf("%.3f   ", ran.nextDouble());
        }
        ran = null;
        System.out.println();
    }

    @Test
    public void testSecureRandom() throws NoSuchAlgorithmException {
        for (int i = 0; i < 5; i++) {
            printSecureRandom();
        }
    }

    public void printSecureRandom() throws NoSuchAlgorithmException {
        SecureRandom ran = SecureRandom.getInstanceStrong();
        for(int i = 0; i < 10; i++) {
            System.out.printf("%.3f   ", ran.nextDouble());
        }
        ran = null;
        System.out.println();
    }




    @Test
    public void testNextInt() {
        Random random = new Random(5);

        for (int i = 0; i < 10; i++) {
            System.out.println("[[[random.nextInt = " + random.nextInt(100));
        }
    }
}
