package uebung05;

/*
 * Programm Kreis zum Testen der Klasse Kreis
 * @author Hans-Peter Habelitz
 * @date 2011-12-21
 */

import javax.swing.JOptionPane;

public class Kreistest {
    public static void main(String[] args) {
	String kreisradius, einheit;
	double r;
	kreisradius = JOptionPane
		.showInputDialog("Geben Sie einen Kreisradius ein:");
	einheit = JOptionPane.showInputDialog("Geben Sie die Maﬂeinheit ein:");
	r = Double.parseDouble(kreisradius);
	Kreis k = new Kreis(r);
	System.out.println("Kreisradius: " + k.getRadius() + " " + einheit);
	System.out.println("Umfang: " + k.getUmfang() + " " + einheit);
	System.out.println("Fl‰che: " + k.getFlaeche() + " " + einheit
		+ '\u00b2');
    }

}
