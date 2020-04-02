package gui12;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;

/*
 * Klasse JMyPaintPanel
 * Die Klasse ist von der Standardkomponente JPanel abgeleitet.
 * Sie dient der Demonstration des Zeichnens in eine Komponente.
 */


import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class JMyPaintPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
 // übergibt der liste nur figuren aus der Klasse <Zeichenobjekt> und der geerbten klassen aus Zeichenobjekt
	private List<Zeichenobjekt> figuren; 
	
 // Erzeugen der >>ArrayList<< -Objekts im Standardkonstruktor 
	public JMyPaintPanel() {
		super();
		figuren = new ArrayList<>();
	}
 /*	
	public JMyPaintPanel(LayoutManager arg0) {
		super(arg0);
		figuren = new ArrayList<Zeichenobjekt>();
	    }
	
	public JMyPaintPanel(boolean arg0) {
		super(arg0);
		figuren = new ArrayList<Zeichenobjekt>();
	    }
	
	public JMyPaintPanel(LayoutManager arg0, boolean arg1) {
		super(arg0, arg1);
		figuren = new ArrayList<Zeichenobjekt>();
	    }
  */
 // Übergabemethode als Schnittstelle zwischen Zeichenprogramm und -fläche
	public void addZeichenobjekt(Zeichenobjekt obj) {
		figuren.add(obj);
	}
	
 // Überschriebene >>paintComponent<< -Methode	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);                              // Aufruf der geerbten PaintComponente (Graphics g)
		Graphics2D g2d = (Graphics2D) g;                      // Kontext zu Graphics2D g2d herstellen = (Graphics2D) g;
		
		for (Zeichenobjekt zo : figuren) {                    // die for Schleife arbeitet die gezeichneten figuren aus der List
		    g2d.setColor(zo.getColor());     // Farbe         // ab und Trägt sie in das ZeichenPanel (zo) ein
		    BasicStroke stil = new BasicStroke(zo.getLinienbreite(), // Linienbreite
			    BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
		    g2d.setStroke(stil);
		    zo.paint(g2d);  // Zeichnen
		}
	    }

}
