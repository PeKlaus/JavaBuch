/* LoesungenQuadratischeGleichung ax^2 + bx +c = 0
 * Nach der Eingabe der drei Koeffizienten a, b und c
 * wird bestimmt wie viele Lösungen die Gleichung hat.
 * Das Ergebnis wird in einem MessageDialog ausgegeben.
 * @author Hans-Peter Habelitz
 * @date 2011-12-11
 */

import javax.swing.JOptionPane;

public class LoesungQuadratischeGleichung  {

    public static void main(String[] args) {
	double a, b, c, d;
	a = Double.parseDouble(JOptionPane.showInputDialog("ax" + '\u00b2'
		+ " + bx + c; Geben Sie den Koeffizienten a ein:"));
	b = Double.parseDouble(JOptionPane.showInputDialog("ax" + '\u00b2'
		+ " + bx + c; Geben Sie den Koeffizienten b ein:"));
	c = Double.parseDouble(JOptionPane.showInputDialog("ax" + '\u00b2'
		+ " + bx + c; Geben Sie den Koeffizienten c ein:"));
	d = b * b - 4 * a * c;
	if (d < 0) {
	    JOptionPane.showMessageDialog(null,
		    "Die Gleichung hat keine Lösung!");
	} else {
	    if (d > 0) {
		JOptionPane.showMessageDialog(null,
			"Die Gleichung hat zwei Lösungen!");
	    } else {
		JOptionPane.showMessageDialog(null,
			"Die Gleichung hat eine Lösung!");
	    }
	}
    }

}



