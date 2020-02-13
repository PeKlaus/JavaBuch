package uebung07;

import java.time.Duration;
import java.time.Instant;
import javax.swing.JOptionPane;

public class Eingabedauer {

    public static void main(String[] args) {
	
	Instant startEingaAufforderung = Instant.now();
	JOptionPane.showInputDialog("Geben Sie ihren Namen ein");
	Instant endeDerEingabe = Instant.now();
	Duration dauer = Duration.between(startEingaAufforderung, endeDerEingabe);
	
	System.out.println("Dauer nach ISO-8601: " +dauer);
	System.out.println("Dauer in Minuten: " + dauer.toMinutes() +"," +dauer.getSeconds()); 
	System.out.println("Dauer in Sekunden: " +dauer.getSeconds() + "," +dauer.getNano());
	System.out.println("Dauer in Millisekunden: " +dauer.toMillis());

    }

}
