package Nachschlagewerk;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DateiAuswahlFenster extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DateiAuswahlFenster frame = new DateiAuswahlFenster();
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
	public DateiAuswahlFenster() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//             ÖFFNEN
		
		JButton btnOeffnen = new JButton("\u00F6ffnen");
		btnOeffnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JFileChooser-Objekt erstellen
		        JFileChooser chooser = new JFileChooser();
		        // Dialog zum Speichern von Dateien anzeigen
		        chooser.showOpenDialog(null);
				
			}
		});
		btnOeffnen.setBounds(10, 32, 89, 23);
		contentPane.add(btnOeffnen);
		
		
		
		//            SPEICHERN
		
		JButton btnSpeichern = new JButton("speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JFileChooser-Objekt erstellen
		        JFileChooser chooser = new JFileChooser();
		        // Dialog zum Speichern von Dateien anzeigen
		        chooser.showSaveDialog(null);
			}
		});
		btnSpeichern.setBounds(131, 32, 89, 23);
		contentPane.add(btnSpeichern);
	}

}

// https://www.java-tutorial.org/jfilechooser.html
