
public class Zeichensatz {

    public static void main(String[] args) {
	int zahl = 30;
	String zeichensatz = "";
	
	while (zahl < 128) {
	    zeichensatz = zeichensatz + (char) zahl;
	    zahl++;
	}
	System.out.println(zeichensatz);
    }

}
