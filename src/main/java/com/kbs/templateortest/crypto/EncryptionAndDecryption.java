package com.kbs.templateortest.crypto;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncryptionAndDecryption {

    public static String encrypt(String sSrc, String key) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes());
        String aes256Encoded = DatatypeConverter.printBase64Binary(encrypted);

        return URLEncoder.encode(aes256Encoded, StandardCharsets.UTF_8);
    }

    public static String decrypt(String sSrc, String key) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        String utfDecoded = URLDecoder.decode(sSrc, StandardCharsets.UTF_8);
        java.util.Base64.Decoder decoder = Base64.getDecoder();
        byte[] decrypted = cipher.doFinal(decoder.decode(utfDecoded.getBytes()));

        return new String(decrypted);
    }
}
