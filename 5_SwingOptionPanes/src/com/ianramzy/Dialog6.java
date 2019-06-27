// Class that opens a window where you can compare the value of two numbers and determine which is larger
// and by what factor and tells you if your numbers are prime or not
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import javax.swing.*;

public class Dialog6 {
    public Dialog6() {
        double a = 0, b = 0, c, value;
        boolean isPrime = false;
        String inputValue1 = JOptionPane.showInputDialog("First number to test: ");
        String inputValue2 = JOptionPane.showInputDialog("Second number to test: ");

        try {
            a = Double.parseDouble(inputValue1);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");
            new Dialog6();
        }

        try {
            b = Double.parseDouble(inputValue2);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");
            new Dialog6();
        }

        if (a > b) {
            c = a / b;
            JOptionPane.showMessageDialog(null, "A is bigger by a factor of: " + c);
        } else if (a < b) {
            c = b / a;
            JOptionPane.showMessageDialog(null, "B is bigger by a factor of: " + c);
        } else if (a == b) {
            JOptionPane.showMessageDialog(null, "A and B are equal");
        }

        //calculate if number is prime or not
        for (int j = 0; j < a; j++) {
            for (int i = 2; i < a; i++) {
                double remainder = a % i;
                if (remainder == 0) {
                    isPrime = true;
                    break;
                } else if (remainder > 0 && i == (a - 1)) {
                    isPrime = false;
                }
            }
        }

        //return if it is or isn't prime
        if (isPrime) {
            JOptionPane.showMessageDialog(null, "Your number: " + a + " is NOT prime");
        } else {
            JOptionPane.showMessageDialog(null, "Your number: " + a + " is prime");
        }

        //calculate if 2nd number is prime or not
        for (int j = 0; j < b; j++) {
            for (int i = 2; i < b; i++) {
                double remainder = b % i;
                if (remainder == 0) {
                    isPrime = true;
                    break;
                } else if (remainder > 0 && i == (b - 1)) {
                    isPrime = false;
                }
            }
        }

        //return if it is or isn't prime
        if (isPrime) {
            JOptionPane.showMessageDialog(null, "Your number: " + b + " is NOT prime");
        } else {
            JOptionPane.showMessageDialog(null, "Your number: " + b + " is prime");
        }
    }

    public static void main(String[] args) {
        new Dialog6();
    }
}