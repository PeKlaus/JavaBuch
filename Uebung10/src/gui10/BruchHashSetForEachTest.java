package gui10;

import java.util.HashSet;
import java.util.function.Consumer;

public class BruchHashSetForEachTest {

    public static void main(String[] args) {
	Bruch bruch1 = new Bruch(1, 2);
	Bruch bruch2 = new Bruch(3, 4);
	Bruch bruch3 = new Bruch(3, 4);
	HashSet<Bruch> bruchSet = new HashSet<Bruch>();
	bruchSet.add(bruch1);
	bruchSet.add(bruch2);
	bruchSet.add(bruch3);
	
	if (bruch2.equals(bruch3)) {
	    System.out.println("True");
	} else {
	    System.out.println("false");
	}
	System.out.println(bruchSet.size());
	
	// Schreibweise ohne Methode
//	bruchSet.forEach((Bruch element) ->
//	System.out.println(element.bruchToString()));
	
	// Schreibweise ohne Methode noch schöner!!
//	bruchSet.forEach(element -> System.out.println(element.bruchToString()));
	
	// Lange Schreibweise mit Methode
	bruchSet.forEach(new Consumer<Bruch>() { // Consumer für den Typ Bruch wird erstellt	    	    
	 /* die Methode accept definiert, welche Operationen für jedes Element
	  * der Collection bruchSet ausgeführt werden */
	public void accept(Bruch element) {
	     System.out.println(element.bruchToString());
	}
	});
    
    }
}

