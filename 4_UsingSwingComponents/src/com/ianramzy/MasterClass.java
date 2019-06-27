// Programs that runs all of the various programs i've created for in this assignment
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MasterClass extends JFrame implements ActionListener{
    private JButton button1, button2, button3, button4;
    private JLabel label1;

    private MasterClass(int xpos, int ypos) {
        super("Master Class");

        // Set up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(xpos, ypos, 270, 150);

        // Create objects
        JPanel outer = new JPanel(new BorderLayout());
        JPanel content = new JPanel();
        button1 = new JButton("Pythagorean");
        button2 = new JButton("Change Counter");
        button3 = new JButton("Font Style");
        button4 = new JButton("Car Order");
        label1 = new JLabel("Click To Run A Program");

        // Add contents
        outer.add(content, BorderLayout.CENTER);

        content.add(label1);
        content.add(button1);
        content.add(button2);
        content.add(button3);
        content.add(button4);

        // Add listeners
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);

        // Show the contents
        this.setContentPane(outer);
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
            new Pythagorean(50,50);
        } else if (e.getSource() == button2 ) {
            new ChangeCount(50,50);
        }else if (e.getSource() == button3 ) {
            new FontStyle();
        }else if (e.getSource() == button4 ) {
            new CarOrder(50,50);
        }
    }
}

