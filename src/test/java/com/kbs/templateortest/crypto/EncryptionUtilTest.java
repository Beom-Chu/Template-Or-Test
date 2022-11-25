package com.kbs.templateortest.crypto;

import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class EncryptionUtilTest {

    String key = "1234567890123456";

    @Test
    void encryptTest() {

        String s = "hellohellohello";

        try {
            String decryptStr = EncryptionUtil.encrypt(s, key);

            System.out.println("[[[decryptStr = " + decryptStr);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void decryptTest() {

        String s = "LVY19MGcw9UCCay0P7gEsQ==";

        try {
            String decryptStr = EncryptionUtil.decrypt(s, key);

            System.out.println("[[[encryptStr = " + decryptStr);

        } catch (BadPaddingException e) {
            System.out.println("암호화키가 일치하지 않습니다.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void uRLDecoderTest() {
        String input = "%EC%84%B1%EA%B3%B5";
        String decode = URLDecoder.decode(input, StandardCharsets.UTF_8);
        System.out.println("[[[decode = " + decode);
    }

    @Test
    public void test(){
        System.out.println(UUID.randomUUID());
    }
}