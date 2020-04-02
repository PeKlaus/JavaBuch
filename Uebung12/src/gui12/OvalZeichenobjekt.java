package gui12;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
/*
 * Klasse zum Zeichnen eines Ovals
 */
public class OvalZeichenobjekt extends Zeichenobjekt {
	// Variable istGefuellt als boolean -Wert erzeugen
	private boolean istGefuellt;
	/*
	 * Konstruktor aus der Klasse Zeichenobjekt übernommen
	 */	
    OvalZeichenobjekt(int x1, int y1, int x2, int y2, Color color,
    	    float linienbreite, boolean istGefuellt) {
    	super(x1, y1, x2, y2, color, linienbreite);
    	this.istGefuellt = istGefuellt;
        }
    /*
	 * abfragen ob die zu zeichnende Figur Gefüllt sein sollte
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
    	Graphics2D g2d = (Graphics2D) g;
    	Ellipse2D.Float oval = new Ellipse2D.Float(getX1(), getY1(), getX2(),
    		getY2());
    	if (getGefuellt()) {
    	    g2d.fill(oval);
    	} else {
    	    g2d.draw(oval);
    	}
        }

    }
