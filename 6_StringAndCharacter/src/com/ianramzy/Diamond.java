// Class that prints an input text in the console in a diamond pattern
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import javax.swing.*;

public class Diamond {
    public Diamond() {
        String SPACES = "                              ";

        String word = JOptionPane.showInputDialog("Enter a word to be diamond-ified");
        int len = word.length();

        for (int i = 0; i < len; i++) {
            System.out.print(SPACES.substring(0,len - i));
            System.out.print((char)27 + "[32m"+word.substring(i, i + 1));

            if (i != 0){
                System.out.print(SPACES.substring(0,2*i - 1));
                System.out.print((char)27 + "[33m"+word.substring(i,i + 1));
            }
            System.out.println();
        }

        for (int i = 0; i < len -1; i++) {
            System.out.print(SPACES.substring(0, i + 2));
            System.out.print((char)27 + "[31m"+word.substring(len - i - 2, len - i -1));

            if (i != len -2){ //not draw last character
                System.out.print(SPACES.substring(0,len + 2 - 2*i));
                System.out.print((char)27 + "[36m"+word.substring(len - i - 2, len - i - 1));

            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Diamond();
    }
}
