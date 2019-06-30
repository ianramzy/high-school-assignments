// Class that handles saving and reading scores to a file as well as displaying them after each game
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Score extends JDialog {
    String[] namesArray = new String[10];
    String[] listItemsArray = {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0"};
    int[] highScoresArray = new int[10];
    JLabel scoreLabel = new JLabel();
    Font courier;

    public Score(int score, Frame owner) {
        super(owner, "TOP 10 WORST PLAYERS!", true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBounds(400, 400, 250, 220);

        JPanel myPanel = new JPanel(new BorderLayout());
        JList<String> scoreList = new JList<>(listItemsArray);
        scoreList.setFixedCellWidth(30);
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) scoreList.getCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);

        myPanel.add(scoreLabel, BorderLayout.NORTH);
        myPanel.add(scoreList);

        this.setContentPane(myPanel);
        updateScore(score, null);
    }

    public void updateScore(int newScore, String newName) {
        readScores();
        if (newName == null) {
            newName = JOptionPane.showInputDialog(null, "PLAYER NAME");
        }
        scoreLabel.setText(newName + " scored: " + newScore);
        courier = new Font("Courier", Font.PLAIN, 20);
        scoreLabel.setFont(courier);
        for (int i = 0; i < 10; i++) {
            if (newScore > highScoresArray[i]) {
                for (int j = 9; j > i; j--) {
                    highScoresArray[j] = highScoresArray[j - 1];
                    namesArray[j] = namesArray[j - 1];
                    listItemsArray[j] = listItemsArray[j - 1];
                }
                highScoresArray[i] = newScore;
                namesArray[i] = newName;
                listItemsArray[i] = newName + "  :  " + Integer.toString(highScoresArray[i]);
                writeScores();
                break;
            }
        }
        repaint();
        setVisible(true);
    }

    public void readScores() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("src/com/ianramzy/highscoresdoc.txt"));
            String x;
            int i = 0;
            while ((x = in.readLine()) != null) {
                highScoresArray[i] = Integer.parseInt(x);
                namesArray[i] = in.readLine();
                listItemsArray[i] = namesArray[i] + "  :  " + Integer.toString(highScoresArray[i]);
                i++;
            }
            in.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "File Load Error");
        }
    }

    public void writeScores() {
        try {
            PrintWriter out = new PrintWriter("src/com/ianramzy/highscoresdoc.txt");
            for (int i = 0; i < 10; i++) {
                out.println(highScoresArray[i]);
                out.println(namesArray[i]);
            }
            out.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "File Read Error");
        }
    }
}