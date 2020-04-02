package gui12;

import java.awt.Color;

/*
 * Klasse JMyButton
 * Die Klasse ist von der Standardkomponente JButton abgeleitet.
 * Sie besitzt als Erweiterung eine grüne Linie als zusätzlichen
 * Rahmen.
 */

import java.awt.Graphics;

import javax.swing.JButton;

public class JMyButton extends JButton {

	public JMyButton(String string) {
		// TODO Auto-generated constructor stub
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.green);
		g.drawRect(3, 3, this.getWidth()-6, this.getHeight()-6);
	}
}
