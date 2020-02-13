package uebung07;

import javax.swing.JOptionPane;

public class Vokalloescher {

    public static void main(String[] args) {
	
	String e = JOptionPane.showInputDialog("Geben Sie einen Text ein: ");
	StringBuilder eohneV = new StringBuilder("");
	for (int i = 0; i < e.length(); i++) {
	    if ((e.charAt(i) != 'a') && (e.charAt(i) != 'e')
		    && (e.charAt(i) != 'i') && (e.charAt(i) != 'o')
		    && (e.charAt(i) != 'u') && (e.charAt(i) != 'A')
		    && (e.charAt(i) != 'E') && (e.charAt(i) != 'I')
		    && (e.charAt(i) != 'O') && (e.charAt(i) != 'U')) {
		eohneV.append(e.charAt(i));
	    }
	}
	JOptionPane.showMessageDialog(null, eohneV);
	

    }

}
