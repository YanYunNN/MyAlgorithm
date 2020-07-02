package com.yanyun.juc.encrypt;


import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * AES practise code
 * <p/>
 * Created by sunyiwei on 2016/8/28.
 */
public class AES {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();

        final String ORIGIN = "Hello world";

        //encrypt
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        String encoded = new String(Base64.getEncoder().encode(cipher.doFinal(ORIGIN.getBytes())));
        System.out.println("Encoded: " + encoded);

        //decrypt
        String algo = cipher.getAlgorithm();
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decoded = cipher.doFinal(Base64.getDecoder().decode(encoded));
        System.out.println("Decoded: " + new String(decoded));
    }
}
