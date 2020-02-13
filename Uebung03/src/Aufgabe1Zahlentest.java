/* Programm zum testen ob eine Zahl negativ oder positiv ist
 * 
 */
import javax.swing.JOptionPane;

public class Aufgabe1Zahlentest {
	public static void main(String[] args) {
		double zahl;
		zahl = Double.parseDouble(JOptionPane.showInputDialog("Geben Sie eine Kommazahl mit Vorzeichen ein"));
		if (zahl < 0) {
		    JOptionPane.showMessageDialog(null, "Die Zahl ist negativ!");
		} else {
		    JOptionPane.showMessageDialog(null, "Die Zahl ist positiv!");
		}
		
		 	}

}
