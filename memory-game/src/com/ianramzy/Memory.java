// Game that opens a window to play a tile matching game (run this program from the master class)
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Memory extends JFrame implements ActionListener {
    private final int SIZE = 4;
    public int clicked, pairsFound, clicks;
    Card firstCard, secondCard;
    boolean noPair = false;
    Font courier = new Font("Courier", Font.PLAIN, 30);
    JLabel bottomLabel = new JLabel("Clicks: ");
    private Card[] card = new Card[SIZE * SIZE];

    public Memory() {
        JPanel masterPane = new JPanel(new BorderLayout());
        JPanel content = new JPanel(new GridLayout(4, 4));
        masterPane.add(BorderLayout.CENTER, content);

        JLabel topLabel = new JLabel("¿ Memory ?");
        masterPane.add(BorderLayout.NORTH, topLabel);
        topLabel.setFont(courier);

        masterPane.add(BorderLayout.SOUTH, bottomLabel);
        bottomLabel.setFont(courier);

        clicked = 0;
        pairsFound = 0;

        int indx;
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                indx = r * SIZE + c;
                card[indx] = new Card(indx);
                card[indx].addActionListener(this);
                content.add(card[indx]);
            }
        }

        for (int i = 1; i <= SIZE * SIZE / 2; i++) {
            for (int j = 0; j < 2; j++) {
                do {
                    indx = (int) (Math.random() * SIZE * SIZE);
                }
                while (card[indx].getValue() != 0);
                card[indx].setValue(i);
            }
        }

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(200, 200, 400, 400);
        this.setContentPane(masterPane);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        clicks++; //add 1 to 'score'
        bottomLabel.setText("Clicks: " + clicks);
        Card card = (Card) e.getSource();
        card.setText(Integer.toString(card.getValue()));

        clicked++;
        if (clicked == 1) {
            if (noPair) {
                secondCard.setText(" ");
                firstCard.setText(" ");
            }
            firstCard = card;
        } else if (clicked == 2) {
            secondCard = card;
            if (firstCard.getValue() == secondCard.getValue() && firstCard != secondCard) {
                firstCard.setBackground(Color.green); //changing color doesnt work on mac
                secondCard.setBackground(Color.green); //changing color doesnt work on mac
                pairsFound++;
                noPair = false;
                if (pairsFound == 8) {
                    JOptionPane.showMessageDialog(null, "Game Won! Your Score Was: " + clicks);
                    new Score(clicks, this);
                    this.dispose();
                }
            } else {
                noPair = true;  //If true clear card text next time action performed is called
            }
            clicked = 0;
        }
    }
}