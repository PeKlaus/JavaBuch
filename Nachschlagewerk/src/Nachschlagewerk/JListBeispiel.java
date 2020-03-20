package Nachschlagewerk;

import javax.swing.*;

public class JListBeispiel {
 
    public static void main(String[] args) {
        JFrame meinJFrame = new JFrame();
        meinJFrame.setTitle("JListBeispiel");
        meinJFrame.setSize(300, 300);
        JPanel panel = new JPanel();
 
        JLabel frage = new JLabel("F�r welche Themen interessierst du dich?");
        panel.add(frage);
 
        // Array f�r unsere JList
        String interessen[] = {"Politik", "Autos", "Mode", 
            "Film- und Fernsehen", "Computer", "Tiere", "Sport"};
 
        //JList mit Eintr�gen wird erstellt
        JList themenAuswahl = new JList(interessen);
 
        //JList wird Panel hinzugef�gt
        panel.add(themenAuswahl);
 
        meinJFrame.add(panel);
        meinJFrame.setVisible(true);
 
    }
}

// https://www.java-tutorial.org/jlist.html
