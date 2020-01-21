package com.agile.leetcode.AESandRSA;


import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

/**
 * AES加密工具类
 */
public class AESUtils {
    /**
     * 获得一个 密钥长度为 256 位的 AES 密钥，
     * @return 返回经 BASE64 处理之后的密钥字符串
     */
    public static   String getStrkeyAES() throws NoSuchAlgorithmException {
        //加密方式
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        //获得当前时间的真随机数 种子为系统当前时间
        SecureRandom secureRandom = new SecureRandom(String.valueOf(System.currentTimeMillis()).getBytes());
        keyGenerator.init(256,secureRandom);// 这里可以是 128、192、256、越大越安全
        SecretKey secretKey=keyGenerator.generateKey();
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }
    /**
     *  将使用 Base64 加密后的字符串类型的 secretKey 转为 SecretKey
     * @param strKey
     * @return SecretKey
     */
    public static SecretKey strKey2SecretKey(String strKey){
        byte[] decode = Base64.getDecoder().decode(strKey);
        SecretKeySpec secretKey = new SecretKeySpec(decode, "AES");
        return secretKey;
    }
    /**
     * 加密
     * @param content 待加密内容
     * @param secretKey 加密使用的 AES 密钥
     * @return 加密后的密文 byte[]
     */
    public static byte[] encryptAES(byte[] content,SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE,secretKey);
        return cipher.doFinal(content);
    }
    /**
     * 解密
     * @param content 待解密内容
     * @param secretKey 解密使用的 AES 密钥
     * @return 解密后的明文 byte[]
     */

    public static byte[] decryptAES(byte[] content, SecretKey secretKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(content);
    }
    public static void main(String[] args) throws NoSuchAlgorithmException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        String strkeyAES = AESUtils.getStrkeyAES();
        SecretKey secretKey = AESUtils.strKey2SecretKey(strkeyAES);

        byte[] bytes = encryptAES("陈彰坤".getBytes(), secretKey);

        System.out.println("加密后内容"+"  "+new String(bytes));
        //byte[] bytes1 = AESUtils.decryptAES(bytes, secretKey);
        byte[] bytes1 = decryptAES(bytes, secretKey);
        System.out.println(new String(bytes1));
    }

    /**
     * 加密十次
     * @param bytes
     * @param secretKey
     * @return
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     */
    public static byte[] tenTimes(byte[] bytes,SecretKey secretKey) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        byte[] result=null;
        for (int i=0;i<10;i++){
            result=AESUtils.encryptAES(bytes,secretKey);
            bytes=result;
        }
        return result;
    }

    /**
     * 解密十次
     * @param bytes
     * @param secretKey
     * @return
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     */
    public static  byte[] decryTenTimes(byte[] bytes,SecretKey secretKey) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        byte[] result=null;
        for (int i=0;i<10;i++){
            result=AESUtils.decryptAES(bytes,secretKey);
            bytes=result;
        }
        return result;
     }
}
