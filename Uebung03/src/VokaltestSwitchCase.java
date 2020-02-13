/*Vokaltest mit Switch Case
 * 
 *@Klaus Peringer
 *
 */
import javax.swing.JOptionPane;

public class VokaltestSwitchCase {
	public static void main(String[] args) {
		String eingabe;
		char c;
		eingabe = JOptionPane.showInputDialog("Geben Sie einen Buchstaben ein: ");
		c = eingabe.charAt(0);
		switch (c) {// Bedingung
		// Fall
		case 'a': //kein break;
		case 'e': //kein break;
		case 'i': //kein break;
		case 'o': //kein break;
		case 'u':
			//Anweisung
			JOptionPane.showMessageDialog(null, "[" +c+ "] ist ein Vokal");
			break;//Ende
			// Alternatives Ende
			default:
				JOptionPane.showMessageDialog(null,"[" +c+ "] ist kein Vokal");
			
		}
		

	}

}
