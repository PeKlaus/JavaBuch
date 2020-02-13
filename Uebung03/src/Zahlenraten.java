
import javax.swing.JOptionPane;

public class Zahlenraten {
	public static void main(String[] args) {
		//int zahl = 6;
		int eingabe = Integer.parseInt(JOptionPane.showInputDialog(" Geben Sie eine Zahl zwischen 0 - 10 ein:"));
		switch (eingabe) {
		case 6:
			JOptionPane.showMessageDialog(null,"Treffer!!");
			break;
		case 4:
		case 5:
		case 7:
		case 8:
			JOptionPane.showMessageDialog(null,"Knapp Daneben !!");
			break;
			default:
				JOptionPane.showMessageDialog(null,"Daneben!!");
		}

		

	}

}
