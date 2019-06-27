// Class that reads a file with a key and coded message and returns the solved key
// and decoded message
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Cipher {
    public Cipher() {
        String key, alpha, coded, message;
        try {
            BufferedReader f = new BufferedReader(new FileReader("src/com/ianramzy/data21.txt"));
            for (int i = 0; i < 5; i++) { //change to number of lines in read document
                key = f.readLine();
                System.out.println("         Key: " + key);
                coded = f.readLine();
                System.out.println("       coded: " + coded);
                alpha = prepareKey(key);
                System.out.println("Prepared Key: " + alpha);
                message = decode(coded, alpha);
                System.out.println("     Decoded: " + message);
                System.out.println(" ");
                System.out.println("   #################   ");
                System.out.println(" ");
            }
            f.close();
        } catch (IOException e) {
            System.out.println("File error");
        }
    }

    private static String prepareKey(String key) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        key = key + alphabet;
        String key2 = key.toUpperCase();
        String result = "";
        for (int i = 0; i < key2.length(); ++i) {
            char c = key2.charAt(i);
            if (result.indexOf(c) < 0 && c != ' ' && c >= 65) { // negative index indicates not present
                result += String.valueOf(c);
            }
        }
        return result;
    }

    private static String decode(String coded, String alpha) {
        String decoded = "";
        for (int i = 0; i < coded.length(); i += 2) {
            String x = coded.substring(i, i + 2);
            char left = x.charAt(0);
            char right = x.charAt(1);
            decoded += changeLetter2(right, alpha);
            decoded += changeLetter(left, alpha);
        }
        return decoded;
    }

    private static char changeLetter2(char right, String alpha) {
        char changeLetter2 = 0;
        if (right == alpha.charAt(alpha.indexOf('X') - 1)) { //handle spaces
            changeLetter2 += ' ';
            return changeLetter2;
        } else if (right == alpha.charAt(25)) { //Handle wrap around in alpha key
            changeLetter2 += alpha.charAt(0);
            return changeLetter2;
        } else {
            int a = alpha.indexOf(right);
            changeLetter2 += alpha.charAt(a + 1);
            return changeLetter2;
        }
    }

    private static char changeLetter(char left, String alpha) {
        char changeLetter = 0;
        if (left == alpha.charAt(alpha.indexOf('X') + 1)) { //handle spaces
            changeLetter += ' ';
            return changeLetter;
        } else if (left == alpha.charAt(0)) { //Handle wrap around in alpha key
            changeLetter += alpha.charAt(25);
            return changeLetter;
        } else {
            int a = alpha.indexOf(left);
            changeLetter += alpha.charAt(a - 1);
            return changeLetter;
        }
    }

    public static void main(String[] args) {
        new Cipher();
    }
}
// Tutorial used to determine if there is a repeat char in a string
// https://stackoverflow.com/questions/18426138/how-to-remove-duplicate-letters-with-a-loop-either-for-or-while-loop