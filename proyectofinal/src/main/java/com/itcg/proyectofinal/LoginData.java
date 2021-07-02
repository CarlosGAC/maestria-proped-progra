/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itcg.proyectofinal;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import lombok.Getter;

public class LoginData {

    @Getter
    private String user;
    private String password;

    private byte[] encryptPassword(String s) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return md.digest(s.getBytes(StandardCharsets.UTF_8));
    }

    private static String encryptedPasswordToString(byte[] passwordHash) {
        BigInteger bi = new BigInteger(1, passwordHash);
        StringBuilder result = new StringBuilder(bi.toString(16));

        while (result.length() < 32) {
            result.insert(0, '0');
        }

        return result.toString();
    }

    public LoginData(String user, String password) {
        this.user = user;
        this.password = encryptedPasswordToString(encryptPassword(password));
    }

    public boolean doPasswordsMatch(String comparingPassword) {
        return encryptedPasswordToString(encryptPassword(comparingPassword)).equalsIgnoreCase(password);
    }

    public boolean isLoginValid(String comparingUser, String comparingPassword) {
        return (user.equals(comparingUser) && doPasswordsMatch(comparingPassword));
    }

}
