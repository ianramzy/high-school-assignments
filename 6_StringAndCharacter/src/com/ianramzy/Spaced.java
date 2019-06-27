// Class that prints an input text in the console with spaces between each letter
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import javax.swing.*;

public class Spaced {
    Spaced(){
        String word = JOptionPane.showInputDialog("Enter a word:");
        int len = word.length();
        for (int i = 0; i < len; i++) {
            System.out.print(word.substring(i, i + 1));
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new Spaced();
    }
}

