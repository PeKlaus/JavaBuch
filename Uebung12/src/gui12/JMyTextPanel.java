package gui12;

/*
 * Klasse JMyTextPanel
 * Die Klasse ist von der Standardkomponente JPanel abgeleitet.
 * Die von ihm dargestellten Textzeilen werden in einem Vector
 * gespeichert. Der Vector speichert die Textzeilen als Objekte
 * der Klasse Textausgabe.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JPanel;

public class JMyTextPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private ArrayList<Textausgabe> texte;

    public JMyTextPanel() {
	super();
	texte = new ArrayList<Textausgabe>();
    }

    public JMyTextPanel(LayoutManager arg0) {
	super(arg0);
	texte = new ArrayList<Textausgabe>();
    }

    public JMyTextPanel(boolean arg0) {
	super(arg0);
	texte = new ArrayList<Textausgabe>();
    }

    public JMyTextPanel(LayoutManager arg0, boolean arg1) {
	super(arg0, arg1);
	texte = new ArrayList<Textausgabe>();
    }

    public void addTextausgabe(int xpos, int ypos, String t, Color f) {
	texte.add(new Textausgabe(xpos, ypos, t, f));
    }

    public void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
	for (int i = 0; i < texte.size(); i++) {
	    Textausgabe ta = texte.get(i);
	    g2d.setColor(ta.getColor());
	    g2d.drawString(ta.getText(), ta.getX(), ta.getY());
	}
    }

    public ArrayList<Textausgabe> getArrayList() {
	return texte;
    }

    public void setArrayList(ArrayList<Textausgabe> al) {
	texte = al;
    }
}