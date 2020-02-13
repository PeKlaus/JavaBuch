package gui10;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Notenbilanz extends JFrame {

    private JPanel contentPane;
    private JTextField tfAnzahlNoten;
    private int notenzahl, i, notennummer; //notenzahl = Anzahl Noten , i = Zähler für eingegebener Noten
    private double summe, besteNote, schlechtesteNote, notenschnitt;
    private JButton btnAnzahlUebernehmen;
    private JLabel lblNote;
    private JTextField tfNote;
    private JButton btnNoteUebernehmen;
    private JLabel lblNotenzahl;
    private JLabel lblNotenschnitt;
    private JLabel lblBesteNote;
    private JLabel lblSchlechtesteNote;
    private JButton btnNeu;
    private DecimalFormat fzahl; 
    private double [] noten;// Array Definieren
    private JLabel lblNoten;
    private JTextField tfNotennummer;
    private JLabel lblNotennummer;
    private JButton btnNotennummer;
    private JLabel lblNeuerWert;
    private JTextField tfNeuerWert;
    private JButton btnNeuenWertSpeichern;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Notenbilanz frame = new Notenbilanz();
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
    public Notenbilanz() {
    	setTitle("Notenbilanz");
    	fzahl = new DecimalFormat("###,##0.00");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 489, 316);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblAnzahlNoten = new JLabel("Anzahl Noten");
	lblAnzahlNoten.setBounds(10, 11, 81, 14);
	contentPane.add(lblAnzahlNoten);
	
	tfAnzahlNoten = new JTextField();
	tfAnzahlNoten.setBounds(5, 26, 86, 20);
	contentPane.add(tfAnzahlNoten);
	tfAnzahlNoten.setColumns(10);
	
	btnAnzahlUebernehmen = new JButton("\u00DCbernehmen");
	btnAnzahlUebernehmen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    if (!tfAnzahlNoten.getText().equals("")) {
	    // notenzahl wird aus dem tfAnzahlNoten Initialisiert
			    notenzahl = Integer.parseInt(tfAnzahlNoten.getText());
            // Erzeugen des Arrays für die eingegebenen Noten ([notenzahl] gibt die Größe an
	             // Wichtig!! erst im Programm erzeugen!!
			    noten = new double [notenzahl];
			    i = 1;
			    summe = 0;
			    besteNote = 6;
			    schlechtesteNote = 0;
			    btnAnzahlUebernehmen.setVisible(false);
			    tfAnzahlNoten.setEditable(false);
			    lblNote.setVisible(true);
			    tfNote.setVisible(true);
			    btnNoteUebernehmen.setVisible(true);
			    tfNote.requestFocus();
			} else {
			    JOptionPane.showMessageDialog(null, "Anzahl der Noten eingeben!");
			    tfAnzahlNoten.requestFocus();
			}
		}
	});
	btnAnzahlUebernehmen.setBounds(112, 25, 134, 23);
	contentPane.add(btnAnzahlUebernehmen);
	
	JButton btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	});
	btnEnde.setBounds(371, 239, 89, 23);
	contentPane.add(btnEnde);
	
	lblNote = new JLabel("1.Note");
	lblNote.setVisible(false);
	lblNote.setBounds(10, 69, 81, 14);
	contentPane.add(lblNote);
	
	tfNote = new JTextField();
	tfNote.setVisible(false);
	tfNote.setBounds(5, 84, 86, 20);
	contentPane.add(tfNote);
	tfNote.setColumns(10);
	
	btnNoteUebernehmen = new JButton("\u00DCbernehmen");
	btnNoteUebernehmen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    if (!tfNote.getText().equals("")  
			    &&  Double.parseDouble(tfNote.getText()) >= 1  
			    &&  Double.parseDouble(tfNote.getText()) <= 6) 
		    {			
			    summe = summe + Double.parseDouble(tfNote.getText());
			    //Übernahme der eingegebenen Noten in das Array
			    noten[i-1] = Double.parseDouble(tfNote.getText());
			    notenschnitt = summe / i;
			    lblNotenschnitt.setText("Notenschnitt: " + fzahl.format(notenschnitt));
			    lblNotenzahl.setText("Anzahl eingegebene Noten: " + Integer.toString(i));

			    if (Double.parseDouble(tfNote.getText()) > schlechtesteNote) {
				schlechtesteNote = Double.parseDouble(tfNote.getText());
				lblSchlechtesteNote.setText("schlechteste Note: " + Double.toString(schlechtesteNote));
			    }
			    if (Double.parseDouble(tfNote.getText()) < besteNote) {
				besteNote = Double.parseDouble(tfNote.getText());
				lblBesteNote.setText("beste Note: " + Double.toString(besteNote));
			    }
			    if (i == notenzahl) {
				notenschnitt = summe / notenzahl;
				btnNoteUebernehmen.setVisible(false);
				btnNeu.setVisible(true);
				lblNoten.setText("Noten: ");
             //for Schleife zum ausgeben der Noten aus dem Array ( Initialisierung; Bedingung; Update) { Anweisungen...
				for (int i = 0; i < noten.length; i++) {
				    lblNoten.setText(lblNoten.getText() + "/" + noten[i]);
				}
				lblNoten.setVisible(true);
				lblNotennummer.setVisible(true);
				tfNotennummer.setVisible(true);
				btnNotennummer.setVisible(true);
			    } else {
				i++;
				lblNote.setText(Integer.toString(i) + ".Note");
				tfNote.setText("");
				tfNote.requestFocus();
			    }
			} else {
			    JOptionPane.showMessageDialog(null, "gültige Note eingeben!");
			    tfNote.requestFocus();
			}
		}
	});
	btnNoteUebernehmen.setVisible(false);
	btnNoteUebernehmen.setBounds(117, 83, 129, 23);
	contentPane.add(btnNoteUebernehmen);
	
	lblNotenzahl = new JLabel("");
	lblNotenzahl.setBounds(10, 120, 236, 14);
	contentPane.add(lblNotenzahl);
	
	lblNotenschnitt = new JLabel("");
	lblNotenschnitt.setBounds(10, 145, 236, 14);
	contentPane.add(lblNotenschnitt);
	
	lblBesteNote = new JLabel("");
	lblBesteNote.setBounds(10, 161, 236, 14);
	contentPane.add(lblBesteNote);
	
	lblSchlechtesteNote = new JLabel("");
	lblSchlechtesteNote.setBounds(10, 178, 236, 14);
	contentPane.add(lblSchlechtesteNote);
	
	btnNeu = new JButton("Neue Berechnung");
	btnNeu.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		i = 1;
		lblNote.setText(Integer.toString(i) + ".Note");
		summe = 0;
		besteNote = 6;
		schlechtesteNote = 0;
		btnAnzahlUebernehmen.setVisible(true);
		tfAnzahlNoten.setEditable(true);
		lblNote.setVisible(false);
		tfNote.setVisible(false);
		tfNote.setText("");
		btnNoteUebernehmen.setVisible(false);
		tfAnzahlNoten.setText("");
		tfAnzahlNoten.requestFocus();
		lblNotenschnitt.setText("");
		lblBesteNote.setText("");
		lblSchlechtesteNote.setText("");
		lblNotenzahl.setText("");
		btnNeu.setVisible(false);
		lblNeuerWert.setVisible(false);
		tfNeuerWert.setVisible(false);
		btnNeuenWertSpeichern.setVisible(false);
		lblNotennummer.setVisible(false);
		tfNotennummer.setVisible(false);
		btnNotennummer.setVisible(false);
		lblNoten.setText("");
		
	    }
	});
	btnNeu.setVisible(false);
	btnNeu.setBounds(256, 25, 204, 23);
	contentPane.add(btnNeu);
	
	lblNoten = new JLabel("");
	lblNoten.setVisible(false);
	lblNoten.setBounds(10, 248, 315, 14);
	contentPane.add(lblNoten);
	
	tfNotennummer = new JTextField();
	tfNotennummer.setVisible(false);
	tfNotennummer.setBounds(259, 84, 33, 20);
	contentPane.add(tfNotennummer);
	tfNotennummer.setColumns(10);
	
	lblNotennummer = new JLabel(".Note bearbeiten");
	lblNotennummer.setVisible(false);
	lblNotennummer.setBounds(302, 87, 94, 14);
	contentPane.add(lblNotennummer);
	
	btnNotennummer = new JButton("OK");
	btnNotennummer.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    try {
		    notennummer = Integer.parseInt(tfNotennummer.getText()) -1;
		    if ((notennummer >= 0) && (notennummer < notenzahl)) {
			lblNeuerWert.setText(notennummer +1 + ".Note");
		        lblNeuerWert.setVisible(true);
		        tfNeuerWert.setVisible(true);
		        btnNeuenWertSpeichern.setVisible(true);
		        tfNeuerWert.setText(String.valueOf(noten[notennummer]));
		        tfNeuerWert.requestFocus();
		        tfNeuerWert.selectAll();
		    } else {
			JOptionPane.showMessageDialog(null, "Notennummer außerhalb des gültigen Bereichs!");
			tfNotennummer.requestFocus();
		    }
		} catch (Exception ex) {
		    JOptionPane.showMessageDialog(null, "ungültiges Zahlenformat!!");
		    tfNeuerWert.requestFocus();
		    tfNeuerWert.selectAll();
		}
		}
	});
	btnNotennummer.setVisible(false);
	btnNotennummer.setBounds(402, 83, 58, 23);
	contentPane.add(btnNotennummer);
	
	lblNeuerWert = new JLabel(".Note");
	lblNeuerWert.setVisible(false);
	lblNeuerWert.setBounds(256, 120, 69, 14);
	contentPane.add(lblNeuerWert);
	
	tfNeuerWert = new JTextField();
	tfNeuerWert.setVisible(false);
	tfNeuerWert.setBounds(256, 139, 69, 20);
	contentPane.add(tfNeuerWert);
	tfNeuerWert.setColumns(10);
	
	btnNeuenWertSpeichern = new JButton("Speichern");
	btnNeuenWertSpeichern.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    try {
			    noten[notennummer] = Double.parseDouble(tfNeuerWert.getText());
			    summe = 0;
			    besteNote = noten[0];
			    schlechtesteNote = noten[0];
			    lblNoten.setText("Noten: ");
			    for (double x : noten) {
				summe = summe + x;
				if (besteNote > x)
				    besteNote = x;
				if (schlechtesteNote < x)
				    schlechtesteNote = x;
				lblNoten.setText(lblNoten.getText() + " " + x);
			    }
			    notenschnitt = summe / notenzahl;
			    lblBesteNote.setText("beste Note: " + Double.toString(besteNote));
			    lblSchlechtesteNote.setText("schlechteste Note: "
				    + Double.toString(schlechtesteNote));
			    lblNotenschnitt.setText("Notenschnitt: " + fzahl.format(notenschnitt));
			} catch (Exception ex) {
			    JOptionPane.showMessageDialog(null, "ungültiges Zahlenformat!");
			}
		}
	});
	btnNeuenWertSpeichern.setVisible(false);
	btnNeuenWertSpeichern.setBounds(335, 138, 125, 23);
	contentPane.add(btnNeuenWertSpeichern);
    }
}
