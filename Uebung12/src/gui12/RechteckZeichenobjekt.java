package gui12;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
/*
 * Klasse zum Zeichnen eines Rechtecks
 */
public class RechteckZeichenobjekt extends Zeichenobjekt {
	// Variable istGefuellt als boolean -Wert erzeugen
	private boolean istGefuellt;
	 /*
	* Konstruktor aus der Klasse Zeichenobjekt �bernommen
	*/
	RechteckZeichenobjekt(int x1, int y1, int x2, int y2, Color color, float linienbreite, boolean istGefuellt) {
		super(x1, y1, x2, y2, color, linienbreite);
		// TODO Auto-generated constructor stub
		this.istGefuellt = istGefuellt;
	}
	
	/*
	 * abfragen ob die zu zeichnende Figur Gef�llt sein sollte
	 */
	public boolean getGefuellt() {
		return istGefuellt;
	}
	public void setGefuellt(boolean istGefuellt) {
		this.istGefuellt = istGefuellt;
	}
	
	/*
	 * Die paint-Methode aus Zeichenobjekt anpasssen auf die zu zeichnende Figur
	 */		
	@Override
	void paint(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D)g;
		Rectangle2D.Float rechteck =
				new Rectangle2D.Float(getX1(), getY1(), getX2(), getY2());
		if (getGefuellt()) {
			g2d.fill(rechteck);
		} else {
			g2d.draw(rechteck);
		}		
	}
}
