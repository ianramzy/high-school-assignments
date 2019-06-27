// Class that prints an input text in the console in a triangle pattern
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import javax.swing.*;

public class Triangle {
    public Triangle() {
        String word = JOptionPane.showInputDialog("Enter a word to be triangled");
        int len = word.length();
        for (int i = 0; i < len; i++) {
            System.out.print((char)27 + "[35m"+word.substring(0, i + 1));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Triangle();
    }
}
