// Programs that calculates change
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChangeCount extends JFrame implements ActionListener, ItemListener {

    // Declare objects
    private JLabel label1, label2, label3, label4,label5;
    private JButton button1, button2;
    private JTextField text1;
    private JCheckBox chkbox1;
    ImageIcon icon = new ImageIcon ("src/com/ianramzy/coins.jpg");
    JLabel label6 = new JLabel (icon);
    double a;
    boolean usePennies;

    public ChangeCount(int xpos, int ypos) {
        super("Change Counter");

        // Set up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(xpos, ypos, 170, 480);

        // Create objects
        JPanel outer = new JPanel (new BorderLayout());
        JPanel content = new JPanel();

        label1 = new JLabel("Total Change in cents: ", JLabel.CENTER);
        label1.setFont (new Font ("Times New Roman",Font.BOLD | Font.ITALIC, 16));
        button1 = new JButton("Calculate Change");
        button2 = new JButton("Done");
        text1 = new JTextField(10);
        chkbox1 = new JCheckBox("Use pennies: ");
        label2 = new JLabel("[Quarters:  ]", JLabel.CENTER);
        label3 = new JLabel("[Dimes:  ]", JLabel.CENTER);
        label4 = new JLabel("[Nickles:  ]", JLabel.CENTER);
        label5 = new JLabel("[Pennies:  ]", JLabel.CENTER);

        // Add contents
        content.add (label6, BorderLayout.CENTER);
        outer.add (label1, BorderLayout.NORTH);
        outer.add(content, BorderLayout.CENTER);
        content.add(text1);
        content.add(chkbox1);
        content.add (label2, BorderLayout.CENTER);
        content.add (label3, BorderLayout.CENTER);
        content.add (label4, BorderLayout.CENTER);
        content.add (label5, BorderLayout.CENTER);
        content.add(button1);
        content.add(button2);

        // Add listeners
        button1.addActionListener(this);
        button2.addActionListener(this);
        text1.addActionListener(this);
        chkbox1.addItemListener(this);

        // Show the contents
        this.setContentPane (outer);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        //default window location
        int ypos = 300;
        int xpos = 300;
        new ChangeCount(xpos, ypos);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            try {
                a = Double.parseDouble(text1.getText());
            } catch (NumberFormatException ex) {
                a = 0;        // no value, default zero
            }
             CalculateChange(a, usePennies);
        }else if(e.getSource() == button2){
            this.dispose();
            System.exit (0);
        }
    }

    public void CalculateChange (double a, boolean usePennies){
        label5.setText("[Pennies: 0.0 ]");

        label1.setText("Change:  " + a + " cents");
        double quarters = a / 25;
        label2.setText("[Quarters: " + Math.floor(quarters) + " ]");
        a = a % 25;
        double dimes = a / 10;
        label3.setText("[Dimes: " + Math.floor(dimes)+ " ]");
        a = a % 10;
        double nickles = a / 5;
        label4.setText("[Nickles: " + Math.floor(nickles)+ " ]");
        a = a % 5;

        //Handles if pennies are wanted, if not round for nickles
        if (usePennies){
            double pennies = a ;
            label5.setText("[Pennies: " + Math.floor(pennies)+ " ]");
            a = 0;
        }else if (a>= 3){
            nickles = nickles + 1;
            label4.setText("[Nickles: " + Math.floor(nickles)+ " ]");
        }
    }

    public void itemStateChanged(ItemEvent e) {
        Object source = e.getSource();
        if (source == chkbox1) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                label1.setText("Use pennies for change");
                usePennies = true;
            } else {
                label1.setText("Don't use pennies for change.");
                usePennies = false;
            }
        }
    }
}