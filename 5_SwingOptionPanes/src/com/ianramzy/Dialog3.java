// Class that calculates tax and total with a 20% tip
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import javax.swing.*;
import java.text.DecimalFormat;

public class Dialog3 {
    Dialog3() {
        double value;

        String inputValue = JOptionPane.showInputDialog("How much before tax: ");

        try {
            value = Double.parseDouble(inputValue);
            //Format to two decimal places
            DecimalFormat Formatter = new DecimalFormat("#0.00");

            //Print message on two lines and format decimal
            JOptionPane.showMessageDialog(null,
                    "<html>Total including tax is: " + Formatter.format(value * 1.13) +
                            "<br>Total including tax and 20% tip is: " + Formatter.format(value * 1.33) + "</html>");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Number");
        }
    }

    public static void main(String[] args) {
        new Dialog3();
    }
}