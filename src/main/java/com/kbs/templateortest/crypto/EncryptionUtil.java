package com.kbs.templateortest.crypto;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;


/**
 AES는 고급 암호화 표준이라는 의미이며, 암호화 및 복호화 시 동일한 키를 사용하는 대칭키 알고리즘.
 AES의 종류는 AES-128, AES-192, AES-256이 있고 각각 뒤에 붙은 숫자가 키의 길이를 의미.

 encryptionKey 의 길이에 따라서 AES 종류 정해짐. (AES-256는 256비트(32바이트)의 키를 사용)

 */
public class EncryptionUtil {

    private static final String transformationRule = "AES/CBC/PKCS5Padding";
    private static final String IV = "ABCDEFGHIJKLMNOP";

    /**
     * AES 암호화 메소드
     *
     * @param plainText 암호화 할 String
     * @param encryptionKey 암호화에 사용될 Key
     * @return 암호화된 String
     */
    public static String encrypt(String plainText, String encryptionKey) throws Exception {
        Cipher cipher = Cipher.getInstance(transformationRule);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes(StandardCharsets.UTF_8));
        SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes(StandardCharsets.UTF_8), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key, ivParameterSpec);
        byte[] encryptedByteArray = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(encryptedByteArray);
    }

    /**
     * AES 복호화 메소드
     *
     * @param cipherText 복호화할 String
     * @param encryptionKey 복호화에 사용될 Key
     * @return 복호화된 String
     */
    public static String decrypt(String cipherText, String encryptionKey) throws Exception {
        return decrypt(cipherText.getBytes(StandardCharsets.UTF_8), encryptionKey);
    }

    /**
     * AES 복호화 메소드
     *
     * @param cipherText 복호화할 byte[]
     * @param encryptionKey 복호화에 사용될 Key
     * @return 복호화된 String
     */
    public static String decrypt(byte[] cipherText, String encryptionKey) throws Exception {
        Cipher cipher = Cipher.getInstance(transformationRule);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes(StandardCharsets.UTF_8));
        SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes(StandardCharsets.UTF_8), "AES");
        cipher.init(Cipher.DECRYPT_MODE, key, ivParameterSpec);
        byte[] decodeBase64ByteArray = Base64.getDecoder().decode(cipherText);
        byte[] decryptedByteArray = cipher.doFinal(decodeBase64ByteArray);
        return new String(decryptedByteArray, StandardCharsets.UTF_8);
    }
}
