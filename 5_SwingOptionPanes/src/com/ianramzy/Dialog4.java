// Class that opens a window where you can convert temperatures
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import javax.swing.*;
import java.text.DecimalFormat;


public class Dialog4 {
    double a, b;
    String input;

    public Dialog4() {
        JRadioButton radio1 = new JRadioButton("C° to F°", true); //default c to f is chosen
        JRadioButton radio2 = new JRadioButton("F° to C°");
        JRadioButton radio3 = new JRadioButton("C° to K°");
        JTextField text1 = new JTextField("Temp");

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        group.add(radio3);

        DecimalFormat Formatter = new DecimalFormat("#0.00");

        Object[] newOptions = {radio1, radio2,radio3, text1, "Done"};
        JOptionPane.showOptionDialog(null, "Temperature Converter", "Input", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, newOptions, newOptions[2]);

        if (radio1.isSelected()) {
            // C to F
            input = text1.getText();
            try {
                a = Double.parseDouble(input);
                b = a * 1.8 + 32;
                JOptionPane.showMessageDialog(null, a + "° Celsius = " + Formatter.format(b) + "° Fahrenheit");
                if (a <= 0) {
                    JOptionPane.showMessageDialog(null, "That's Cold! Don't forget a Jacket!");
                } else if (a >= 100) {
                    JOptionPane.showMessageDialog(null, "Careful! Its boiling outside (literally)");
                }
            } catch (NumberFormatException ex) {
                a = 0;
                JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");
                new Dialog4();
            }
        }
        if (radio2.isSelected()) {
            // F to C
            input = text1.getText();
            try {
                a = Double.parseDouble(input);
                b = a * 0.5556 - 17.777;
                JOptionPane.showMessageDialog(null, a + "° Fahrenheit = " + Formatter.format(b) + "° Celsius");
                if (a <= 32) {
                    JOptionPane.showMessageDialog(null, "That's Cold! Don't forget a Jacket!");
                } else if (a >= 212) {
                    JOptionPane.showMessageDialog(null, "Careful! Its boiling outside (literally)");
                }
            } catch (NumberFormatException ex) {
                a = 0;
                JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");
                new Dialog4();
            }
        }if (radio3.isSelected()) {
            // C to K
            input = text1.getText();
            try {
                a = Double.parseDouble(input);
                b = a + 273.15;
                JOptionPane.showMessageDialog(null, a + "° Celsius = " + Formatter.format(b) + "° Kelvin");
                if (a <= 32) {
                    JOptionPane.showMessageDialog(null, "That's Cold! Don't forget a Jacket!");
                } else if (a >= 212) {
                    JOptionPane.showMessageDialog(null, "Careful! Its boiling outside (literally)");
                }
            } catch (NumberFormatException ex) {
                a = 0;
                JOptionPane.showMessageDialog(null, "Please Enter a Valid Number");
                new Dialog4();
            }
        }
    }

    public static void main(String[] args) {
        new Dialog4();
    }
}
