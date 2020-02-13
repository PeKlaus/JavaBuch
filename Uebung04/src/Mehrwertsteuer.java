import javax.swing.JOptionPane;

public class Mehrwertsteuer {
    public static void main(String [] args) {
	double betrag;
	double mwstsatz = 19;
	double mwst;
	
	betrag = Integer.parseInt(JOptionPane.showInputDialog("Geben Sie den Rechnungsbetrag in € ein: "));
	System.out.println("Betrag: " +betrag);
	System.out.println("Schritt1: " +mwstsatz/100);
	System.out.println("Schritt2: " +mwstsatz/100*betrag);
	mwst = mwstsatz / 100 * betrag;
	System.out.println("Mehrwertsteuer: " + mwst + " €");
	
    }

}
