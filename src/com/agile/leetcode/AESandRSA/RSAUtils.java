package com.agile.leetcode.AESandRSA;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * RSA加密工具类
 */
public class RSAUtils {
    /**
     * 生成密钥对：密钥对中包含公钥和私钥
     * @return 包含 RSA 公钥与私钥的 keyPair
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static KeyPair getKeyPari() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance("RSA");
        SecureRandom secureRandom=new SecureRandom(String.valueOf(System.currentTimeMillis()).getBytes());
        keyPairGenerator.initialize(2048,secureRandom);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return keyPair;
    }
    /**
     * 获取公钥 (并进行Base64编码，返回一个 Base64 编码后的字符串)
     * @param keyPair
     * @return 返回一个 Base64 编码后的公钥字符串
     */
    public static String getPublicKey(KeyPair keyPair){
        PublicKey publicKey = keyPair.getPublic();
        byte[] encoded = publicKey.getEncoded();
        return Base64.getEncoder().encodeToString(encoded);
    }
    /**
     * 获取私钥(并进行Base64编码，返回一个 Base64 编码后的字符串)
     * @param keyPair
     * @return 返回一个 Base64 编码后的私钥字符串
     */
    public static String getPrivateKey(KeyPair keyPair){
        PrivateKey privateKey = keyPair.getPrivate();
        byte[] encoded = privateKey.getEncoded();
        return Base64.getEncoder().encodeToString(encoded);
    }
    /**
     * 将Base64编码后的公钥转换成 PublicKey 对象
     * @param pubStr
     * @return PublicKey
     */
    public static PublicKey string2PublicKey(String pubStr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        //将加密的字符串转成Publickey对象
        byte[] decode = Base64.getDecoder().decode(pubStr);
        X509EncodedKeySpec keySpec=new X509EncodedKeySpec(decode);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }
    /**
     * 将Base64编码后的私钥转换成 PrivateKey 对象
     * @param priStr
     * @return PrivateKey
     */
    public static PrivateKey string2Privatekey(String priStr) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] decode = Base64.getDecoder().decode(priStr);
        PKCS8EncodedKeySpec keySpec=new PKCS8EncodedKeySpec(decode);
        KeyFactory keyFactory=KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }
    /**
     * 公钥加密
     * @param content 待加密的内容 byte[]
     * @param publicKey 加密所需的公钥对象 PublicKey
     * @return 加密后的字节数组 byte[]
     */
    public static byte[] publicEncrytype(byte[] content,PublicKey publicKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        byte[] bytes = cipher.doFinal(content);
        return bytes;
    }
    /**
     * 私钥解密
     * @param content   待解密的内容 byte[]
     * @param privateKey    解密需要的私钥对象 PrivateKey
     * @return 解密后的字节数组 byte[]
     */
    public static byte[] privateDecrypt(byte[] content,PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher=Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        byte[] bytes = cipher.doFinal(content);
        return bytes;
    }

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeySpecException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchPaddingException {
        //获取秘钥对
        KeyPair keyPari = getKeyPari();
        byte[] bytes2 = publicEncrytype("吴丹".getBytes(), keyPari.getPublic());
        byte[] bytes3 = privateDecrypt(bytes2, keyPari.getPrivate());
        System.out.println(new String(bytes3));
        System.out.println("======");
        String publicKey = getPublicKey(keyPari);
        PublicKey publicKey1 = string2PublicKey(publicKey);
        String privateKey = getPrivateKey(keyPari);
        PrivateKey privateKey1 = string2Privatekey(privateKey);
        //公钥加密
        byte[] bytes = publicEncrytype("陈彰坤".getBytes(), publicKey1);
        //byte[] bytes = encryTentimes("陈彰坤".getBytes(), publicKey1);
        //私钥解密
        byte[] bytes1 = privateDecrypt(bytes, privateKey1);
       // byte[] bytes1 = decryTentimes(bytes, privateKey1);
        System.out.println("解密后"+"   "+new String(bytes1));
    }

    /**
     * 加密十次
     * @param bytes
     * @param publicKey
     * @return
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     */
    public static byte[] encryTentimes(byte[] bytes,PublicKey publicKey) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        byte[] bytes1=null;
        for (int i=0;i<2;i++){
            bytes1= publicEncrytype(bytes, publicKey);
            bytes=bytes1;
        }
        return bytes1;
    }

    /**
     * 解密十次
     * @param bytes
     * @param privateKey
     * @return
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     * @throws BadPaddingException
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     */
    public static byte[] decryTentimes(byte[] bytes,PrivateKey privateKey) throws IllegalBlockSizeException, InvalidKeyException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        byte[] bytes1=null;
        for (int i=0;i<2;i++){
            bytes1=privateDecrypt(bytes,privateKey);
            bytes=bytes1;
        }
        return bytes1;
    }
}
