// Class that opens a title screen for memory
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MasterClass extends JFrame implements ActionListener {
    private JButton button1, button2, button3;
    private JLabel label1, pictureLabel;
    Font courier;

    private MasterClass(int xpos, int ypos) {
        super("Memory");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(xpos, ypos, 333, 420);

        JPanel outerContent = new JPanel(new BorderLayout());

        JPanel content = new JPanel();

        button1 = new JButton("Play");
        button2 = new JButton("Quit");
        button3 = new JButton("Help");
        label1 = new JLabel("Welcome to Memory!");
        pictureLabel = new JLabel((new ImageIcon("src/com/ianramzy/background.jpeg")));

        courier = new Font("Courier", Font.PLAIN, 30);
        label1.setFont(courier);

        outerContent.add(label1, BorderLayout.NORTH);
        content.add(button1);
        content.add(button2);
        content.add(button3);
        content.add(pictureLabel);
        outerContent.add(content, BorderLayout.CENTER);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);

        this.setContentPane(outerContent);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        int ypos = 150;
        int xpos = 150;
        new MasterClass(xpos, ypos);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            new Memory();
        } else if (e.getSource() == button2) {
            this.dispose();
            System.exit(0);
        } else if (e.getSource() == button3) {  // help dialog
            JOptionPane.showMessageDialog(null, "Click a tile to show its value\ntry to find all matching pairs\nin the fewest clicks");
        }
    }
}