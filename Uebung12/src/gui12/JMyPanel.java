package gui12;

/*
 *  Eigene Panel-Komponente
 */

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JMyPanel extends JPanel {

	/*
	 * Überschriebene >>paintComponente<< - Methode
	 */
	
	public void paintComponent(Graphics g) {                  // ruft die paintComponente der Superklasse auf (Graphics=(zum Zeichnen2))
		super.paintComponent(g);                              // 
		//g.setColor(Color.red);                                // Zeichenfarbe auf rot 
		//g.drawLine(0, 0, this.getWidth(), this.getHeight());  // Zeichnet eine Linie von oben Links nach unten Rechts
	}
}
