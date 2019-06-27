// Class that prints an input text in the console in a pyramid pattern
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import javax.swing.*;

public class Pyramid {
    public Pyramid() {
        String word = JOptionPane.showInputDialog("Enter a word to be pyramidi-fied");
        int len = word.length();

        for (int i = 0; i < len; i++) {
            System.out.print(word.substring(0, i + 1));
            System.out.println();
        }

        for (int i = 0; i < len; i++) {
            System.out.print(word.substring(0, len - i - 1));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Pyramid();
    }
}