// Class that opens a window with a game where you must catch a picture by clicking it
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.event.MouseEvent;

public class CatCatcher extends JFrame implements ActionListener, MouseListener {
    private JLabel cat, scoreLabel;
    private Timer catTimer, gameTimer, iconTimer1, iconTimer2;
    private Random random = new Random();
    int score = 0;

    public CatCatcher() {
        this.setBounds(100, 100, 1280, 720);
        setTitle("Feed Donald");
        setContentPane(new JLabel(new ImageIcon("src/com/ianramzy/background.jpg")));

        cat = new JLabel(new ImageIcon("src/com/ianramzy/doughnut.png"));
        add(cat);

        //CANT GET THE SCORE LABEL TO UPDATE PROPERLY WITHOUT AFFECTING THE MOVEMENT OF THE 'CAT'
//        scoreLabel = new JLabel("Score: ");
//        Font courier = new Font("Courier", Font.PLAIN, 30);
//        scoreLabel.setFont(courier);
//        scoreLabel.setForeground(Color.white);
//        add(scoreLabel);

        gameTimer = new Timer(15000, this); //game length is 15s
        gameTimer.start();
        iconTimer1 = new Timer(2000, this); //icons changes every 2s
        iconTimer1.start();
        iconTimer2 = new Timer(3000, this); //icons changes every 2s
        catTimer = new Timer(1000, this); // cat moves every second
        catTimer.start();
        cat.addMouseListener(this);

        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("src/com/ianramzy/trump1.png").getImage(), new Point(32, 32), "custom cursor"));

        getContentPane().setLayout(new FlowLayout());
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        cat.setSize(128, 128);
        if (e.getSource() == catTimer) {
            cat.setLocation(random.nextInt(getWidth() - cat.getWidth()), random.nextInt(getHeight() - cat.getHeight()));
        }
        if (e.getSource() == gameTimer) {
            cat.setVisible(false);
            catTimer.stop();
            gameTimer.stop();
            JOptionPane.showMessageDialog(null, "Your score is " + score);
            new Score(score, this);

            Object[] options = {"Play Again", "I Don't Want to Have Anymore Fun"};
            int choice = JOptionPane.showOptionDialog(null, "How many?", "Important", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (choice == 0) {
                catTimer.restart();
                gameTimer.restart();
                cat.setVisible(true);
                score = 0;
            } else {
                this.dispose();
                System.exit(0);
            }
        }

        if (e.getSource() == iconTimer1) { //timer to change cursor and cat img 1
            setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("src/com/ianramzy/trump1.png").getImage(), new Point(32, 32), "custom cursor"));
            cat.setIcon(new ImageIcon("src/com/ianramzy/doughnut.png"));
            iconTimer2.start();
            iconTimer1.stop();
        }
        if (e.getSource() == iconTimer2) { //timer to change cursor and cat img 2
            setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon("src/com/ianramzy/trump2.png").getImage(), new Point(32, 32), "custom cursor"));
            cat.setIcon(new ImageIcon("src/com/ianramzy/bitcoin.png"));
            iconTimer1.start();
            iconTimer2.stop();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == cat) {
            actionPerformed(new ActionEvent(catTimer, 0, ""));
            catTimer.restart();
            Toolkit.getDefaultToolkit().beep(); //better sound effect plz
            score++;
            cat.setLocation(random.nextInt(getWidth() - cat.getWidth()), random.nextInt(getHeight() - cat.getHeight()));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }

    public static void main(String[] args) {
        new CatCatcher();
    }
}
//Music,title screen,view timer and score as playing