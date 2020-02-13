package uebung07;

import javax.swing.JOptionPane;

public class Hexumrechner {

    public static void main(String[] args) {
	String e = JOptionPane.showInputDialog("Geben Sie eine Hexdezimalzahl ein");
	JOptionPane.showMessageDialog(null, "Hexadezimalzahl: " + e + "\n"
		+ "Dezimalzahl: " + Long.valueOf(e, 16) + "\n" 
		+ "Dualzahl: "+ Long.toBinaryString(Long.valueOf(e, 16)));

    }

}
