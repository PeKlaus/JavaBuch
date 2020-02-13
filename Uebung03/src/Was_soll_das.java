/*
/ * @Klaus Peringer

import javax.swing.JOptionPane;

public class Was_soll_das {
	public static void main(String[] args) {
		int m,n;
		m = Integer.parseInt(JOptionPane.showInputDialog("Bitte Geben Sie den Wert für [m] ein:"));
		n = Integer.parseInt(JOptionPane.showInputDialog("Bitte geben Sie den Wert für [n] ein:"));
		while (m != n) {
			if (m>n) {
				m=m-n;
				} else {
				n=n-m;}
			}
		JOptionPane.showMessageDialog(null, "[m] = : " +m);	
		}
		

	}



*/
import javax.swing.JOptionPane;

// Programm WasSollDas
// Sie sollten mit unterschiedlichen ganzen Zahlen testen,
// wozu der Algorithmus dient. Geben Sie z.B. für m den Wert 12
// und für n den Wert 81 ein.
// @author Hans-Peter Habelitz
// @date 2011-12-11
 

public class Was_soll_das {

    public static void main(String[] args) {
	int m, n;
	String eingabe;

	eingabe = JOptionPane
		.showInputDialog("Geben Sie eine ganze Zahl für m ein: ");
	m = Integer.parseInt(eingabe);
	eingabe = JOptionPane
		.showInputDialog("Geben Sie eine ganze Zahl für n ein: ");
	n = Integer.parseInt(eingabe);

	while (m != n) {
	    if (m > n) {
		m = m - n;
	    } else {
		n = n - m;
	    }
	}
	System.out.println("m = " + m);
    }

}

