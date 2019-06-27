// Tesla car builder
// Version 1.0
// Ian Ramzy

package com.ianramzy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.border.*;

public class CarOrder extends JFrame implements ActionListener, ItemListener{

    // Declare objects
    private JLabel topLabel, priceLabel,teslaLabel;
    private JButton doneButton, redButton, blackButton, whiteButton, customButton;
    private JRadioButton radio1,radio2,radio3;
    private JCheckBox chkbox1,chkbox2,chkbox3,chkbox4,chkbox5;
    private Color color = Color.lightGray;
    private Font courier;
    int carPrice = 0;
    int optionsPrice = 0;
    int totalPrice =0;
    JPanel content2 = new JPanel();

    public CarOrder(int xpos, int ypos) {
        super("Tesla Design Studio");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(xpos, ypos, 600, 675);
        this.setResizable(false);

        ImageIcon teslaIcon = new ImageIcon("src/com/ianramzy/tesla.png");
        ImageIcon msIcon = new ImageIcon("src/com/ianramzy/models.png");
        ImageIcon mxIcon = new ImageIcon("src/com/ianramzy/modelx.png");
        ImageIcon m3Icon = new ImageIcon("src/com/ianramzy/model3.png");
        ImageIcon redIcon = new ImageIcon("src/com/ianramzy/red.jpg");
        ImageIcon whiteIcon = new ImageIcon("src/com/ianramzy/white.jpg");
        ImageIcon blackIcon = new ImageIcon("src/com/ianramzy/black.jpg");
        ImageIcon closeIcon = new ImageIcon("src/com/ianramzy/close.png");

        topLabel = new JLabel("TESLA BUILDER", JLabel.CENTER);
        priceLabel = new JLabel("Price: ");
        teslaLabel = new JLabel(teslaIcon);
        redButton = new JButton(redIcon);
        blackButton = new JButton(blackIcon);
        whiteButton = new JButton(whiteIcon);
        customButton = new JButton("Custom Color");
        doneButton = new JButton(closeIcon);
        radio1 = new JRadioButton(msIcon);
        radio2 = new JRadioButton(mxIcon);
        radio3 = new JRadioButton(m3Icon);
        chkbox1 = new JCheckBox("Autopilot");
        chkbox2 = new JCheckBox("Air Suspension");
        chkbox3 = new JCheckBox("Premium Sound");
        chkbox4 = new JCheckBox("Extra Charger");
        chkbox5 = new JCheckBox("Spare Tire");

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        group.add(radio3);

        JPanel outerMaster = new JPanel (new GridLayout(5,1));
        outerMaster.setLayout(new BoxLayout(outerMaster, BoxLayout.Y_AXIS));

        JPanel content0 = new JPanel();
        content0.add(topLabel);
        content0.add(teslaLabel);
        courier = new Font("Courier", Font.PLAIN, 30);
        topLabel.setFont(courier);
        outerMaster.add(content0);

        JPanel content1 = new JPanel();
        content1.add(radio1);
        content1.add(radio2);
        content1.add(radio3);
        outerMaster.add(content1);

        ButtonGroup group2 = new ButtonGroup();
        group2.add(blackButton);
        group2.add(redButton);
        group2.add(whiteButton);
        content2.add(blackButton);
        content2.add(redButton);
        content2.add(whiteButton);
        content2.add(customButton);
        outerMaster.add(content2);

        JPanel content3 = new JPanel();
        content3.add(chkbox1);
        content3.add(chkbox2);
        content3.add(chkbox3);
        content3.add(chkbox4);
        content3.add(chkbox5);
        outerMaster.add(content3);

        JPanel content4 = new JPanel();
        content4.add(priceLabel);
        outerMaster.add(content4);

        JPanel content5 = new JPanel();
        content5.add(doneButton);
        outerMaster.add(content5);

        //borders
        TitledBorder border1 = new TitledBorder (new LineBorder (Color.black), "Model select");
        TitledBorder border2 = new TitledBorder (new LineBorder (Color.black), "Paint select");
        TitledBorder border3 = new TitledBorder (new LineBorder (Color.black), "Options");
        TitledBorder border4 = new TitledBorder (new LineBorder (Color.black), "Price");
        content1.setBorder (border1);
        content2.setBorder (border2);
        content3.setBorder (border3);
        content4.setBorder (border4);

        customButton.addActionListener(this);
        doneButton.addActionListener(this);
        radio1.addActionListener(this);
        radio2.addActionListener(this);
        radio3.addActionListener(this);
        chkbox1.addItemListener(this);
        chkbox2.addItemListener(this);
        chkbox3.addItemListener(this);
        chkbox4.addItemListener(this);
        chkbox5.addItemListener(this);

        this.setContentPane (outerMaster);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        int ypos = 50;
        int xpos = 50;
        new CarOrder(xpos, ypos);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == radio1) {
            topLabel.setText("Model S");
            carPrice = 75000;
            totalPrice = carPrice + optionsPrice;
            priceLabel.setText("Price: " + totalPrice);
        }if (e.getSource() == radio2) {
            topLabel.setText("Model X");
            carPrice = 85000;
            totalPrice = carPrice + optionsPrice;
            priceLabel.setText("Price: " + totalPrice);
        }if (e.getSource() == radio3) {
            topLabel.setText("Model 3");
            carPrice = 45000;
            totalPrice = carPrice + optionsPrice;
            priceLabel.setText("Price: " + totalPrice);
        }if (e.getSource() == doneButton) {
            this.dispose();
            System.exit(0);
        }if (e.getSource() == customButton) {
            Color newColor = JColorChooser.showDialog(null,"Choose Background Color", color);
            content2.setBackground(newColor);
            topLabel.setText("Custom Paint");
        }
    }

    public void itemStateChanged(ItemEvent e) {
        Object source = e.getSource();
        if (source == chkbox1) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                optionsPrice += 500;
                totalPrice = carPrice + optionsPrice;
                priceLabel.setText("Price: " + totalPrice);
            } else {
                optionsPrice -= 500;
                totalPrice = carPrice + optionsPrice;
                priceLabel.setText("Price: " + totalPrice);
            }
        }if (source == chkbox2) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                optionsPrice += 500;
                totalPrice = carPrice + optionsPrice;
                priceLabel.setText("Price: " + totalPrice);
            } else {
                optionsPrice -= 500;
                totalPrice = carPrice + optionsPrice;
                priceLabel.setText("Price: " + totalPrice);
            }
        }if (source == chkbox3) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                optionsPrice += 500;
                totalPrice = carPrice + optionsPrice;
                priceLabel.setText("Price: " + totalPrice);
            } else {
                optionsPrice -= 500;
                totalPrice = carPrice + optionsPrice;
                priceLabel.setText("Price: " + totalPrice);
            }
        }if (source == chkbox4) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                optionsPrice += 500;
                totalPrice = carPrice + optionsPrice;
                priceLabel.setText("Price: " + totalPrice);
            } else {
                optionsPrice -= 500;
                totalPrice = carPrice + optionsPrice;
                priceLabel.setText("Price: " + totalPrice);
            }
        }if (source == chkbox5) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                optionsPrice += 500;
                totalPrice = carPrice + optionsPrice;
                priceLabel.setText("Price: " + totalPrice);
            } else {
                optionsPrice -= 500;
                totalPrice = carPrice + optionsPrice;
                priceLabel.setText("Price: " + totalPrice);
            }
        }
    }
}