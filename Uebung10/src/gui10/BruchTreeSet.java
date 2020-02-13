package gui10;

import java.util.Iterator;
import java.util.TreeSet;
import java.util.HashSet;

public class BruchTreeSet {

    public static void main(String[] args) {
	
	Bruch bruch1 = new Bruch(1, 2);
	Bruch bruch2 = new Bruch(1, 4);
	Bruch bruch3 = new Bruch(1, 8);
	TreeSet<Bruch> bruchSet = new TreeSet<Bruch>();
	bruchSet.add(bruch1);
	bruchSet.add(bruch2);
	bruchSet.add(bruch2); /* wird nicht nochmals hinzugefügt, da das identische 
	                        Objekt Bestandteil des TreeSet ist */
	bruchSet.add(bruch3);
	
	// Iterator wird angefordert
	Iterator<Bruch> it = bruchSet.iterator();
	// HashSet wird angefordert
	while (it.hasNext()) {
	    // Next gibt das aktuelle HashSet-Objekt zurück
	    // und geht zum nächsten über
	    Bruch b = it.next();
	    // Ausgabe des jeweiligen HashSet-Elements
	    System.out.println(b.bruchToString());
	}
	

    }

}
