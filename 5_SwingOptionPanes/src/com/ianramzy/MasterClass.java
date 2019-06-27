// Class that opens a window where you can run all of the various programs i've created for in this assignment
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MasterClass extends JFrame implements ActionListener {
    private JButton button1, button2, button3, button4, button5, button6;
    private JLabel label1;

    private MasterClass(int xpos, int ypos) {
        super("Master Class");

        // Set up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(xpos, ypos, 270, 150);

        // Create objects
        JPanel outerContent = new JPanel(new BorderLayout());

        JPanel content = new JPanel(new GridLayout(2,3));

        button1 = new JButton("Dialog 1");
        button2 = new JButton("Dialog 2");
        button3 = new JButton("Dialog 3");
        button4 = new JButton("Dialog 4");
        button5 = new JButton("Dialog 5");
        button6 = new JButton("Dialog 6");
        label1 = new JLabel("Click To Run A Program");

        outerContent.add(label1, BorderLayout.NORTH);

        content.add(button1);
        content.add(button2);
        content.add(button3);
        content.add(button4);
        content.add(button5);
        content.add(button6);
        outerContent.add(content, BorderLayout.CENTER);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);

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
            new Dialog1();
        } else if (e.getSource() == button2 ) {
            new Dialog2();
        }else if (e.getSource() == button3 ) {
            new Dialog3();
        }else if (e.getSource() == button4 ) {
            new Dialog4();
        }else if (e.getSource() == button5 ) {
            new Dialog5();
        }else if (e.getSource() == button6 ) {
            new Dialog6();
        }
    }
}

