package gui11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class Verzeichnisinhalt extends JFrame {

	private JPanel contentPane;
	private JTextField tfVerzeichnisse;
	private File verzeichnis;   // Objekt der Klasse File definieren
	private DefaultListModel <String> verzeichnisseModel, dateienModel; // Zwei Models für die Listboxen definieren
	private JList<String> listVerzeichnis; // Listbox Verzeichnisse
	private JList<String> listDateien;     // Listbox Dateien
	private JButton btnInhalt;
	private JButton btnEnde;
	private JScrollBar scrollBar;
	private JScrollBar scrollBar_1;
	private JButton btnAuswählen;
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Verzeichnisinhalt frame = new Verzeichnisinhalt();
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
	public Verzeichnisinhalt() {
		setTitle("Verzeichnisinhalt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVerzeichnis = new JLabel("Verzeichnis");
		lblVerzeichnis.setBounds(10, 11, 150, 14);
		contentPane.add(lblVerzeichnis);
		
		tfVerzeichnisse = new JTextField();
		tfVerzeichnisse.setBounds(10, 28, 414, 20);
		contentPane.add(tfVerzeichnisse);
		tfVerzeichnisse.setColumns(10);
		
		btnInhalt = new JButton("Inhalt anzeigen");
		btnInhalt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
    // Methode zum Anzeigen des Verzeichnisinhalts
				
				verzeichnisseModel.clear();  // Verzeichnis (Liste) leeren
				dateienModel.clear();        // Dateien (Liste) leeren
				if(tfVerzeichnisse.getText().isEmpty()) { // prüft ob ein Verzeichnis eingegeben wurde
					JOptionPane.showMessageDialog(null, "Verzeichnisname fehlt!");
				} else { // wenn nicht leer
					verzeichnis = new File(tfVerzeichnisse.getText()); // erzeugt das File-Objekt mit dem Namen verzeichnis
					if (verzeichnis.exists() && verzeichnis.isDirectory()) { //prüft ob das Verzeichnis im Dateisystem existiert
						String[] inhalt = verzeichnis.list(); // erzeugt ein lokales Array (inhalt) mit dem Inhalt aus dem Verzeichnis
						for (String eintrag : inhalt) { // abarbeiten des Arrays
							File f = new File(verzeichnis , eintrag);
							if (f.isDirectory()) { // prüfen ob Verzeichnis 
								verzeichnisseModel.addElement(eintrag); // Eintrag in die Liste Verzeichnis
							} else { // falls kein Verzeichnis 
								dateienModel.addElement(eintrag); // wird es in die Liste Dateien eingetragen
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Verzeichnis existiert nicht!");
						}
					}
				}
		});
		btnInhalt.setBounds(10, 59, 189, 23);
		contentPane.add(btnInhalt);
		
		JLabel lblVerzeichnisse = new JLabel("Verzeichnisse");
		lblVerzeichnisse.setBounds(10, 93, 132, 14);
		contentPane.add(lblVerzeichnisse);
		
		JLabel lblDateien = new JLabel("Dateien");
		lblDateien.setBounds(237, 93, 100, 14);
		contentPane.add(lblDateien);
		
		listDateien = new JList();
		listDateien.setBackground(Color.WHITE);
		listDateien.setBounds(237, 118, 187, 133);
		contentPane.add(listDateien);
		
		listVerzeichnis = new JList();
		listVerzeichnis.setBounds(10, 118, 189, 133);
		contentPane.add(listVerzeichnis);
		
		btnEnde = new JButton("Ende");
		btnEnde.setBounds(335, 262, 89, 23);
		contentPane.add(btnEnde);		
		
		scrollBar = new JScrollBar();
		scrollBar.setBounds(182, 118, 17, 133);
		contentPane.add(scrollBar);
		
		scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(407, 118, 17, 133);
		contentPane.add(scrollBar_1);
		
	// Konstruktor Frame
	// Models zur Aufnahme der Verzeichnis- und Dateieinträge erzeugen 
	// und den Listen zu zu ordnen.
				
		verzeichnisseModel = new DefaultListModel<String>();
		listVerzeichnis.setModel(verzeichnisseModel);
		dateienModel = new DefaultListModel<String>();
		listDateien.setModel(dateienModel);
		
		btnAuswählen = new JButton("Ausw\u00E4hlen");
		btnAuswählen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int status = fc.showOpenDialog(null);
				if (status == JFileChooser.APPROVE_OPTION) {
					File selFile = fc.getSelectedFile();
					tfVerzeichnisse.setText(selFile.getPath());
				}
			}
		});
		btnAuswählen.setBounds(237, 59, 187, 23);
		contentPane.add(btnAuswählen);
	}
}
