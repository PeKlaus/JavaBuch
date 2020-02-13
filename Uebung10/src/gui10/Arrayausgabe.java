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

public class Arrayausgabe extends JFrame {

    private JPanel contentPane;
    private JTextField tfEingabeZ;
    private JTextField tfZahl;
    private JLabel lblAusgabeRueck;
    private JLabel lblAusgabeVor;
    private JButton btnOkZahl;
    private JButton btnOkEingabeZ;
    private JButton btnNeueEingabe;
    private JLabel lblZahl;
    private int i, zahlen;
    private int[] eingegebeneZahlen;
    private JLabel lblWievieleZahlen;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Arrayausgabe frame = new Arrayausgabe();
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
    public Arrayausgabe() {
    	setTitle("Arrayausgabe");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 475, 232);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	lblWievieleZahlen = new JLabel("Wieviele Zahlen sollen eingegeben werden?");
	lblWievieleZahlen.setBounds(10, 11, 253, 14);
	contentPane.add(lblWievieleZahlen);
	
	tfEingabeZ = new JTextField();
	tfEingabeZ.setBounds(273, 8, 61, 20);
	contentPane.add(tfEingabeZ);
	tfEingabeZ.setColumns(10);
	
	btnOkEingabeZ = new JButton("OK");
	btnOkEingabeZ.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    try {
		    if (!tfEingabeZ.getText().equals("")) {
			zahlen = Integer.parseInt(tfEingabeZ.getText());
			eingegebeneZahlen = new int [zahlen]; // Array erzeugt mit der Größe der Eingabe
			i = 1;
			lblZahl.setVisible(true);
			tfZahl.setVisible(true);
			btnOkZahl.setVisible(true);
			btnNeueEingabe.setVisible(true);
			lblWievieleZahlen.setVisible(false);
			tfEingabeZ.setVisible(false);
			btnOkEingabeZ.setVisible(false);
			tfZahl.requestFocus();
			
		} else {
		    JOptionPane.showMessageDialog(null , "Bitte geben Sie eine Zahl ein!");
		    tfEingabeZ.requestFocus();
		}
		} catch (Exception ex) {
		    JOptionPane.showMessageDialog(null, "Kein gültiger Zahlenwert!!");
		    tfEingabeZ.requestFocus();
		    tfEingabeZ.setText("");
		}
		    
		}
	});
	btnOkEingabeZ.setBounds(344, 7, 89, 23);
	contentPane.add(btnOkEingabeZ);
	
	lblZahl = new JLabel("Zahl 1");
	lblZahl.setVisible(false);
	lblZahl.setBounds(10, 57, 86, 14);
	contentPane.add(lblZahl);
	
	tfZahl = new JTextField();
	tfZahl.setVisible(false);
	tfZahl.setBounds(10, 72, 86, 20);
	contentPane.add(tfZahl);
	tfZahl.setColumns(10);
	
	btnOkZahl = new JButton("OK");
	btnOkZahl.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    try {
		    if (!tfZahl.getText().equals("")) {
			eingegebeneZahlen[i-1] = Integer.parseInt(tfZahl.getText()); // dem Array die Eingabe zuweisen
			if (i == zahlen) {
			    for (int i = 0; i < eingegebeneZahlen.length; i++) {
				lblAusgabeVor.setText(lblAusgabeVor.getText() + " " + eingegebeneZahlen[i]);
			    }
			    if (i == zahlen) {
			    for (int i = eingegebeneZahlen.length - 1; i >= 0 ; i--) {
				lblAusgabeRueck.setText(lblAusgabeRueck.getText() + " " + eingegebeneZahlen[i]);
			    }
			    lblAusgabeRueck.setVisible(true);
			    lblAusgabeVor.setVisible(true);
			    }
			} else {
			    i++;
			    lblZahl.setText("Zahl " + Integer.toString(i));
			    tfZahl.setText("");
			    tfZahl.requestFocus();
			}
		    } else {
			JOptionPane.showMessageDialog(null, "Bitte geben Sie eine Zahl ein!");
			tfZahl.requestFocus();
		    }
		} catch (Exception ex) {
		    JOptionPane.showMessageDialog(null, "Kein gültiger Zahlenwert!!");
		    tfZahl.setText("");
		    tfZahl.requestFocus();
		}
		}
	});
	btnOkZahl.setVisible(false);
	btnOkZahl.setBounds(116, 71, 89, 23);
	contentPane.add(btnOkZahl);
	
	btnNeueEingabe = new JButton("Neue Eingabe");
	btnNeueEingabe.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    lblZahl.setVisible(false);
	            tfZahl.setVisible(false);
		    btnOkZahl.setVisible(false);
	            btnNeueEingabe.setVisible(false);
	            lblWievieleZahlen.setVisible(true);
		    tfEingabeZ.setVisible(true);
		    btnOkEingabeZ.setVisible(true);
		    lblAusgabeVor.setText("Ausgabe vorwärts : ");
		    lblAusgabeVor.setVisible(false);
		    lblAusgabeRueck.setText("Ausgabe rückwärts : ");
		    lblAusgabeRueck.setVisible(false);
		    tfEingabeZ.setText("");
		    tfEingabeZ.requestFocus();
		    lblZahl.setText("Zahl 1");
		    tfZahl.setText("");
		}
	});
	btnNeueEingabe.setVisible(false);
	btnNeueEingabe.setBounds(273, 71, 131, 23);
	contentPane.add(btnNeueEingabe);
	
	lblAusgabeVor = new JLabel("Ausgabe vorw\u00E4rts : ");
	lblAusgabeVor.setVisible(false);
	lblAusgabeVor.setBounds(10, 129, 423, 14);
	contentPane.add(lblAusgabeVor);
	
	lblAusgabeRueck = new JLabel("Ausgabe r\u00FCckw\u00E4rts : ");
	lblAusgabeRueck.setVisible(false);
	lblAusgabeRueck.setBounds(10, 160, 423, 14);
	contentPane.add(lblAusgabeRueck);
    }
}
