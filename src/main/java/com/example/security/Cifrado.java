/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.security;

import java.security.InvalidKeyException;
import java.security.Key;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;

public  class Cifrado {
    
    static String algorithm = "DESede";
    public Key key;
    public Cipher c;
    
    private static byte[] encryptF(String input,Key pkey,Cipher c) throws Exception {
        c.init(Cipher.ENCRYPT_MODE, pkey);
        byte[] inputBytes = input.getBytes();
         c = null;
         c = Cipher.getInstance(algorithm);
        return c.doFinal(inputBytes);
    }

    private static String decryptF(byte[] encryptionBytes,Key pkey,Cipher c) throws Exception,
    BadPaddingException, IllegalBlockSizeException {
    c.init(Cipher.DECRYPT_MODE, pkey);
    byte[] decrypt = c.doFinal(encryptionBytes);
    String decrypted = new String(decrypt);
    c = null;
    c = Cipher.getInstance(algorithm);

  return decrypted;
    }

    public Cifrado() {
        
        try
        {
        if(key == null)
        {
        key = KeyGenerator.getInstance(algorithm).generateKey();
        c = Cipher.getInstance(algorithm);
        String llave = key.toString();
        
        }
        }
        catch(Exception e)
        {
            System.out.println("com.example.security.Cifrado.<init>()");
        }
    }
    
}
