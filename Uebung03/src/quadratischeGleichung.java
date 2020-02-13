import javax.swing.JOptionPane;

public class quadratischeGleichung {

	public static void main(String[] args) {
		int a,b,c;
		int D;
		a = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie Wert [a] ein:"));
		b = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie Wert [b] ein:"));
		c = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie Wert [c] ein:"));
		D = b*b-4*a*c;
		if (D==0) {
			JOptionPane.showMessageDialog(null,"D=0: eine Lösung!");
		}else {
			if (D>0) {
				JOptionPane.showMessageDialog(null, "D>0: zwei Lösungen!");
			}else {
				JOptionPane.showMessageDialog(null,  "D<0: keine Lösung!");
			}
			
		}
		

	}

}
