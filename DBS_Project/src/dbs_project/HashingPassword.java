/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbs_project;

import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author sichi
 */
public class HashingPassword {
    
    public HashingPassword()
    {        
    }
    public static String hashPassword(String password)
    {   
        String password1=password;
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            password1 = DatatypeConverter.printHexBinary(hash);
            } catch (Exception ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return password1;
    }
}
