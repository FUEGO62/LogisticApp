package org.Cryptography;

public class CaesarCipher {

    public static String encrypt(String plainText,int increment) {
        String cipherText = "";
        for (int i = 0; i < plainText.length(); i++) {
            cipherText += implementIncrement(plainText.charAt(i), increment);
        }
        return cipherText;
    }

    public static char implementIncrement(char letter, int increment) {

        return (char)((int) letter+increment);
    }
}
