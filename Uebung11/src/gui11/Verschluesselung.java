package gui11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Verschluesselung extends JFrame {

	private JPanel contentPane;
	private String dateiname = "." + File.separator + "verschluesselt.txt";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Verschluesselung frame = new Verschluesselung();
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
	public Verschluesselung() {
		setTitle("Verschl\u00FCsselung");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEingabe = new JLabel("Eingabe");
		lblEingabe.setBounds(10, 11, 48, 14);
		contentPane.add(lblEingabe);
		
		JScrollPane JScrollPane = new JScrollPane();
		JScrollPane.setBounds(10, 36, 575, 229);
		contentPane.add(JScrollPane);
		
		JTextPane JTextPane = new JTextPane();
		JScrollPane.setViewportView(JTextPane);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (VerschluesseltWriter out = new VerschluesseltWriter(new FileWriter(dateiname))) {
					out.write(JTextPane.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Fehler beim Speichern");
				}
			}
		});
		btnSpeichern.setBounds(10, 276, 113, 23);
		contentPane.add(btnSpeichern);
		
		JButton btnVerschlsseltoeffnen = new JButton("verschl\u00FCsselt \u00F6ffnen");
		btnVerschlsseltoeffnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (BufferedReader in = new BufferedReader(new FileReader(dateiname))) {
					int c;
					StringBuffer inhalt = new StringBuffer();
					while ((c = in.read()) >=0) {
						inhalt.append((char) c);
					}
					JTextPane.setText(inhalt.toString());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Fehler beim Lesen.");
				}
			}
		});
		btnVerschlsseltoeffnen.setBounds(284, 276, 276, 23);
		contentPane.add(btnVerschlsseltoeffnen);
		
		JButton btnUnverschlsseltoeffnen = new JButton("unverschl\u00FCsselt \u00F6ffnen");
		btnUnverschlsseltoeffnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (BufferedReader in = new BufferedReader(new VerschluesseltReader(new FileReader(dateiname)))) {
					int c;
					StringBuffer zeile = new StringBuffer();
					while ((c = in.read()) >=0) {
						zeile.append((char) c);
					}
					JTextPane.setText(zeile.toString());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Fehler beim Lesen.");
				}
			}
		});
	
		btnUnverschlsseltoeffnen.setBounds(284, 310, 276, 23);
		contentPane.add(btnUnverschlsseltoeffnen);
	}
}