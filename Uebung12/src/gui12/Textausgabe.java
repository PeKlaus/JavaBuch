package gui12;

/*
 * Klasse Textausgabe
 * Die Klasse implementiert das Interface Serializable.
 * Sie speichert Textzeilen mit Position und Farbe.
 */

import java.awt.Color;
import java.io.Serializable;

public class Textausgabe implements Serializable {
    private int x, y;
    private String text;
    private Color farbe;

    Textausgabe(int posx, int posy, String t, Color f) {
	x = posx;
	y = posy;
	text = t;
	farbe = f;
    }

    public int getX() {
	return x;
    }

    public int getY() {
	return y;
    }

    public String getText() {
	return text;
    }

    public Color getColor() {
	return farbe;
    }
}