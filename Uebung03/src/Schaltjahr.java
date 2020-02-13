/*Schaltjahr Berechnung
 * @Klaus Peringer
 */

import javax.swing.JOptionPane;

public class Schaltjahr {
	public static void main(String[] args) {
		int jahr;
		jahr = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie das gewünschte Jahr ein:"));
		if ((jahr % 400)==0) {
			JOptionPane.showMessageDialog(null,"Das Jahr " +jahr+ " ist ein Schaltjahr");
		} else {
			if ((jahr % 100)==0) {
				JOptionPane.showMessageDialog(null,"Das Jahr " +jahr+ " ist kein Schaltjahr");
			} else {
				if ((jahr % 4)==0) {
					JOptionPane.showMessageDialog(null, "Das Jahr " +jahr+ " ist ein Schaltjahr");
				} else {
					JOptionPane.showMessageDialog(null, "Das Jahr " +jahr+ " ist kein Schaltjahr");
					
				}
			}
		}
			
		}
}


