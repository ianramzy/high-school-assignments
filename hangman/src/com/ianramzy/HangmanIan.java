package com.ianramzy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class HangmanIan extends JFrame implements MouseListener, KeyListener {
    private JLabel wrongLetLabel, textLabel;
    JLabel hangLabel;
    Font courier = new Font("Courier", Font.PLAIN, 40);
    String displayText, s;

    final int maxTries = 6;     //Tries until game lost
    int lettersWrong = 0;       //Current number of incorrect guesses.
    int lettersCorrect = 0;     //Number of correct letters in 'correct'.
    final int maxWordLen = 20;  //Maximum allowed length of a secret word.
    int secretWordLen;          //Length of the secret word.
    char secretWord[];          //Array containing the letters in the secret word.
    char wrongLetters[];        //Array containing the incorrectly guessed letters.
    char correctLetters[];      //Array containing the correctly guessed letters.

    public HangmanIan() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 600, 800);
        JPanel content = new JPanel(new BorderLayout());

        wrongLetters = new char[maxTries];
        secretWord = new char[maxWordLen];
        correctLetters = new char[maxWordLen];

        hangLabel = new JLabel(new ImageIcon("src/com/ianramzy/pics/gif/h0.gif"));
        wrongLetLabel = new JLabel();
        wrongLetLabel.setFont(courier);

        textLabel = new JLabel("_ _");
        textLabel.setFont(courier);

        content.add(hangLabel, BorderLayout.CENTER);
        content.add(textLabel, BorderLayout.NORTH);
        content.add(wrongLetLabel, BorderLayout.SOUTH);

        s = newGame();

        this.setContentPane(content);
        this.setVisible(true);
        addKeyListener(this);
        addMouseListener(this);
    }

    public void keyPressed(KeyEvent e) {
        boolean found = false;
        char key = e.getKeyChar();
        if (!Character.isLetter(key)) {    // check if valid letter; return if not
            return;
        }
        key = Character.toLowerCase(key);

        // check if already guessed and correct
        for (int i = 0; i < secretWordLen; i++) {
            if (key == correctLetters[i]) {
                return;
            }
        }

        // check if already guessed and wrong
        for (int i = 0; i < maxTries; i++) {
            if (key == wrongLetters[i]) {
                return;
            }
        }

        for (int i = 0; i < secretWordLen; i++) {    // is letter in secret word? If so, add it to correct[].
            if (key == secretWord[i]) {
                correctLetters[i] = (char) key;
                lettersCorrect++;
                found = true;
            }
        }

        if (!found) {
            if (lettersWrong < maxTries) {
                wrongLetters[lettersWrong] = (char) key;
                lettersWrong++;
            }
        }
        updateWindow(key, s);
    }

    public void updateWindow(char guesschar, String s) {
        System.out.println("s in update wiindow: " + s);
        hangLabel.setIcon(new ImageIcon("src/com/ianramzy/pics/gif/h" + lettersWrong + ".gif")); //update hangman
        wrongLetLabel.setText("Wrong: " + Arrays.toString(wrongLetters)); // draw list of wrong letters

        // update display text

        for (int i = 0; i < lettersCorrect; i++) {
            int x = s.indexOf(guesschar);
            StringBuilder tempText = new StringBuilder(displayText);

            if (x >= 0) {
                tempText.setCharAt(x * 2, guesschar);
                displayText = tempText.toString();
                textLabel.setText(displayText);

            }
        }

        if (lettersCorrect == secretWordLen && lettersCorrect != 0) {
            hangLabel.setIcon(new ImageIcon("src/com/ianramzy/pics/win.gif")); //update hangman to win gif
            Object[] options = {"Play Again", "I Don't Want to Have Anymore Fun"};
            int choice = JOptionPane.showOptionDialog(null, "Game Won!", "Game Won", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (choice == 0) {
                newGame();
            } else {
                this.dispose();
                System.exit(0);
            }
        }

        if (lettersWrong == maxTries) {
            hangLabel.setIcon(new ImageIcon("src/com/ianramzy/pics/lose.gif")); //update hangman to lose gif
            Object[] options = {"Play Again", "I Don't Want to Have Anymore Fun"};
            int choice = JOptionPane.showOptionDialog(null, "Game Lost, The Word Was: " + s, "Game Lost", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (choice == 0) {
                newGame();
            } else {
                this.dispose();
                System.exit(0);
            }
        }
    }

    public String newGame() {
        //Start a new game. Choose a new secret word & clear all the arrays
        System.out.println("NEW GAME");
        String[] wordlist = new String[25];
        String[] line;
        try {
            BufferedReader file = new BufferedReader(new FileReader("src/com/ianramzy/words.txt"));
            for (int i = 0; i < 25; i++) {
                line = file.readLine().split("\\s");
                wordlist[i] = line[0];
            }
        } catch (java.io.IOException e) {
            JOptionPane.showMessageDialog(null, "File read Error");
            s = "abcde"; //if no file found default word
        }

        s = wordlist[(int) (Math.random() * wordlist.length)].toLowerCase();

        System.out.println("s: " + s);

        secretWordLen = Math.min(s.length(), maxWordLen);   // Get length of word; chop it if too long.
        secretWordLen = s.length();
        for (int i = 0; i < secretWordLen; i++) {   // Store individual letters in character array
            secretWord[i] = s.charAt(i);
        }

        for (int i = 0; i < s.length(); i++) {   // clear correct letters array
            correctLetters[i] = 0;
        }

        correctLetters = new char[s.length()];
        lettersCorrect = 0;

        for (int i = 0; i < maxTries; i++) {     // clear wrong letters array
            wrongLetters[i] = 0;
        }
        lettersWrong = 0;


        displayText = "";
        for (int i = 0; i < secretWordLen; i++) {
            displayText += "_ ";
        }

        System.out.println("s AT END OF NEW GAME: " + s);
        updateWindow(' ', s);

        textLabel.setText(displayText);

        System.out.println("s AT VERY VERY END OF NEW GAME: " + s);
        return s;
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {
        new HangmanIan();
    }

}