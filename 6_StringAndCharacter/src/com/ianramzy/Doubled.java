// Class that prints an input text in the with each letter doubled
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import javax.swing.*;

public class Doubled {
    public Doubled() {
        String word = JOptionPane.showInputDialog("Enter a word to be doubled:");
        int len = word.length();
        for (int i = 0; i < len; i++) {
            System.out.print(word.substring(i, i + 1));
            System.out.print(word.substring(i, i + 1));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new Doubled();
    }
}