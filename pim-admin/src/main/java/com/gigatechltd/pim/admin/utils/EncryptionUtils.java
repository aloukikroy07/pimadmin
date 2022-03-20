//package com.gigatechltd.pim.admin.utils;
//
//import org.jasypt.properties.PropertyValueEncryptionUtils;
//import org.jasypt.util.text.BasicTextEncryptor;
//
//public final class EncryptionUtils {
//
//    private static final String salt = "EATSLEEPCODEEATSLEEPCODE";
//
//    private static final BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
//
//    static {
//        basicTextEncryptor.setPassword(salt);
//    }
//
//    private EncryptionUtils() {
//    }
//
//    public static String encode(String plaintext) {
//        return basicTextEncryptor.encrypt(plaintext);
//    }
//
//    public static String decode(String ciphertext) {
//        ciphertext = "ENC(" + ciphertext + ")";
//        if (PropertyValueEncryptionUtils.isEncryptedValue(ciphertext)) {
//            return PropertyValueEncryptionUtils.decrypt(ciphertext, basicTextEncryptor);
//        }
//        System.out.println("decryption failed");
//        return "";
//    }
//}