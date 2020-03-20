package Nachschlagewerk;

import javax.swing.*;

public class JListModell {
 
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
 
        //DefaultListModell wird erzeugt
        DefaultListModel listenModell = new DefaultListModel();
 
        //JList mit Eintr�gen wird erstellt
        JList themenAuswahl = new JList(listenModell);
        for(int i=0; i<interessen.length; i++){
        	listenModell.addElement(interessen[i]);
        }
 
        //JList wird Panel hinzugef�gt
        panel.add(themenAuswahl);
 
        //Eintrag "Programmieren" wird an Index 4 eingef�gt
        listenModell.add(4, "Programmieren");
 
        //erster Eintrag "Politik" wird entfernt
        listenModell.removeElementAt(0);
 
        //String "Mode" wird entfernt        
        listenModell.removeElement("Mode");
 
        meinJFrame.add(panel);
        meinJFrame.setVisible(true);
 
    }
}

//  https://www.java-tutorial.org/listmodel.html