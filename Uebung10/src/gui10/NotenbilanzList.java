package gui10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class NotenbilanzList extends JFrame {

    private JPanel contentPane;
    private int notennummer;
    private double summe, besteNote, schlechtesteNote, notenschnitt;
    private ArrayList<Double> noten; // ArrayList definieren  ArrayList<Typ> Listenname
    private JLabel lblNote;
    private JTextField tfNote;
    private JButton btnNoteUebernehmen;
    private JLabel lblNotenzahl;
    private JLabel lblNotenschnitt;
    private JLabel lblBesteNote;
    private JLabel lblSchlechtesteNote;
    private JButton btnNeu;
    private JLabel lblNoten;
    private JTextField tfNotennummer;
    private JTextField tfNeuerWert;
    private JLabel lblNotennummer;
    private JButton btnNotennummer;
    private JLabel lblNeuerWert;
    private JButton btnNeuenWertSpeichern;
    private JButton btnLoeschen;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    NotenbilanzList frame = new NotenbilanzList();
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
    public NotenbilanzList() {
	noten = new ArrayList<Double>(); // Erzeugt die ArrayList mit dem Typ Double und dem Namen noten
    	setTitle("Notenbilanz");
    	new DecimalFormat("###,##0.00");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 492, 324);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JButton btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	});
	btnEnde.setBounds(335, 252, 89, 23);
	contentPane.add(btnEnde);
	
	lblNote = new JLabel("1.Note");
	lblNote.setBounds(10, 69, 81, 14);
	contentPane.add(lblNote);
	
	tfNote = new JTextField();
	tfNote.setBounds(5, 84, 86, 20);
	contentPane.add(tfNote);
	tfNote.setColumns(10);
	
	btnNoteUebernehmen = new JButton("\u00DCbernehmen");
	btnNoteUebernehmen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    if (!tfNote.getText().equals("")
				&& Double.parseDouble(tfNote.getText()) >= 1
				&& Double.parseDouble(tfNote.getText()) <= 6)
		    {
			noten.add(Double.parseDouble(tfNote.getText())); // in ArrayList noten den Wert aus tfNoten einfügen 
			Notenbilanzerstellen();  // grösse der ArrayList noten
			lblNote.setText(Integer.toString(noten.size()+1) + ".Note");
			tfNote.setText("");
			tfNote.requestFocus();
			if (btnNeu.isVisible() == false) {
			    btnNeu.setVisible(true);
			}
		    } else {
			JOptionPane.showMessageDialog(null, "gültige Note eingeben!");
			tfNote.requestFocus();
		    }
		}
	});
	btnNoteUebernehmen.setBounds(117, 83, 129, 23);
	contentPane.add(btnNoteUebernehmen);
	
	lblNotenzahl = new JLabel("");
	lblNotenzahl.setBounds(10, 120, 236, 14);
	contentPane.add(lblNotenzahl);
	
	lblNotenschnitt = new JLabel("");
	lblNotenschnitt.setBounds(10, 145, 236, 14);
	contentPane.add(lblNotenschnitt);
	
	lblBesteNote = new JLabel("");
	lblBesteNote.setBounds(10, 170, 236, 14);
	contentPane.add(lblBesteNote);
	
	lblSchlechtesteNote = new JLabel("");
	lblSchlechtesteNote.setBounds(10, 198, 236, 14);
	contentPane.add(lblSchlechtesteNote);
	
	btnNeu = new JButton("Neue Berechnung");
	btnNeu.setVisible(false);
	btnNeu.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		noten.clear(); // löschen aller Elemente aus der ArrayList noten
		lblNote.setText(Integer.toString(noten.size()+1) + ".Note");
		tfNote.setText("");
		lblNotenschnitt.setText("");
		lblBesteNote.setText("");
		lblSchlechtesteNote.setText("");
		lblNotenzahl.setText("");
		lblNeuerWert.setVisible(false);
		tfNeuerWert.setVisible(false);
		btnNeuenWertSpeichern.setVisible(false);
		btnLoeschen.setVisible(false);
		lblNoten.setText("");
		tfNote.requestFocus();
		btnNeu.setVisible(false);
	    }
	});
	btnNeu.setBounds(256, 25, 168, 23);
	contentPane.add(btnNeu);
	
	lblNoten = new JLabel("");
	lblNoten.setBounds(10, 225, 414, 14);
	contentPane.add(lblNoten);
	
	tfNotennummer = new JTextField();
	tfNotennummer.setBounds(256, 84, 33, 20);
	contentPane.add(tfNotennummer);
	tfNotennummer.setColumns(10);
	
	lblNotennummer = new JLabel(".Note bearbeiten");
	lblNotennummer.setBounds(299, 87, 102, 14);
	contentPane.add(lblNotennummer);
	
	btnNotennummer = new JButton("OK");
	btnNotennummer.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    try {
				notennummer = Integer.parseInt(tfNotennummer.getText()) - 1;
				if ((notennummer >= 0) && (notennummer < noten.size()))
				{
					lblNeuerWert.setText(notennummer + 1 + ". Note");
					lblNeuerWert.setVisible(true);
					tfNeuerWert.setVisible(true);
					btnNeuenWertSpeichern.setVisible(true);
					btnLoeschen.setVisible(true);
					tfNeuerWert.setText(String.valueOf(noten.get(notennummer)));// fügt in das tfNeuerWert das Element(Note) aus der ArrayList ein
					tfNeuerWert.requestFocus();
				} else
				{
					JOptionPane.showMessageDialog(null,
							"Notennummer außerhalb des gültigen Bereichs!");
					tfNotennummer.requestFocus();
				}
		    } catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "ungültiges Zahlenformat!");
		    }
		}
	});
	btnNotennummer.setBounds(411, 84, 55, 21);
	contentPane.add(btnNotennummer);
	
	lblNeuerWert = new JLabel("1.Note");
	lblNeuerWert.setVisible(false);
	lblNeuerWert.setBounds(256, 120, 46, 14);
	contentPane.add(lblNeuerWert);
	
	tfNeuerWert = new JTextField();
	tfNeuerWert.setVisible(false);
	tfNeuerWert.setBounds(253, 139, 60, 20);
	contentPane.add(tfNeuerWert);
	tfNeuerWert.setColumns(10);
	
	btnNeuenWertSpeichern = new JButton("Speichern");
	btnNeuenWertSpeichern.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    try {
				noten.set(notennummer, Double.parseDouble(tfNeuerWert.getText())); // Ersetzt das Element an der angegebenen Position 
				Notenbilanzerstellen();                                            // in dieser Liste durch das angegebene Element.
				lblNeuerWert.setVisible(false);
				tfNeuerWert.setVisible(false);
				btnNeuenWertSpeichern.setVisible(false);
				btnLoeschen.setVisible(false);
		    } catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "ungültiges Zahlenformat!");
		    }
		}
	});
	btnNeuenWertSpeichern.setVisible(false);
	btnNeuenWertSpeichern.setBounds(335, 138, 131, 23);
	contentPane.add(btnNeuenWertSpeichern);
	
	btnLoeschen = new JButton("L\u00F6schen");
	btnLoeschen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    try {
				noten.remove(notennummer); // Löscht das angegebene Element aus der ArrayList
				Notenbilanzerstellen();
				lblNeuerWert.setVisible(false);
				tfNeuerWert.setVisible(false);
				btnNeuenWertSpeichern.setVisible(false);
				btnLoeschen.setVisible(false);
		    } catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Fehler bei der Anagbe der Notennummer!");
		    }
			
		}
	});
	btnLoeschen.setVisible(false);
	btnLoeschen.setBounds(335, 175, 131, 23);
	contentPane.add(btnLoeschen); 
	tfNote.requestFocus();           
    }
    
    private void Notenbilanzerstellen()
	{
		lblNotenzahl.setText("Anzahl eingegebene Noten: "
				+ Integer.toString(noten.size()));
		summe = 0;
		besteNote = noten.get(0);
		schlechtesteNote = noten.get(0); 
		lblNoten.setText("Noten: ");
		for (double x : noten) {
			summe = summe + x;
			if (besteNote > x)
				besteNote = x;
			if (schlechtesteNote < x)
				schlechtesteNote = x;
			lblNoten.setText(lblNoten.getText() + " " + x);
		}
		notenschnitt = summe / noten.size(); // summe / grösse der noten ArrayList
		lblBesteNote.setText("beste Note: " + Double.toString(besteNote));
		lblSchlechtesteNote.setText("schlechteste Note: "
				+ Double.toString(schlechtesteNote));
		lblNotenschnitt.setText("Notenschnitt: "
				+ Double.toString(notenschnitt));
		lblNote.setText(Integer.toString(noten.size()+1) + ".Note");
		
	}
}
