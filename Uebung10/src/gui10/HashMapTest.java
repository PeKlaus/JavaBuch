package gui10;

import java.util.HashMap;

public class HashMapTest {

    public static void main(String[] args) {
	HashMap<Integer, String> map = new HashMap<Integer, String>();
	
	// Einfügen der Objekte in die HashMap
	
	map.put(1, "Hamburg");
	map.put(2, "Berlin");
	map.put(18, "München");
	
	// Berlin wird durch Köln ersetzt, da die 
	// 2 schon als schlüssel vergeben ist
	//map.put(2, "Köln");
	System.out.println(map.values());
    }

}
