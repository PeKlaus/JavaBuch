package uebung07;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import javax.swing.JOptionPane;

public class Wrappertest {

    public static void main(String[] args) {
	String eingabe;
	eingabe = JOptionPane.showInputDialog("Geben Sie eine ganze Zahl ein: ");
	@SuppressWarnings("deprecation")
	Integer i = new Integer(eingabe);
	System.out.println("Eingegebene Zahl: " + i);
	System.out.println("als Dualzahl: " + Integer.toBinaryString(i));
	System.out.println("als Oktalzahl: " + Integer.toOctalString(i));
	System.out.println("als Hexzahl: " + Integer.toHexString(i));
	System.out.println("Obergrenze von int: " + Integer.MAX_VALUE);
	System.out.println("Untergrenze von int: " + Integer.MIN_VALUE);
	System.out.println("");
	eingabe = JOptionPane.showInputDialog("Geben Sie eine Kommazahl ein: ");
	double d = Double.parseDouble(eingabe);
	System.out.println( i + "/" + d + "=" + (i/d));
	System.out.println( i.intValue() + "/" + d + "=" + (i.intValue() / d)); // unnötig kompliziert
	@SuppressWarnings("deprecation")
	Double wd = new Double(0.0);
	System.out.println( d + "/" + wd + "=" + d / wd);
	Double wd2 = 2.5;  // Ausnutzung von Autoboxing
	System.out.println( -wd2 + "/" + 0 + "=" + -wd2 / 0);
	System.out.println(0.0 + "/" + 0.0 + "=" + 0.0 / 0.0);
	
	System.out.println("Epoch: " + Instant.EPOCH);
	System.out.println("Min: " + Instant.MIN);
	
	Instant zeitpunkt = Instant.now();
	System.out.println(zeitpunkt);
	Instant zeitpunkt1 = Instant.now();
	Instant zeitpunkt2 = zeitpunkt1.plus(1, ChronoUnit.HOURS);
	System.out.println(zeitpunkt2);
	
	System.out.println("Start");
	Duration dauer = Duration.of(10, ChronoUnit.MINUTES);
	System.out.println(dauer + "Ende");

    }

}
