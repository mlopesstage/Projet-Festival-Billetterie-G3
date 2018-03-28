/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chiffrage;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author btssio
 */
public class Encryptage {
    
    public static void main(String[] args) {
        String code = encrypt("joliverie", "b");
        System.out.println(code);
    } 
    
    public static String encrypt(String password,String key){
        
        try {
            Key clef = new SecretKeySpec(key.getBytes("UTF-8"),"Blowfish");
            Cipher cipher=Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE,clef);
            return new String(cipher.doFinal(password.getBytes()));
        } catch (Exception e) {
            return null;
        }
    }      
}
