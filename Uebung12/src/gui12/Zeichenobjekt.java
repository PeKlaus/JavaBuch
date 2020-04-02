package gui12;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

/*
 * Eine abstrakte Klasse bezeichnet in der objektorientierten Programmierung eine spezielle Klasse,
 * welche sich per Definition nicht instanziieren lässt und die somit lediglich als Strukturelement
 * innerhalb einer Klassenhierarchie dient.
 */

public abstract class Zeichenobjekt {   
	
	protected int x1, y1, x2, y2;     // Koordinaten
	protected Color color;            // Farbe
	protected float linienbreite;     // Linienbreite

	/*
	 * Konstruktoren sowie Getter- und Setter-Methoden und die abstrakte
	 * >>paint<< Methode der Klasse >>Zeichenobjekt<<
	 */	
	Zeichenobjekt(int x1, int y1, int x2, int y2, Color color, float linienbreite) {
		
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.color = color;
		this.linienbreite = linienbreite;
	}
	/*
	 * Getter und Setter Methoden
	 */
	public int getX1() {return x1;}
	public void setX1(int x) {this.x1 = x1;}	
	public int getY1() {return y1;}
	public void setY1(int y){this.y1 = y1;}	
	public int getX2() {return x2;}
	public void setX2(int x){this.x2 = x2;}	
	public int getY2() {return y2;}
	public void setY2(int x){this.x1 = x1;}	
	public Color getColor() {return color;}
	public void setColor(Color c){this.color = color;}	
	public float getLinienbreite() {return linienbreite;}
	public void setLinienbreite(float lb) {this.linienbreite = linienbreite;}
	
	abstract void paint(Graphics g);  //abstracte paint Methode paint(Graphics g)
	
}
