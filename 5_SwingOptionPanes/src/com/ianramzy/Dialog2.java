// Class that opens a window where you enter a number and it tells you if its prime or not
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import javax.swing.*;

public class Dialog2 {
    Dialog2(){
        int value;
        boolean isPrime = false;

        String inputValue = JOptionPane.showInputDialog("Enter a number:");

        try {
            value = Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            value = 0;
            JOptionPane.showMessageDialog(null, "Invalid Number");
        }

        //calculate if number is prime or not
        for (int j = 0; j < value; j++) {
            for (int i = 2; i < value; i++) {
                double remainder = value % i;
                if (remainder == 0) {
                    isPrime = true;
                    break;
                } else if (remainder > 0 && i == (value - 1)) {
                    isPrime = false;
                }
            }
        }

        //return if it is or isn't prime
        if (isPrime) {
            JOptionPane.showMessageDialog(null, "Your number: " + value + " is NOT prime");
        } else {
            JOptionPane.showMessageDialog(null, "Your number: " + value + " is prime");
        }
    }

    public static void main(String[] args) {
    new Dialog2();
    }
}
