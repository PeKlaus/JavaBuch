package gui11;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Verschluesselung1 extends JFrame {

	private JPanel contentPane;
	private String dateiname = "." + File.separator + "verschluesselt1.txt";
	private JTextPane tpEingabe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Verschluesselung1 frame = new Verschluesselung1();
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
	public Verschluesselung1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEingabe = new JLabel("Eingabe");
		lblEingabe.setBounds(10, 11, 48, 14);
		contentPane.add(lblEingabe);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (VerschluesseltWriter out = new VerschluesseltWriter(new FileWriter(dateiname))) {
					out.write(tpEingabe.getText());		
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Fehler beim Speichern.");
				}
			}
		});
		btnSpeichern.setBounds(10, 188, 113, 23);
		contentPane.add(btnSpeichern);
		
		JButton btnVerschluesselt = new JButton("verschl\u00FCsselt \u00F6ffnen");
		btnVerschluesselt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (BufferedReader in = new BufferedReader(new FileReader(dateiname))) {
					int c;
					StringBuffer inhalt = new StringBuffer();
					while ((c = in.read()) >= 0) {
						inhalt.append((char) c);
					} 
					tpEingabe.setText(inhalt.toString());
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Fehler beim Lesen.");
				}
			}
		});
		btnVerschluesselt.setBounds(165, 188, 225, 23);
		contentPane.add(btnVerschluesselt);
		
		JButton btnUnverschluesselt = new JButton("unverschl\u00FCsselt \u00F6ffnen");
		btnUnverschluesselt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (BufferedReader in = new BufferedReader(new VerschluesseltReader(new FileReader(dateiname)))) {
					int c;
					StringBuffer zeile = new StringBuffer();
					while ((c = in.read()) >=0) {
						zeile.append((char) c);
					}
					tpEingabe.setText(zeile.toString());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Fehler beim Lesen.");
				}
			}
		});
		btnUnverschluesselt.setBounds(165, 217, 225, 23);
		contentPane.add(btnUnverschluesselt);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 27, 414, 150);
		contentPane.add(scrollPane);
		
		tpEingabe = new JTextPane();
		scrollPane.setViewportView(tpEingabe);
	}
}
