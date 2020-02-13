import javax.swing.JOptionPane;

public class Zahlentest {
	public static void main(String[] args) {
		double zahl;
		zahl = Double.parseDouble(JOptionPane.showInputDialog("Bitte geben sie eine Zahl ein"));
		if (zahl<0) {
			JOptionPane.showMessageDialog(null, "Die Zahl ist negativ!");
		}else {
			JOptionPane.showMessageDialog(null, "Die Zahl ist positiv!");
			
		}
	

	}

}
