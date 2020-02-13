package uebung05;

/*
 * Programm Kreistabelle
 * @author Hans-Peter Habelitz
 * @date 2011-12-21
 */

import javax.swing.JOptionPane;

public class Kreistabelle {
    public static void main(String[] args) {
	String kreisradius, erhoehung;
	double r, dr;
	kreisradius = JOptionPane
		.showInputDialog("Geben Sie einen Kreisradius ein:");
	erhoehung = JOptionPane
		.showInputDialog("Geben Sie die Erhöhung ein:");
	r = Double.parseDouble(kreisradius);
	Kreis k = new Kreis(r);
	dr = Double.parseDouble(erhoehung);
	System.out.println("Radius\t\tUmfang\t\t\t\tFläche");
	for (int i = 0; i < 30; i++) {
	    k.setRadius(r + i * dr);
	    System.out.println(k.getRadius() + "\t\t" + k.getUmfang() + "\t\t"
		    + k.getFlaeche());
	}
    }
}
