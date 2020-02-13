package uebung07;

import javax.swing.JOptionPane;

public class Zahlensystem {

    public static void main(String[] args) {
	
	String eingabe = JOptionPane
		.showInputDialog("Geben Sie eine ganze Zahl ein: ");
	Integer z = Integer.parseInt(eingabe);
	JOptionPane.showMessageDialog(null, "Dezimal: " + z + "\n"
	+ "Dual: "+ Integer.toBinaryString(z) + "\n" 
		+ "Hexadezimal: "+ Integer.toHexString(z).toUpperCase());
    }

}
