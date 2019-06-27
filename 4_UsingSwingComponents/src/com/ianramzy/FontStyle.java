// Program that displays various font types
// Version 1.0
// Ian Ramzy

package com.ianramzy;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;

public class FontStyle extends JFrame implements ActionListener {
    int size = 24;
    JLabel label;
    JButton bldItlButton, bldButton, itlButton, doneButton,
            courierButton, arialButton, impactButton;
    Font bold, italic, boldItalic, arial, courier, impact;

    public FontStyle() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(400, 400, 450, 300);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        label = new JLabel("Look at me!");

        ImageIcon closeIcon = new ImageIcon("src/com/ianramzy/close.png");

        bldItlButton = new JButton("Times Bold & Italic");
        itlButton = new JButton("Times Italic");
        bldButton = new JButton("Times Bold");
        impactButton = new JButton("Impact");
        courierButton = new JButton("Courier");
        arialButton = new JButton("Arial");
        doneButton = new JButton(closeIcon);

        bold = new Font("Times New Roman", Font.BOLD, size);
        italic = new Font("Times New Roman", Font.ITALIC, 24);
        boldItalic = new Font("Times New Roman", Font.ITALIC | Font.BOLD, 24);
        arial = new Font("Arial", Font.PLAIN, 24);
        courier = new Font("Courier", Font.PLAIN, 30);
        impact = new Font("Impact", Font.PLAIN, 24);

        JPanel line = new JPanel(new FlowLayout());
        line.add(label);
        panel.add(line);

        line = new JPanel(new FlowLayout());
        line.add(bldButton);
        line.add(itlButton);
        line.add(bldItlButton);
        panel.add(line);

        line = new JPanel(new FlowLayout());
        line.add(courierButton);
        line.add(arialButton);
        line.add(impactButton);
        panel.add(line);

        line = new JPanel(new FlowLayout());
        line.add(doneButton);
        panel.add(line);

        itlButton.addActionListener(this);
        bldButton.addActionListener(this);
        bldItlButton.addActionListener(this);
        courierButton.addActionListener(this);
        arialButton.addActionListener(this);
        doneButton.addActionListener(this);
        impactButton.addActionListener(this);

        this.setContentPane(panel);
        this.setVisible(true);

        // Check to see if you have the right fonts installed
        String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (int i = 0; i < fonts.length; i++) {
            System.out.println(fonts[i]);
        }
    }

    public static void main(String[] args) {
        new FontStyle();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bldButton) {
            label.setFont(bold);
        } else if (e.getSource() == itlButton) {
            label.setFont(italic);
        } else if (e.getSource() == bldItlButton) {
            label.setFont(boldItalic);
        } else if (e.getSource() == arialButton) {
            label.setFont(arial);
        } else if (e.getSource() == courierButton) {
            label.setFont(courier);
        } else if (e.getSource() == impactButton) {
            label.setFont(impact);
        } else if (e.getSource() == doneButton) {
            this.dispose();
            System.exit(0);
        }
    }
}
