// Class that opens a window where you enter your name and it repeats it back to you
// Ian Ramzy
// Version 1.0

package com.ianramzy;

import javax.swing.*;

public class Dialog1 {
    Dialog1 (){
        // Simple Input dialog:
        String inputValue = JOptionPane.showInputDialog("Whats your name?:");
        // Simple Message dialog:
        JOptionPane.showMessageDialog(null, "Your name: " + inputValue);
        JOptionPane.showMessageDialog(null, "My name is Ian, nice to meet you!");
    }
    public static void main(String[] args) {
        new Dialog1();
    }
}
