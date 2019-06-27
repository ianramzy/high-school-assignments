// Programs that calculates the hypotenuse of a triangle given two sides
// from user input
// Ian Ramzy
// Version 1.2

package com.ianramzy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class Pythagorean extends JFrame implements ActionListener {
    // Declare objects
    double a, b;
    private JLabel label1, label2, label3;
    private JButton button1, button2;
    private JTextField text1, text2;

    public Pythagorean(int xpos, int ypos) {
        super("Pythagorean");

        // Set up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(xpos, ypos, 270, 150);

        // Create objects
        JPanel outer = new JPanel(new BorderLayout());
        JPanel content = new JPanel();
        label1 = new JLabel("HYPOTENUSE CALCULATOR  ", JLabel.CENTER);
        label2 = new JLabel("Enter side a length: ", JLabel.CENTER);
        text1 = new JTextField(10);
        label3 = new JLabel("Enter side b length: ", JLabel.CENTER);
        text2 = new JTextField(10);
        button1 = new JButton("Calculate");
        button2 = new JButton("Done");

        // Add contents
        outer.add(content, BorderLayout.CENTER);

        content.add(label1);
        content.add(label2);
        content.add(text1);
        content.add(label3);
        content.add(text2);
        content.add(button1);
        content.add(button2);

        // Add listeners
        button1.addActionListener(this);
        button2.addActionListener(this);
        text1.addActionListener(this);
        text2.addActionListener(this);

        // Show the contents
        this.setContentPane(outer);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        //default window location
        int ypos = 300;
        int xpos = 300;
        new Pythagorean(xpos, ypos);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            try {
                a = Double.parseDouble(text1.getText());
            } catch (NumberFormatException ex) {
                a = 0;        // no value, default zero
                JOptionPane.showMessageDialog(null, "Please Enter a Side Length for a");
            } try {
                b = Double.parseDouble(text2.getText());
            } catch (NumberFormatException ex) {
                b = 0;        // no value, default zero
                JOptionPane.showMessageDialog(null, "Please Enter a Side Length for b");
            }if ((b > 0) && (a > 0)){
                //Format Decimals to Two Places and Display Message Dialog
                DecimalFormat Formatter = new DecimalFormat("#0.00");
                JOptionPane.showMessageDialog(null, "Hypotenuse: " + Formatter.format(Math.sqrt(a*a + b*b)));
            }
        } else if (e.getSource() == button2 ) {
            this.dispose();
            System.exit (0);
        }
    }
}