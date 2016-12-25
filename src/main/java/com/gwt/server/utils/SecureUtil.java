package com.gwt.server.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * @author Sergiy_Solovyov
 */
public class SecureUtil {

    private static Random rand = new Random((new Date().getTime()));

    public static String encrypt(String password) {
        BASE64Encoder encoder = new BASE64Encoder();
        byte[] salt = new byte[8];
        rand.nextBytes(salt);
        return encoder.encode(salt) + encoder.encode(password.getBytes());
    }

    public static boolean matches(String password, String encPassword){
        return  password.equals(decrypt(encPassword));
    }

    private static String decrypt(String encryptKey) {
        if (encryptKey.length() > 12) {
            String cipher = encryptKey.substring(12);
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                return new String(decoder.decodeBuffer(cipher));
            } catch (IOException e) {
              e.printStackTrace();
            }
        }
        return null;
    }
}
