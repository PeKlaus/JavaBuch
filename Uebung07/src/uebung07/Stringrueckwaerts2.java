package uebung07;

import javax.swing.JOptionPane;

public class Stringrueckwaerts2 {
    
    public static void main(String[] args) {
  	String eingabe = JOptionPane.showInputDialog("Geben Sie einen Text ein: ");
  	String eingabe2 = "";
  	for (int i = eingabe.length() - 1; i >= 0; i--) {
  	    eingabe2 = eingabe2 + eingabe.charAt(i);
   	}
  	JOptionPane.showMessageDialog(null, eingabe2);
      }
  }

    
    

    

  


