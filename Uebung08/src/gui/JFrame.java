package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class JFrame extends javax.swing.JFrame {
	private JPanel contentPane;
	private JTextField textField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    JFrame frame = new JFrame();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public JFrame() {
    	setTitle("Hallo");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Fenster Schließen
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	System.out.println(getTitle());
	setSize(450, 300);                     // Größe des Fensters/Componente
	System.out.println(getSize());
	setLocation(200, 200);                 // Position Fenster/Fomponente am Bildschirm  
	System.out.println(getLocation());
	System.out.println(getInsets());
	setResizable(true);                    //Fenster/Componente vergrößern ja/nein
	System.out.println(isResizable());
	setVisible(true);                      //Fenster/Componente sichtbar ja/nein
	System.out.println(isVisible());
	dispose();                             //Löscht das Fenster/Componente
	setCursor(DEFAULT_CURSOR);             // Aussehen des Cursors verendern (Crosshair/Default/Hand/Move/Text/Wait
	System.out.println(contentPane);
	contentPane.setLayout(null);
	
	JButton btnNewButton = new JButton("New button");
	btnNewButton.setBounds(172, 130, 89, 23);
	contentPane.add(btnNewButton);
	
    }
}
