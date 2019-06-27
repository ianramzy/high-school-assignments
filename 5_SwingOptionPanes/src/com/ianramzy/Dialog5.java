// Class that opens a window where you can enter a number and it returns if you pass or fail and by how much
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import javax.swing.*;

public class Dialog5 {
    Dialog5() {
        double a, b;
        String inputValue = JOptionPane.showInputDialog("DID YOU PASS OR FAIL?");

        try {
            a = Double.parseDouble(inputValue);
            if (a >= 50) {
                b = 100 - a;
                JOptionPane.showMessageDialog(null, "<html>Good Work! You PASS!<br> Only " + b + " % more till 100%!" + "</html>");
            } else if (a < 50) {
                b = 50 - a;
                JOptionPane.showMessageDialog(null, "<html>Work Harder! You FAIL!<br> Only " + b + " % more till you pass!" + "</html>");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");
            new Dialog5();
        }
    }

    public static void main(String[] args) {
        new Dialog5();
    }
}
