package uebung07;

public class StringBuildertest {

    public static void main(String[] args) {
	
	StringBuilder puffer = new StringBuilder();
	System.out.println("Puffergröße: " + puffer.capacity());
	System.out.println("Länge des Pufferinhalts: " + puffer.length());
	System.out.println(puffer);
	puffer.append("Drei Chinesen");
	System.out.println("Puffergröße: " + puffer.capacity());
	System.out.println("Länge des Pufferinhalts: " + puffer.length());
	System.out.println(puffer);
	puffer.setCharAt(2, 'i');
	puffer.setCharAt(9, 'i');
	puffer.setCharAt(11, 'i');
	System.out.println(puffer);
	puffer.delete(0, puffer.length());
	System.out.println(puffer);
	System.out.println("Puffergröße: " + puffer.capacity());
	System.out.println("Länge des Pufferinhalts: " + puffer.length());
	puffer.append("Drei Chinesen");
	puffer.append("mit dem Kontrabass");
	System.out.println(puffer);
	System.out.println("Puffergröße: " + puffer.capacity());
	System.out.println("Länge des Pufferinhalts: " + puffer.length());

	@SuppressWarnings("deprecation")
	Integer i=new Integer("13");
	System.out.println(i);
	int c = i + 5;
	System.out.println(c);
	

    }

}

