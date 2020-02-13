package uebung07;

import javax.swing.JOptionPane;
import java.time.Duration;
import java.time.Instant;

public class Eingabetest {

    public static void main(String[] args) {
	
	String vorgabe = "Fischers Fritz fischt frische Fische";
	String rueckmeldung;
	long minuten, sekunden, millis;
	Instant startEingabeAufforderung = Instant.now();
	String eingabe = JOptionPane
		.showInputDialog("Geben Sie folgenden Satz ein: " + vorgabe);
	Instant endeDerEingabe = Instant.now();
	Duration dauer = Duration.between(startEingabeAufforderung,
		endeDerEingabe);
	minuten = dauer.toMinutes();
	sekunden = dauer.getSeconds() - minuten * 60;
	millis = dauer.getNano() / 1000000;
	if (eingabe.equals(vorgabe)) {
	    rueckmeldung = "Fehlerfrei! Zeit: " + minuten + " Minuten "
		    + sekunden + " Sekunden " + millis + " Millisekunden";
	} else {
	    rueckmeldung = "Falscheingabe! Zeit: " + minuten + " Minuten "
		    + sekunden + " Sekunden " + millis + " Millisekunden";
	}
	System.out.println(rueckmeldung);
	System.out.println("Dauer: " + dauer);
	JOptionPane.showMessageDialog(null, rueckmeldung + "Dauer: " + dauer);

    }

}
