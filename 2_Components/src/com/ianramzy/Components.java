// Programs that opens a window with various components on it
// Ian Ramzy
// Version 1.1 test

package com.ianramzy;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Components extends JFrame implements ActionListener, ItemListener, ListSelectionListener {

    // Declare objects
    private JLabel label, label2;
    private JButton button1, button2, button3, button4;
    private JTextField text;
    private JRadioButton radio1, radio2;
    private JCheckBox chkbox1, chkbox2;
    private JList<String> list;
    private JComboBox<String> combo;

    private Components(int xpos, int ypos) {
        super("Components");

        // Set up the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(xpos, ypos, 170, 480);

        // Create objects
        JPanel outer = new JPanel (new BorderLayout());
        JPanel content = new JPanel();
        label = new JLabel("README", JLabel.CENTER);
        label2 = new JLabel("Pick your favorite below");
        button1 = new JButton("Button1");
        button2 = new JButton("Button2");
        button3 = new JButton("New Window");
        button4 = new JButton("25 New Windows");
        text = new JTextField(10);
        radio1 = new JRadioButton("Radio Button 1");
        radio2 = new JRadioButton("Radio Button 2");
        chkbox1 = new JCheckBox("CheckBox 1");
        chkbox2 = new JCheckBox("CheckBox 2");
        String[] listItems = {"Toronto", "Vancouver", "Kingston!!!"};
        list = new JList<>(listItems);
        String[] comboItems = {"Ian", "Abdel", "Ewan", "Pouya", "Johnson"};
        combo = new JComboBox<>(comboItems);
        combo.setEditable(true);

        //Group the radio buttons (so only one can be selected at a time)
        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);

        // Add contents
        outer.add (label, BorderLayout.NORTH);
        outer.add(content, BorderLayout.CENTER);

        content.add(button1);
        content.add(button2);
        content.add(button3);
        content.add(button4);
        content.add(text);
        content.add(radio1);
        content.add(radio2);
        content.add(chkbox1);
        content.add(chkbox2);
        content.add(list);
        content.add(label2);
        content.add(combo);

        // Add listeners
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        text.addActionListener(this);
        radio1.addActionListener(this);
        radio2.addActionListener(this);
        chkbox1.addItemListener(this);
        chkbox2.addItemListener(this);
        list.addListSelectionListener(this);
        combo.addActionListener(this);

        // Show the contents
        this.setContentPane (outer);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        //default window location
        int ypos = 300;
        int xpos = 300;
        new Components(xpos, ypos);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            label.setText("Button 1 was pressed.");
        } else if (e.getSource() == button2) {
            label.setText("Button 2 was pressed.");
        } else if (e.getSource() == button3) {
            label.setText("New Window was created.");
            //randomly places new window
            Random rn = new Random();
            new Components(rn.nextInt(700),rn.nextInt(700));
        } else if (e.getSource() == button4) {
            label.setText("25 New Windows created.");
            //randomly places new window
            Random rn = new Random();
            for (int i=0; i<=240; i++){
                new Components(rn.nextInt(700),rn.nextInt(700));
            }
            new Components(rn.nextInt(700),rn.nextInt(700));
        } else if (e.getSource() == text) {
            label.setText("You typed:  " + text.getText());
        } else if (e.getSource() == radio1) {
            label.setText("Radio Button 1 was pressed.");
        } else if (e.getSource() == radio2) {
            label.setText("Radio Button 2 was pressed.");
        } else if (e.getSource() == combo) {
            label.setText("Favorite student" + ": " + combo.getSelectedItem());
        }
    }

    public void itemStateChanged(ItemEvent e) {
        Object source = e.getSource();

        if (source == chkbox1) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                label.setText("CheckBox 1 was checked.");
            } else {
                label.setText("CheckBox 1 was unchecked.");
            }
        } else if (source == chkbox2) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                label.setText("CheckBox 2 was checked.");
            } else {
                label.setText("CheckBox 2 was unchecked.");
            }
        }
    }

    public void valueChanged(ListSelectionEvent e) {
        if (e.getSource() == list) {
            label.setText("List Item #" + list.getSelectedIndex() + ": " + list.getSelectedValue());
        }
    }
}