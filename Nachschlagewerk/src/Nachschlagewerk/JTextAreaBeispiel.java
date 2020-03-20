package Nachschlagewerk;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
 
public class JTextAreaBeispiel {
    public static void main(String[] args) {
        JFrame meinJFrame = new JFrame();
        meinJFrame.setTitle("JTextArea Beispiel");
        meinJFrame.setSize(300, 150);
        JPanel panel = new JPanel();
 
        //5-zeiliges und 20-spaltiges Textfeld wird erzeugt
        JTextArea textfeld = new JTextArea(5, 20);
 
        //Text für das Textfeld wird gesetzt
        textfeld.setText("Lorem ipsum dolor sit amet, " +
        		"consetetur sadipscing elitr, sed diam nonumy " +
        		"eirmod tempor invidunt ut labore et " +
        		"dolore magna aliquyam erat, sed diam voluptua. " +
        		"At vero eos et accusam et justo duo dolores et " +
                        "ea rebum.");
        //Zeilenumbruch wird eingeschaltet
        textfeld.setLineWrap(true);
 
        //Zeilenumbrüche erfolgen nur nach ganzen Wörtern
        textfeld.setWrapStyleWord(true);
 
        //Ein JScrollPane, der das Textfeld beinhaltet, wird erzeugt
        JScrollPane scrollpane = new JScrollPane(textfeld);       
 
        //Scrollpane wird unserem Panel hinzugefügt
        panel.add(scrollpane);
 
        meinJFrame.add(panel);
        meinJFrame.setVisible(true);
 
    }
}

// https://www.java-tutorial.org/jtextarea.html