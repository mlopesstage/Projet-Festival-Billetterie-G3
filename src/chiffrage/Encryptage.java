package chiffrage;

import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Encryptage {
    
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String login = "btssio";
        
        MessageDigest mdLogin = MessageDigest.getInstance("MD5");
        mdLogin.update(login.getBytes());
        byte[] digestLogin = mdLogin.digest();
        StringBuffer sbLogin = new StringBuffer();
        for (byte b : digestLogin) {
            sbLogin.append(String.format("%02x", b & 0xff));
        }
        
        System.out.println(sbLogin.toString());
    } 
    
    
    
}