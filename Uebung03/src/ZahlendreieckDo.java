/*
 * @ Klaus Peringer 
 */
public class ZahlendreieckDo {

	public static void main(String[] args) {
		int zahl = 0;
		String ausgabe = "";
		do {
			ausgabe = ausgabe + zahl;
			System.out.println(ausgabe);
			zahl++;
		}while (zahl < 10);
		}
	}


