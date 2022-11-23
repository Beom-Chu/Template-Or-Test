package com.kbs.templateortest.seed.cipher;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class KisaSeedCbcTest {

    @Test
    @DisplayName("byte[] 반환 테스트")
    public void test() {

        String text = "abcabc!!";


        byte[] encrypt = KisaSeedCbcUtil.encrypt(text.getBytes(StandardCharsets.UTF_8));
        System.out.println("[[[encrypt = " + Arrays.toString(encrypt));

        byte[] decrypt = KisaSeedCbcUtil.decrypt(encrypt);

        System.out.println("[[[decrypt = " + Arrays.toString(decrypt));

        String decString = KisaSeedCbcUtil.toSeedString(decrypt);

        System.out.println("[[[decString = " + decString);

        
        Assertions.assertEquals(text, decString);
    }


    @Test
    @DisplayName("String 반환 테스트")
    public void test2() {

        String text = "abcabc!!";


        String encrypt = KisaSeedCbcUtil.encrypt(text);
        System.out.println("[[[encrypt = " + encrypt);

        String decrypt = KisaSeedCbcUtil.decrypt(encrypt);

        System.out.println("[[[decrypt = " + decrypt);


        Assertions.assertEquals(text, decrypt);
    }
}
