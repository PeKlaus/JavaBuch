package gui11;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser; // für das Datei-Auswahlfenster
import javax.swing.JScrollPane;
import javax.swing.JList;      
import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.BufferedWriter; // zum Buffern der liste vor dem speichern
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;     // zum schreiben in eine Datei
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class A2Messreihespeichern extends JFrame {

	private JPanel contentPane;
	private JTextField tfMesswert;
	private DefaultListModel<String> MessreiheModel;
	private String dateiname = "." + File.separator + "messreihe.mwd";  // gibt den Dateinamen für das speichern an und 
	                                                                    // verweist ("./") auf das aktuelle Programmverzeichnis.
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A2Messreihespeichern frame = new A2Messreihespeichern();
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
	public A2Messreihespeichern() {
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setTitle("Messreihe speichern");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 300, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMesswert = new JLabel("Messwert");
		lblMesswert.setBounds(10, 11, 147, 14);
		contentPane.add(lblMesswert);
		
		tfMesswert = new JTextField();
		tfMesswert.setBounds(10, 26, 147, 20);
		contentPane.add(tfMesswert);
		tfMesswert.setColumns(10);
		
		JButton btnUebernehmen = new JButton("\u00DCbernehmen >>");
		btnUebernehmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uebernehmen();
			}
		});
		btnUebernehmen.setBounds(10, 57, 147, 23);
		contentPane.add(btnUebernehmen);
		
		JLabel lblMessreihe = new JLabel("Messreihe");
		lblMessreihe.setBounds(200, 11, 224, 14);
		contentPane.add(lblMessreihe);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(200, 26, 224, 165);
		contentPane.add(scrollPane);
		
		JList<String> listMessreihe = new JList<String>();
		scrollPane.setViewportView(listMessreihe);
		// Das Model erstellen
		MessreiheModel = new DefaultListModel<String>();
		listMessreihe.setModel(MessreiheModel);
		
		
		JButton btnSpeichern = new JButton(" Messreihe speichern >>");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				speichern();
				speichernmitfilechooser ();
			}
		});
		btnSpeichern.setBounds(200, 202, 224, 23);
		contentPane.add(btnSpeichern);
		
		JButton btnOeffnen = new JButton(" Messreihe \u00F6ffnen >>");
		btnOeffnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateioeffnen();
			}
		});
		btnOeffnen.setBounds(10, 91, 147, 23);
		contentPane.add(btnOeffnen);
		
	}
		
		private void uebernehmen() {
			if (!tfMesswert.getText().equals("")) { // testen ob eine Eingabe getätigt wurde
				MessreiheModel.addElement(tfMesswert.getText()); //eingegebenen Messwert der JList hinzufügen
				tfMesswert.requestFocus();
	            tfMesswert.selectAll();
			} else {
				JOptionPane.showMessageDialog(null , "Bitte geben Sie einen Messwert ein!");
				tfMesswert.requestFocus();
	            tfMesswert.selectAll();
			}
		}
		
		private void speichern() {
			
			File datei = new File(dateiname);    // File-Objekt erstellen
			                                                                        // erzeugt einen BufferedWriter (dem Konstruktor wird ein
			try	(BufferedWriter out = new BufferedWriter(new FileWriter(datei))) {  // neuer FileWriter mit Ziel das File >datei< übergeben.
				for (int i = 0; i < MessreiheModel.getSize(); i++) {                // Mit einer For-Schleife werden zeilenweise mit der write-Methode
					out.write(MessreiheModel.get(i).toString());                    // Zeile für Zeile in den BufferenWriter geschrieben.
					out.newLine(); // schreibt immer in eine neue Zeile
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		private void speichernmitfilechooser () {
			JFileChooser fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fc.setFileFilter(new FileNameExtensionFilter(
				"Messwertdateien *.mwd", "mwd"));
			fc.setCurrentDirectory(new File("."));
			int status = fc.showSaveDialog(null);
			 if (status == JFileChooser.APPROVE_OPTION) {
			    String selFile = fc.getSelectedFile().getAbsolutePath();
			    int index = selFile.indexOf('.');
			    if (index >= 0) {
				dateiname = selFile.substring(0, index).concat(".mwd");
			    } else {
				dateiname = selFile.concat(".mwd");
			    }
			    try {
				BufferedWriter out = new BufferedWriter(new FileWriter(
					dateiname));
				for (int i = 0; i < MessreiheModel.getSize(); i++) {
				    out.write(MessreiheModel.get(i).toString());
				    out.newLine();
				}
				out.close();
			    } catch (Exception ex) {
				JOptionPane.showMessageDialog(null,
					"Fehler beim Speichern!");
			    }
			}
		    }
		
		private void dateioeffnen() {
			
			MessreiheModel.clear();
			tfMesswert.requestFocus();
            tfMesswert.selectAll();;
			File datei = new File(dateiname);
			
			JFileChooser fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fc.setFileFilter(new FileNameExtensionFilter(
					"Messwertdateien *.mwd", "mwd"));
			fc.setCurrentDirectory(new File("."));
			int status = fc.showOpenDialog(null);
			if (status == JFileChooser.APPROVE_OPTION) {
				String selFile = fc.getSelectedFile().getAbsolutePath();
				int index = selFile.indexOf('.');
				if (index >= 0) {
					dateiname = selFile.substring(0, index).concat(".mwd");
				    } else {
					dateiname = selFile.concat(".mwd");
				    }
				try
				(BufferedReader in = new BufferedReader(new FileReader(dateiname))) {
					while ((selFile = in.readLine()) != null) {
						MessreiheModel.addElement(selFile);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			}
		
}
		
			
				


	




