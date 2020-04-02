package gui12;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
/*
 * Klasse zum Zeichnen einer Linie
 */
public class LinieZeichenobjekt extends Zeichenobjekt { 
    /*
    * Konstruktor aus der Klasse Zeichenobjekt übernommen
    */
	LinieZeichenobjekt(int x1, int y1, int x2, int y2, Color color, float linienbreite) {
		super(x1, y1, x2, y2, color, linienbreite);
		// TODO Auto-generated constructor stub
	}
   /*
	* Die paint-Methode aus Zeichenobjekt anpasssen auf die zu zeichnende Figur
    */	
@Override
	void paint(Graphics g) {    
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D) g;
		Line2D.Float linie = new Line2D.Float(getX1(), getY1(), getX2(), getY2());
		g2d.draw(linie);
	}
}
