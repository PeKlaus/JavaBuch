package gui11;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JComponent;

public class ImageComponent extends JComponent {
	public ImageComponent() {
	}
	private BufferedImage image;
	
	
	public void setImage(BufferedImage img) {
		this.image = img;
		setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
		invalidate();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if (image != null) {
			g.drawImage(image, 0, 0, this);
		}
	}
	
}
