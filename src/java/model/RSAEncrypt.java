/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Scanner;
import javax.crypto.Cipher;

/**
 *
 * @author slahiruc
 */
public class RSAEncrypt {
    
    
//     public static void main(String [] args) throws Exception {
//        // generate public and private keys
//        KeyPair keyPair = buildKeyPair();
//        PublicKey pubKey = keyPair.getPublic();
//        PrivateKey privateKey = keyPair.getPrivate();
//        
////        Scanner sc = new Scanner(System.in);
////        String mystring  = sc.next();
//        
//        // encrypt the message
//        byte [] encrypted = encrypt(privateKey, mystring);     
//        System.out.println(new String(encrypted));  // <<encrypted message>>
//        
//        // decrypt the message
//        byte[] secret = decrypt(pubKey, encrypted);                                 
//        System.out.println(new String(secret));     // This is a secret message
//    }

    public static KeyPair buildKeyPair() throws NoSuchAlgorithmException {
        final int keySize = 2048;
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keySize);      
        return keyPairGenerator.genKeyPair();
    }

    public static byte[] encrypt(PrivateKey privateKey, String message) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);  

        return cipher.doFinal(message.getBytes());  
    }
    
    public static byte[] decrypt(PublicKey publicKey, byte [] encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        
        return cipher.doFinal(encrypted);
    }
}
