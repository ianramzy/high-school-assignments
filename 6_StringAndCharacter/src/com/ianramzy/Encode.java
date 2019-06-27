// Class that prints an input text in the console regular and coded
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import javax.swing.*;

public class Encode {
    public Encode() {
        String word = JOptionPane.showInputDialog("Enter a word to be Encode-ified");
        int len = word.length();
        System.out.println("Before: " + word);
        System.out.print("After: ");
        word.toUpperCase();

        for (int i = 0; i < len; i++) {
            char x = word.charAt(i);

            if (x != 'z'){
                x++;
            }else {
                x = 65;
            }
            System.out.print((char)27 + "[34m"+x);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new Encode();
    }
}
