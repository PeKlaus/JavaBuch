package gui11;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Kontaktliste1 extends JFrame {

    private JPanel contentPane;
    private JTextField tfNachname;
    private JTextField tfVorname;
    private JTextField tfTelefon;
    private JTextField tfEmail;
    private DefaultListModel<String> kontakteModel;
//  private String dateiname = "./kontakte1.dat"; //
    private String dateiname = "." + File.separator + "kontakte1.dat";
    
    
    
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Kontaktliste1 frame = new Kontaktliste1();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    
    public Kontaktliste1() {
    	setTitle("Kontaktliste");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 540, 308);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	File datei = new File(dateiname);
	

	
	
	JLabel lblNachname = new JLabel("Nachname");
	lblNachname.setBounds(10, 11, 105, 14);
	contentPane.add(lblNachname);
	
	tfNachname = new JTextField();
	tfNachname.setBounds(10, 27, 131, 20);
	contentPane.add(tfNachname);
	tfNachname.setColumns(10);
	
	JLabel lblVorname = new JLabel("Vorname");
	lblVorname.setBounds(154, 11, 87, 14);
	contentPane.add(lblVorname);
	
	tfVorname = new JTextField();
	tfVorname.setBounds(155, 27, 131, 20);
	contentPane.add(tfVorname);
	tfVorname.setColumns(10);
	
	JLabel lblTelefon = new JLabel("Telefon");
	lblTelefon.setBounds(300, 11, 116, 14);
	contentPane.add(lblTelefon);
	
	tfTelefon = new JTextField();
	tfTelefon.setBounds(296, 27, 218, 20);
	contentPane.add(tfTelefon);
	tfTelefon.setColumns(10);
	
	JLabel lblEmail = new JLabel("EMail");
	lblEmail.setBounds(10, 58, 131, 14);
	contentPane.add(lblEmail);
	
	tfEmail = new JTextField();
	tfEmail.setBounds(10, 74, 276, 20);
	contentPane.add(tfEmail);
	tfEmail.setColumns(10);
	
	JButton btnUebernehmen = new JButton("\u00DCbernehmen >>");
	btnUebernehmen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    if (tfNachname.getText().isEmpty()) {
			    JOptionPane.showMessageDialog(null, "Kein Name angegeben.");
			    tfNachname.requestFocus();
			} else {
			    kontakteModel.addElement(tfNachname.getText() + ";"
				    + tfVorname.getText() + ";" + tfTelefon.getText() + ";"
				    + tfEmail.getText());
			    tfNachname.setText("");
			    tfVorname.setText("");
			    tfTelefon.setText("");
			    tfEmail.setText("");
			    tfNachname.requestFocus();
			}
		}
	});
	btnUebernehmen.setBounds(300, 73, 214, 23);
	contentPane.add(btnUebernehmen);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 119, 504, 105);
	contentPane.add(scrollPane);
	
	JList<String> listKontakte = new JList<String>();
	listKontakte.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	scrollPane.setViewportView(listKontakte);
	
	JLabel lblKontaktliste = new JLabel("Kontaktliste");
	lblKontaktliste.setBounds(10, 105, 131, 14);
	contentPane.add(lblKontaktliste);
	
	JButton btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
	   // Speichern einer Textdatei //		
			
			try (BufferedWriter out = new BufferedWriter(new FileWriter(datei))) {
				for (int i = 0; i < kontakteModel.getSize(); i ++) {
					out.write(kontakteModel.get(i).toString());
					out.newLine();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		    System.exit(0);
		}
	});
	btnEnde.setBounds(425, 235, 89, 23);
	contentPane.add(btnEnde);
	
	// Erstellen der Model
	kontakteModel = new DefaultListModel<String>();
	listKontakte.setModel(kontakteModel);
	
	  // Datei einlesen falls vorhanden //
	
		if (!datei.exists()) {
			try {
				datei.createNewFile();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} else {
			String adresszeile;
			try (BufferedReader in = new BufferedReader(new FileReader(datei))) {
				while ((adresszeile = in.readLine()) !=null) {
					kontakteModel.addElement(adresszeile);
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	
	JButton btnLoeschen = new JButton("markierten Eintrag l\u00F6schen");
	btnLoeschen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    int index = listKontakte.getSelectedIndex();
		    if (index >= 0) {
			kontakteModel.remove(index);
		    } else {
			JOptionPane.showMessageDialog(null, "Kein Eintrag markiert.");
		    }
		    
		}
	});
	btnLoeschen.setBounds(10, 235, 191, 23);
	contentPane.add(btnLoeschen);
	
	JButton btnBearbeiten = new JButton("bearbeiten");
	btnBearbeiten.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    int index = listKontakte.getSelectedIndex();
			if (index >= 0) {
			    String zeile = (String) kontakteModel.getElementAt(index);
			    tfNachname.setText(zeile.substring(0, zeile.indexOf(";")));
			    zeile = zeile.substring(zeile.indexOf(";") + 1, zeile.length());
			    tfVorname.setText(zeile.substring(0, zeile.indexOf(";")));
			    zeile = zeile.substring(zeile.indexOf(";") + 1, zeile.length());
			    tfTelefon.setText(zeile.substring(0, zeile.indexOf(";")));
			    zeile = zeile.substring(zeile.indexOf(";") + 1, zeile.length());
			    tfEmail.setText(zeile);
			    kontakteModel.remove(index);
			}
		}
	});
	btnBearbeiten.setBounds(247, 235, 124, 23);
	contentPane.add(btnBearbeiten);
    }
}