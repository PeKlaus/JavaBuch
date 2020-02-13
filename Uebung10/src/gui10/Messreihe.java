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
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class Messreihe extends JFrame {

    private JPanel contentPane;
    private JTextField tfMengeMesswerte;
    private JTextField tfMesswert;
    private JTextField tfMesswertbearbeiten;
    private JTextField tfWert;
    private JLabel lblMesswert;
    private JButton btnOkMesswert;
    private JButton btnMbearbeiten;
    private JLabel lblWert;
    private JButton btnWertspeichern;
    private JButton btnAuswertung;
    private JLabel lblMaxWert;
    private JLabel lblMinWert;
    private JLabel lblMittelwert;
    private JLabel lblMesswerte;
    private JButton btnEnde;
    private JLabel lblMengeMesswerte;
    private JButton btnOkMenge;
    private JLabel lblMesswertbearbeiten;
    private int mengeMess, i;
    private double[] messwerte;
    private double summe, maximalwert, minimalwert, mittelwert; 
    private DecimalFormat fzahl;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Messreihe frame = new Messreihe();
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
    public Messreihe() {
    	setTitle("Messreihe");
    	fzahl = new DecimalFormat("###,##0.000");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 557, 420);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	lblMengeMesswerte = new JLabel("Wie viele Messwerte sollen eingegeben werden? ");
	lblMengeMesswerte.setBounds(10, 11, 294, 14);
	contentPane.add(lblMengeMesswerte);
	
	tfMengeMesswerte = new JTextField();
	tfMengeMesswerte.setBounds(314, 8, 86, 20);
	contentPane.add(tfMengeMesswerte);
	tfMengeMesswerte.setColumns(10);
	
	btnOkMenge = new JButton("OK");
	btnOkMenge.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    try {
		    if (!tfMengeMesswerte.getText().equals("")) {
			mengeMess = Integer.parseInt(tfMengeMesswerte.getText());
			messwerte = new double [mengeMess];
			i = 1;
			OkMengevisible();
		    } else {
			JOptionPane.showMessageDialog(null, "Bitte geben Sie die Menge ein");
			tfMengeMesswerte.setText("");
			tfMengeMesswerte.requestFocus();
		    }
		    } catch (Exception ex) {
			    JOptionPane.showMessageDialog(null,"kein Zahlenwert!!");
			    tfMengeMesswerte.setText("");
			    tfMengeMesswerte.requestFocus();
			}
		}
	});
	btnOkMenge.setBounds(431, 7, 89, 23);
	contentPane.add(btnOkMenge);
	
	lblMesswert = new JLabel("Messwert 1");
	lblMesswert.setVisible(false);
	lblMesswert.setBounds(10, 54, 102, 14);
	contentPane.add(lblMesswert);
	
	tfMesswert = new JTextField();
	tfMesswert.setVisible(false);
	tfMesswert.setBounds(10, 68, 86, 20);
	contentPane.add(tfMesswert);
	tfMesswert.setColumns(10);
	
	btnOkMesswert = new JButton("OK");
	btnOkMesswert.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    try {
		    if (!tfMesswert.getText().equals("")) {
			summe = summe + Double.parseDouble(tfMesswert.getText());
			messwerte[i-1] = Double.parseDouble(tfMesswert.getText());
			if (i == mengeMess) {
			    for (int i=0; i<messwerte.length; i++) {
				lblMesswerte.setText(lblMesswerte.getText() + " / " + messwerte[i]);
			    }
			    if (i == mengeMess) {
				EingabeFertigvisible ();
			    }
			} else {
			    i++;
			    lblMesswert.setText("Messwert " + Integer.toString(i));
			    tfMesswert.setText("");
			    tfMesswert.requestFocus();
			}
		    } else {
			JOptionPane.showMessageDialog(null,"Bitte geben Sie einen Messwert ein");
			tfMesswert.requestFocus();
		    }
		} catch (Exception ex) {
		    JOptionPane.showMessageDialog(null,"kein Zahlenwert!!");
		    tfMesswert.setText("");
		    tfMesswert.requestFocus();
		}
		}
	});
	btnOkMesswert.setVisible(false);
	btnOkMesswert.setBounds(122, 67, 89, 23);
	contentPane.add(btnOkMesswert);
	
	lblMesswerte = new JLabel("Messwerte :");
	lblMesswerte.setVisible(false);
	lblMesswerte.setBounds(10, 99, 510, 14);
	contentPane.add(lblMesswerte);
	
	tfMesswertbearbeiten = new JTextField();
	tfMesswertbearbeiten.setVisible(false);
	tfMesswertbearbeiten.setBounds(10, 124, 86, 20);
	contentPane.add(tfMesswertbearbeiten);
	tfMesswertbearbeiten.setColumns(10);
	
	lblMesswertbearbeiten = new JLabel(".Messwert");
	lblMesswertbearbeiten.setVisible(false);
	lblMesswertbearbeiten.setBounds(106, 127, 64, 14);
	contentPane.add(lblMesswertbearbeiten);
	
	btnMbearbeiten = new JButton("bearbeiten");
	btnMbearbeiten.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    try {
			
			if (!tfMesswertbearbeiten.getText().equals("")
			    && Integer.parseInt(tfMesswertbearbeiten.getText()) <= mengeMess)
			{
			   lblWert.setText(lblWert.getText() + Integer.parseInt(tfMesswertbearbeiten.getText()));
			   tfWert.setText(Double.toString(messwerte[i = Integer.parseInt(tfMesswertbearbeiten.getText()) -1]));
			   tfWert.requestFocus();
			   tfWert.selectAll();
			} else {
			    JOptionPane.showMessageDialog(null, "keine gültige Nummer!!");
			    tfMesswertbearbeiten.requestFocus();
			}
		    } catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "kein Zahlenwert!!");
			tfMesswertbearbeiten.setText("");
			tfMesswertbearbeiten.requestFocus();
		    }
		}
	});
	btnMbearbeiten.setVisible(false);
	btnMbearbeiten.setBounds(215, 124, 113, 23);
	contentPane.add(btnMbearbeiten);
	
	lblWert = new JLabel("Wert");
	lblWert.setVisible(false);
	lblWert.setBounds(10, 168, 86, 14);
	contentPane.add(lblWert);
	
	tfWert = new JTextField();
	tfWert.setVisible(false);
	tfWert.setBounds(10, 193, 86, 20);
	contentPane.add(tfWert);
	tfWert.setColumns(10);
	
	btnWertspeichern = new JButton("speichern");
	btnWertspeichern.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    messwerte[i] = Double.parseDouble(tfWert.getText());
		    lblMesswerte.setText("Messwerte: ");
			    for (int i=0; i<messwerte.length; i++) {
				lblMesswerte.setText(lblMesswerte.getText() + " / " + messwerte[i]);
				tfMesswertbearbeiten.setText("");
				tfMesswertbearbeiten.requestFocus();
				tfWert.setText("");
				
			    }
		}
	});
	btnWertspeichern.setVisible(false);
	btnWertspeichern.setBounds(122, 192, 120, 23);
	contentPane.add(btnWertspeichern);
	
	btnAuswertung = new JButton("Messreihe auswerten");
	btnAuswertung.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    Auswerten();
		}
	});
	btnAuswertung.setVisible(false);
	btnAuswertung.setBounds(10, 237, 232, 23);
	contentPane.add(btnAuswertung);
	
	lblMaxWert = new JLabel("Maximalwert :");
	lblMaxWert.setVisible(false);
	lblMaxWert.setBounds(10, 271, 232, 14);
	contentPane.add(lblMaxWert);
	
	lblMinWert = new JLabel("Minimalwert  : ");
	lblMinWert.setVisible(false);
	lblMinWert.setBounds(10, 296, 232, 14);
	contentPane.add(lblMinWert);
	
	lblMittelwert = new JLabel("Mittelwert      :");
	lblMittelwert.setVisible(false);
	lblMittelwert.setBounds(10, 326, 232, 14);
	contentPane.add(lblMittelwert);
	
	btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	});
	btnEnde.setBounds(431, 348, 89, 23);
	contentPane.add(btnEnde);
    }
    
    private void OkMengevisible() {
	lblMengeMesswerte.setVisible(false);
	tfMengeMesswerte.setVisible(false);
	btnOkMenge.setVisible(false);
	lblMesswerte.setVisible(true);
	tfMesswert.setVisible(true);
	lblMesswert.setVisible(true);
	btnOkMesswert.setVisible(true);
	tfMesswert.requestFocus();
    }
    
    private void EingabeFertigvisible() {
	tfMesswert.setVisible(false);
	lblMesswert.setVisible(false);
	btnOkMesswert.setVisible(false);
	tfMesswertbearbeiten.setVisible(true);
	lblMesswertbearbeiten.setVisible(true);
	btnMbearbeiten.setVisible(true);
	lblWert.setVisible(true);
	tfWert.setVisible(true);
	btnWertspeichern.setVisible(true);
	btnAuswertung.setVisible(true);
    }
    
    private void Auswerten() {
	lblMaxWert.setVisible(true);
	lblMinWert.setVisible(true);
	lblMittelwert.setVisible(true);
	
	summe = 0;
	minimalwert = messwerte[0];
	maximalwert = messwerte[0];
	for (double mw : messwerte) {
	    if (minimalwert > mw) {
		minimalwert = mw;
	    }
	    if (maximalwert < mw) {
		maximalwert = mw;
	    }
	    summe = summe + mw;
	}
	mittelwert = summe / messwerte.length;
	lblMinWert.setText("Minimalwert: " + String.valueOf(minimalwert));
	lblMaxWert.setText("Maximalwert: " + String.valueOf(maximalwert));
	lblMittelwert.setText("Mittelwert: " + String.valueOf(fzahl.format(mittelwert)));
    }

}
