package gui10;

import java.awt.EventQueue;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Artikelliste extends JFrame {

    private JPanel contentPane;
    private JTextField tfArtikelnummer;
    private JTextField tfArtikelbezeichnung;
    private JTextField tfStueckpreis;
    private ArrayList<Artikel> artikel;
    private int anzeigenummer;
    private JLabel lblAnzahl;
    private JLabel lblArtikel;
    private DecimalFormat fzahl;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Artikelliste frame = new Artikelliste();
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
    public Artikelliste() {
    	setTitle("Artikelliste");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 299);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblArtikelnummer = new JLabel("Artikelnummer");
	lblArtikelnummer.setBounds(10, 11, 110, 14);
	contentPane.add(lblArtikelnummer);
	
	tfArtikelnummer = new JTextField();
	tfArtikelnummer.setBounds(10, 26, 161, 20);
	contentPane.add(tfArtikelnummer);
	tfArtikelnummer.setColumns(10);
	
	JLabel lblArtikelbezeichnung = new JLabel("Artikelbezeichnung");
	lblArtikelbezeichnung.setBounds(210, 11, 116, 14);
	contentPane.add(lblArtikelbezeichnung);
	
	tfArtikelbezeichnung = new JTextField();
	tfArtikelbezeichnung.setBounds(210, 26, 214, 20);
	contentPane.add(tfArtikelbezeichnung);
	tfArtikelbezeichnung.setColumns(10);
	
	JLabel lblStckpreis = new JLabel("St\u00FCckpreis (\u20AC)");
	lblStckpreis.setBounds(10, 57, 110, 14);
	contentPane.add(lblStckpreis);
	
	tfStueckpreis = new JTextField();
	tfStueckpreis.setBounds(10, 73, 161, 20);
	contentPane.add(tfStueckpreis);
	tfStueckpreis.setColumns(10);
	
	JButton btnSpeichern = new JButton("Speichern");
	btnSpeichern.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    try {
			    if (!tfArtikelnummer.getText().isEmpty()
				    && !tfArtikelbezeichnung.getText().isEmpty()
				    && !tfStueckpreis.getText().isEmpty()) {
				artikel.add(new Artikel(tfArtikelnummer.getText(),
					tfArtikelbezeichnung.getText(), Double
						.parseDouble(tfStueckpreis.getText())));
				lblAnzahl.setText("" + artikel.size());
			    } else
				JOptionPane.showMessageDialog(null,
					"Fehler! Eingaben unvollständig!");
			} catch (Exception ex) {
			    JOptionPane.showMessageDialog(null, "Fehler! Eingaben prüfen!");
			}
		}
	});
	btnSpeichern.setBounds(210, 72, 116, 23);
	contentPane.add(btnSpeichern);
	
	JLabel lblGespeicherteArtikel = new JLabel("Gespeicherte Artikel: ");
	lblGespeicherteArtikel.setBounds(10, 118, 129, 14);
	contentPane.add(lblGespeicherteArtikel);
	
	JButton btnNaechstenArtikelAnzeigen = new JButton("N\u00E4chsten Artikel anzeigen");
	btnNaechstenArtikelAnzeigen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if (!artikel.isEmpty()) {
		    Artikel a = (Artikel) artikel.get(anzeigenummer);
		    lblArtikel.setText(a.getArtikelnummer() + "; "
			    + a.getArtikelbezeichnung() + "; "
			    + fzahl.format(a.getStueckpreis()) + " €");
		    anzeigenummer++;
		    if (anzeigenummer > artikel.size() - 1)
			anzeigenummer = 0;
		}
	    }
	});
	btnNaechstenArtikelAnzeigen.setBounds(10, 156, 204, 23);
	contentPane.add(btnNaechstenArtikelAnzeigen);
	
	JButton btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	});
	btnEnde.setBounds(182, 227, 89, 23);
	contentPane.add(btnEnde);
	
	lblAnzahl = new JLabel("0");
	lblAnzahl.setBounds(168, 118, 46, 14);
	contentPane.add(lblAnzahl);
	
	lblArtikel = new JLabel("");
	lblArtikel.setBounds(10, 190, 414, 14);
	contentPane.add(lblArtikel);
	
	artikel = new ArrayList<Artikel>();
	anzeigenummer=0;
	fzahl = new DecimalFormat("###,##0.00");
    }
}