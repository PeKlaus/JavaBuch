package gui10;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Arrayausgabe2 extends JFrame {

    private JPanel contentPane;
    private JTextField tfAnzahl;
    private JTextField tfZahl;
    private JLabel lblZahl;
    private JButton btnEingabeZahl;
    private JLabel lblAusgabeVorwaerts;
    private JLabel lblAusgabeRueckwaerts;
    private JButton btnNeueEingabe;
    private ArrayList<Integer> zahlenListe;
    private JLabel lblWievieleZahlen;
    private JButton btnEingabeAnzahl;
    private int i, mengeZahlen;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Arrayausgabe2 frame = new Arrayausgabe2();
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
    public Arrayausgabe2() {
    	setTitle("Arrayausgabe2");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 529, 224);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	lblWievieleZahlen = new JLabel("Wieviele Zahlen sollen eingegeben werden?");
	lblWievieleZahlen.setBounds(10, 11, 286, 14);
	contentPane.add(lblWievieleZahlen);
	
	tfAnzahl = new JTextField();
	tfAnzahl.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			     try { 
					 if (!tfAnzahl.getText().equals("")) { // testen ob eine Eingabe getätigt wurde
					     i = 1;
					     mengeZahlen = Integer.parseInt(tfAnzahl.getText()); // Eingegebene Menge in Variable speichern
					     zahlenListe = new ArrayList<Integer>();  // Neue ArrayList mit Typ Integer erzeugen
				         // Visibles neu Setzen
					     lblWievieleZahlen.setVisible(false);
					     tfAnzahl.setVisible(false);
					     btnEingabeAnzahl.setVisible(false);
					     lblZahl.setVisible(true);
					     tfZahl.setVisible(true);
					     btnEingabeZahl.setVisible(true);
					     btnNeueEingabe.setVisible(true);
					     tfZahl.setText("");
					     tfZahl.requestFocus();
					 } else { // Message wenn keine Eingabe getätigt wurde
					     JOptionPane.showMessageDialog(null , "Bitte geben Sie eine Zahl ein!");
				             tfAnzahl.requestFocus();
					 }
					 
				    } catch (Exception ex) { // Message wenn kein Integer eingegeben wurde
					JOptionPane.showMessageDialog(null, "Falsche Eingabe!!");
						tfAnzahl.requestFocus();
					        tfAnzahl.selectAll();
				    }
			}
		}
	});
	tfAnzahl.setBounds(309, 8, 63, 20);
	contentPane.add(tfAnzahl);
	tfAnzahl.setColumns(10);
	
//Schritt 1 Eingabe Menge Zahlen
	
	btnEingabeAnzahl = new JButton("OK");
	btnEingabeAnzahl.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
	     try { 
		 if (!tfAnzahl.getText().equals("")) { // testen ob eine Eingabe getätigt wurde
		     i = 1;
		     mengeZahlen = Integer.parseInt(tfAnzahl.getText()); // Eingegebene Menge in Variable speichern
		     zahlenListe = new ArrayList<Integer>();  // Neue ArrayList mit Typ Integer erzeugen
	         // Visibles neu Setzen
		     lblWievieleZahlen.setVisible(false);
		     tfAnzahl.setVisible(false);
		     btnEingabeAnzahl.setVisible(false);
		     lblZahl.setVisible(true);
		     tfZahl.setVisible(true);
		     btnEingabeZahl.setVisible(true);
		     btnNeueEingabe.setVisible(true);
		     tfZahl.setText("");
		     tfZahl.requestFocus();
		 } else { // Message wenn keine Eingabe getätigt wurde
		     JOptionPane.showMessageDialog(null , "Bitte geben Sie eine Zahl ein!");
	             tfAnzahl.requestFocus();
		 }
		 
	    } catch (Exception ex) { // Message wenn kein Integer eingegeben wurde
		JOptionPane.showMessageDialog(null, "Falsche Eingabe!!");
			tfAnzahl.requestFocus();
		        tfAnzahl.selectAll();
	    }
	}
	});
	btnEingabeAnzahl.setBounds(395, 7, 89, 23);
	contentPane.add(btnEingabeAnzahl);
	
	lblZahl = new JLabel("Zahl 1");
	lblZahl.setVisible(false);
	lblZahl.setBounds(10, 54, 63, 14);
	contentPane.add(lblZahl);
	
	tfZahl = new JTextField();
	tfZahl.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				try {
				if (!tfZahl.getText().equals("")) { 
				    zahlenListe.add(Integer.parseInt(tfZahl.getText()));
				    lblZahl.setText("Zahl " + Integer.toString(zahlenListe.size()+1));
				    System.out.println(zahlenListe.toString());
				    if (i == mengeZahlen) {
				    	lblAusgabeVorwaerts.setVisible(true);
				    	lblZahl.setVisible(false);
				    	tfZahl.setVisible(false);
				    	btnEingabeZahl.setVisible(false);
				    	for (int ae : zahlenListe) { // zahlenListe vorwärts ausgeben
				    	lblAusgabeVorwaerts.setText(lblAusgabeVorwaerts.getText() + ae );
				    	}
				    	if ( i == mengeZahlen) {
				    		lblAusgabeRueckwaerts.setVisible(true);
				    		for (int i=zahlenListe.size(); --i >=0;) { // zahlenListe rückwärts ausgeben
				    			lblAusgabeRueckwaerts.setText(lblAusgabeRueckwaerts.getText()
				    					+ zahlenListe.get(i));
				    		}
				    	}
				    } else {
				    	tfZahl.requestFocus();
				    	tfZahl.selectAll();
				    	i++;
				    }
				    
				} else {  // Message wenn keine Eingabe getätigt wurde
				    JOptionPane.showMessageDialog(null , "Bitte geben Sie eine Zahl ein!");
			            tfZahl.requestFocus();
				}
				} catch (Exception ex) { // Message wenn kein Integer eingegeben wurde
					JOptionPane.showMessageDialog(null, "Falsche Eingabe!!");
						tfZahl.requestFocus();
					    tfZahl.selectAll();
				}
			}
		}
	});
	tfZahl.setVisible(false);
	tfZahl.setBounds(10, 69, 86, 20);
	contentPane.add(tfZahl);
	tfZahl.setColumns(10);
	
//Schritt 2 Zahlen Eingeben und verarbeiten	
	
	btnEingabeZahl = new JButton("OK");
	btnEingabeZahl.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    // testen ob eine Eingabe getätigt wurde
			try {
			if (!tfZahl.getText().equals("")) { 
			    zahlenListe.add(Integer.parseInt(tfZahl.getText()));
			    lblZahl.setText("Zahl " + Integer.toString(zahlenListe.size()+1));
			    System.out.println(zahlenListe.toString());
			    if (i == mengeZahlen) {
			    	lblAusgabeVorwaerts.setVisible(true);
			    	lblZahl.setVisible(false);
			    	tfZahl.setVisible(false);
			    	btnEingabeZahl.setVisible(false);
			    	for (int ae : zahlenListe) { // zahlenListe vorwärts ausgeben
			    	lblAusgabeVorwaerts.setText(lblAusgabeVorwaerts.getText() + ae );
			    	}
			    	if ( i == mengeZahlen) {
			    		lblAusgabeRueckwaerts.setVisible(true);
			    		for (int i=zahlenListe.size(); --i >=0;) { // zahlenListe rückwärts ausgeben
			    			lblAusgabeRueckwaerts.setText(lblAusgabeRueckwaerts.getText()
			    					+ zahlenListe.get(i));
			    		}
			    	}
			    } else {
			    	tfZahl.requestFocus();
			    	tfZahl.selectAll();
			    	i++;
			    }
			    
			} else {  // Message wenn keine Eingabe getätigt wurde
			    JOptionPane.showMessageDialog(null , "Bitte geben Sie eine Zahl ein!");
		            tfZahl.requestFocus();
			}
			} catch (Exception ex) { // Message wenn kein Integer eingegeben wurde
				JOptionPane.showMessageDialog(null, "Falsche Eingabe!!");
					tfZahl.requestFocus();
				    tfZahl.selectAll();
				    tfZahl.requestFocus();
			}
		}
});
	btnEingabeZahl.setVisible(false);
	btnEingabeZahl.setBounds(117, 68, 89, 23);
	contentPane.add(btnEingabeZahl);
	
	btnNeueEingabe = new JButton("Neue Eingabe");
	btnNeueEingabe.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			zahlenListe.clear();
			lblAusgabeRueckwaerts.setVisible(false);
			lblAusgabeVorwaerts.setVisible(false);
			tfZahl.setVisible(false);
			lblZahl.setVisible(false);
			lblZahl.setText("Zahl 1");
			lblWievieleZahlen.setVisible(true);
			btnEingabeAnzahl.setVisible(true);
			btnEingabeZahl.setVisible(false);
			tfAnzahl.setVisible(true);
			tfAnzahl.setText("");
			tfAnzahl.requestFocus();
			lblAusgabeRueckwaerts.setText("Ausgabe rückwärts : ");
			lblAusgabeVorwaerts.setText("Ausgabe vorwärts : ");
		}
	});
	btnNeueEingabe.setVisible(false);
	btnNeueEingabe.setBounds(259, 68, 134, 23);
	contentPane.add(btnNeueEingabe);
	
	lblAusgabeVorwaerts = new JLabel("Ausgabe vorw\u00E4rts : ");
	lblAusgabeVorwaerts.setVisible(false);
	lblAusgabeVorwaerts.setBounds(10, 130, 474, 14);
	contentPane.add(lblAusgabeVorwaerts);
	
	lblAusgabeRueckwaerts = new JLabel("Ausgabe r\u00FCckw\u00E4rts : ");
	lblAusgabeRueckwaerts.setVisible(false);
	lblAusgabeRueckwaerts.setBounds(10, 155, 474, 14);
	contentPane.add(lblAusgabeRueckwaerts);
    }

}
