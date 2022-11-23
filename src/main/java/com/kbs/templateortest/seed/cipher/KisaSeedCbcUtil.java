package com.kbs.templateortest.seed.cipher;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class KisaSeedCbcUtil {

    private static final String UserKey = "kbskbs1234567890";
    private static final String Iv = "1234567890123456";

    private static final byte[] pbszUserKey = UserKey.getBytes();
    private static final byte[] pbszIV = Iv.getBytes();

    public static byte[] encrypt(byte[] plainText) {
        return KisaSeedCbc.SEED_CBC_Encrypt(pbszUserKey, pbszIV, plainText, 0, plainText.length);
    }

    public static byte[] decrypt(byte[] cipherText) {
        return KisaSeedCbc.SEED_CBC_Decrypt(pbszUserKey, pbszIV, cipherText, 0, cipherText.length);
    }

    public static String encrypt(String plainText) {
        byte[] encrypt = encrypt(toSeedByte(plainText));
        return URLEncoder.encode(toSeedString(encrypt),StandardCharsets.UTF_8);
    }

    public static String decrypt(String cipherText) {
        byte[] decrypt = decrypt(toSeedByte(URLDecoder.decode(cipherText,StandardCharsets.UTF_8)));
        return toSeedString(decrypt);
    }

    public static String toSeedString(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (byte value : b) {
            sb.append((char) value);
        }
        return sb.toString();
    }

    public static byte[] toSeedByte(String str) {
        byte[] b = new byte[str.length()];
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) str.charAt(i);
        }
        return b;
    }
}
