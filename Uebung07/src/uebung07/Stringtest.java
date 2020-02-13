package uebung07;

public class Stringtest {

    public static void main(String[] args) {
	String a = "Das ist ";
	String b = "eine Zeichenkette!";
	a = a.concat(b); // String a mit String b verbunden (Konkatenation)
	System.out.println(a);
	System.out.println(a.length()); // L‰nge eines Strings ausgeben (mit leerzeichen)
	if (a.equals(b)) {     // String vergleichen      
	    System.out.println("Gleich");
	} else {
	    System.out.println("ungleich");
	}
	System.out.println(a.compareTo(b)); // lexikalischer Vergleich
	System.out.println(a.charAt(1));// Zeichen an einer bestimmten Position ermitteln (beginnend mit 0)
	System.out.println(a.toUpperCase()); // wandelt alles in groﬂ-schreibung um
	System.out.println(a.toLowerCase()); // wandelt alles in klein-schreibung um
	String s = String.valueOf(34.5); // Zahlen und Strings ineinander umwandeln
	System.out.println(s);
	
    }

}
