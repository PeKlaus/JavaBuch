package gui10;

import java.util.HashMap;

public class HashMapTest {

    public static void main(String[] args) {
	HashMap<Integer, String> map = new HashMap<Integer, String>();
	
	// Einf�gen der Objekte in die HashMap
	
	map.put(1, "Hamburg");
	map.put(2, "Berlin");
	map.put(18, "M�nchen");
	
	// Berlin wird durch K�ln ersetzt, da die 
	// 2 schon als schl�ssel vergeben ist
	//map.put(2, "K�ln");
	System.out.println(map.values());
    }

}
