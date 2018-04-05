package chiffrage;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encryptage {
    
    public static void main(String[] args) {
        String code = encrypt("joliverie", "b");
        System.out.println(code);
        String code2 = encrypt("btssio", "f");
        System.out.println(code2);
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