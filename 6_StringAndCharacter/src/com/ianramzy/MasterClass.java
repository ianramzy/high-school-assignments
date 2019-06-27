// Class that opens a window where you can run all of the various programs i've created for in this assignment
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MasterClass extends JFrame implements ActionListener {
    private JButton button1, button2, button3, button4, button5, button6, button7, button8;
    private JLabel label1;
    Font courier;

    private MasterClass(int xpos, int ypos) {
        super("Master Class");

        // Set up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(xpos, ypos, 400, 200);

        // Create objects
        JPanel outerContent = new JPanel(new BorderLayout());

        JPanel content = new JPanel(new GridLayout(2,3));

        button1 = new JButton("Spaced");
        button2 = new JButton("Doubled");
        button3 = new JButton("Triangle");
        button4 = new JButton("Pyramid");
        button5 = new JButton("Pyramid 2");
        button6 = new JButton("Diamond");
        button7 = new JButton("Encode");
        button8 = new JButton("Cipher");
        label1 = new JLabel("Click To Run A Program");

        courier = new Font("Courier", Font.PLAIN, 30);
        label1.setFont(courier);

        outerContent.add(label1, BorderLayout.NORTH);

        content.add(button1);
        content.add(button2);
        content.add(button3);
        content.add(button4);
        content.add(button5);
        content.add(button6);
        content.add(button7);
        content.add(button8);
        outerContent.add(content, BorderLayout.CENTER);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);
        button7.addActionListener(this);
        button8.addActionListener(this);

        this.setContentPane(outerContent);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        //default window location
        int ypos = 150;
        int xpos = 150;
        new MasterClass(xpos, ypos);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            new Spaced();
        } else if (e.getSource() == button2 ) {
            new Doubled();
        }else if (e.getSource() == button3 ) {
            new Triangle();
        }else if (e.getSource() == button4 ) {
            new Pyramid();
        }else if (e.getSource() == button5 ) {
            new Pyramid2();
        }else if (e.getSource() == button6 ) {
            new Diamond();
        }else if (e.getSource() == button7 ) {
            new Encode();
        }else if (e.getSource() == button8 ) {
            new Cipher();
        }
    }
}