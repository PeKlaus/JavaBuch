package uebung05;

/*
 * Programm Rechtecktest zum Testen der Klasse Rechteck
 * @author Hans-Peter Habelitz
 * @date 2011-12-21
 */

import javax.swing.JOptionPane;

public class Rechtecktest {
    public static void main(String[] args) {
	String eingabe, einheit;
	double l, b;
	eingabe = JOptionPane
		.showInputDialog("Geben Sie die Rechteckl‰nge ein:");
	l = Double.parseDouble(eingabe);
	eingabe = JOptionPane
		.showInputDialog("Geben Sie die Rechteckbreite ein:");
	b = Double.parseDouble(eingabe);
	einheit = JOptionPane.showInputDialog("Geben Sie die Maﬂeinheit ein:");
	Rechteck r = new Rechteck(l, b);
	System.out.println("Lange Seite: " + r.getLangeSeite() + " " + einheit);
	System.out.println("Kurze Seite: " + r.getKurzeSeite() + " " + einheit);
	System.out.println("Diagonale: " + r.getDiagonale() + " " + einheit);
	System.out.println("Umfang: " + r.getUmfang() + " " + einheit);
	System.out.println("Fl‰che: " + r.getFlaeche() + " " + einheit
		+ '\u00b2');
	r.laengeAusgeben();
    }

}
