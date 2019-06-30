// Card class used for card objects in memory game
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import javax.swing.*;

public class Card extends JButton {

    private int value;

    public Card(int value) {
        this.value = 0;
    }

    public void setValue(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
