// Class that prints an input text in the console in a hollow pyramid pattern
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import javax.swing.*;

public class Pyramid2 {
    public Pyramid2() {
        String word = JOptionPane.showInputDialog("Enter a word to be pyramid2-ified");
        int len = word.length();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.print(word.substring(i, i + 1));
            System.out.println();
        }

        for (int i = 0; i < len; i++) {
            for (int j = len - 2; j > i; j--) {
                System.out.print(" ");
            }

            if (i <= len - 2) { //checks and doesn't draw string if out of bounds
                System.out.print(word.substring(len - i - 2, len - i - 1));
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        new Pyramid2();
    }
}