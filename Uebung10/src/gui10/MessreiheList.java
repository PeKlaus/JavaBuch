package gui10;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

public class MessreiheList extends JFrame {

	private JPanel contentPane;
	private JTextField tfMesswert;
	private JTextField tfMessbear;
	private JTextField tfWertbear;
	private JLabel lblMesswert;
	private JButton btnMesswert;
	private JLabel lblMessAusgabe;
	private JButton btnMessbear;
	private JButton btnWertspeichern;
	private JButton btnWertlöschen;
	private JButton btnMessreiheAuswerten;
	private JLabel lblMaxwert;
	private JLabel lblMinwert;
	private JLabel lblMittelwert;
	private int messwertnr;
	private ArrayList<Double> messwerte;
	private double summe, maximalwert, minimalwert, mittelwert; 
    private DecimalFormat fzahl;
    private JLabel lblWertbear;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessreiheList frame = new MessreiheList();
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
	public MessreiheList() {
		setTitle("Messreihe List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fzahl = new DecimalFormat("###,##0.000");
		setBounds(100, 100, 382, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		messwerte = new ArrayList<Double>(); // erzeugt neue Liste Messwerte mit Double Werten
		
		lblMesswert = new JLabel("1. Messwert:");
		lblMesswert.setBounds(10, 21, 104, 14);
		contentPane.add(lblMesswert);
		
		tfMesswert = new JTextField();
		tfMesswert.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						
						if (!tfMesswert.getText().equals("")) { // testen ob eine Eingabe getätigt wurde
							messwerte.add(Double.parseDouble(tfMesswert.getText())); //eingegebenen Messwert der ArrayList hinzufügen
							lblMessAusgabe.setText(messwerte.toString()); // gibt die ArrayList als String in lblMessAusgabe aus
							lblMesswert.setText(Integer.toString(messwerte.size() + 1) + ". Messwert"); // gibt im lblMesswert die Nr. der position in der arrayList an
							tfMesswert.requestFocus();
							tfMesswert.setText("");
						} else { // Message wenn keine Eingabe getätigt wurde
						     JOptionPane.showMessageDialog(null , "Bitte geben Sie eine Zahl ein!");
				             tfMesswert.requestFocus();
				             tfMesswert.selectAll();
					 }					
				} catch (Exception ex) { // Message wenn keine Zahl eingegeben wurde
					JOptionPane.showMessageDialog(null, "Falsche Eingabe!!");
					tfMesswert.requestFocus();
				    tfMesswert.selectAll();
				}
				}
			}
		});
		tfMesswert.setBounds(10, 35, 86, 20);
		contentPane.add(tfMesswert);
		tfMesswert.setColumns(10);
		
		btnMesswert = new JButton("OK");
		btnMesswert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if (!tfMesswert.getText().equals("")) { // testen ob eine Eingabe getätigt wurde
						messwerte.add(Double.parseDouble(tfMesswert.getText())); //eingegebenen Messwert der ArrayList hinzufügen
						lblMessAusgabe.setText(messwerte.toString()); // gibt die ArrayList als String in lblMessAusgabe aus
						lblMesswert.setText(Integer.toString(messwerte.size() + 1) + ". Messwert"); // gibt im lblMesswert die Nr. der position in der arrayList an
						tfMesswert.requestFocus();
						tfMesswert.setText("");
					} else { // Message wenn keine Eingabe getätigt wurde
					     JOptionPane.showMessageDialog(null , "Bitte geben Sie eine Zahl ein!");
			             tfMesswert.requestFocus();
			             tfMesswert.selectAll();
				 }					
			} catch (Exception ex) { // Message wenn keine Zahl eingegeben wurde
				JOptionPane.showMessageDialog(null, "Falsche Eingabe!!");
				tfMesswert.requestFocus();
			    tfMesswert.selectAll();
			}
				} 
				
		});
		btnMesswert.setBounds(124, 34, 89, 23);
		contentPane.add(btnMesswert);
		
		JLabel lblMesswerte = new JLabel("Messwerte: ");
		lblMesswerte.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMesswerte.setBounds(10, 66, 333, 32);
		contentPane.add(lblMesswerte);
		
		tfMessbear = new JTextField();
		tfMessbear.setBounds(10, 146, 86, 20);
		contentPane.add(tfMessbear);
		tfMessbear.setColumns(10);
		
		JLabel lblMessbear = new JLabel(". Messwert");
		lblMessbear.setBounds(100, 149, 80, 14);
		contentPane.add(lblMessbear);
		
		btnMessbear = new JButton("bearbeiten");
		btnMessbear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					messwertnr = Integer.parseInt(tfMessbear.getText()) - 1;
					tfWertbear.setVisible(true);
					lblWertbear.setVisible(true);
					btnWertspeichern.setVisible(true);
					btnWertlöschen.setVisible(true);	
				    tfWertbear.requestFocus();
				    tfWertbear.setText(String.valueOf(messwerte.get(messwertnr)));
				    tfWertbear.selectAll();
								
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "keine Gültige Nr. !");
					tfMessbear.requestFocus();
					tfMessbear.selectAll();
				}
				
			}
		});
		btnMessbear.setBounds(176, 145, 152, 23);
		contentPane.add(btnMessbear);
		
		lblWertbear = new JLabel("Wert");
		lblWertbear.setVisible(false);
		lblWertbear.setBounds(10, 190, 46, 14);
		contentPane.add(lblWertbear);
		
		tfWertbear = new JTextField();
		tfWertbear.setVisible(false);
		tfWertbear.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						messwerte.set(messwertnr, Double.parseDouble(tfWertbear.getText()));
						lblMessAusgabe.setText(messwerte.toString());
						tfWertbear.setText("");
						tfMessbear.requestFocus();
						tfMessbear.selectAll();
						tfWertbear.setVisible(false);
						lblWertbear.setVisible(false);
						btnWertspeichern.setVisible(false);
						btnWertlöschen.setVisible(false);
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(null, "kein Gültiger Wert !"); 
						}
				}
			}
		});
		tfWertbear.setBounds(10, 204, 86, 20);
		contentPane.add(tfWertbear);
		tfWertbear.setColumns(10);
		
		btnWertspeichern = new JButton("speichern");
		btnWertspeichern.setVisible(false);
		btnWertspeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				messwerte.set(messwertnr, Double.parseDouble(tfWertbear.getText()));
				lblMessAusgabe.setText(messwerte.toString());
				tfWertbear.setText("");
				tfMessbear.requestFocus();
				tfMessbear.selectAll();
				tfWertbear.setVisible(false);
				lblWertbear.setVisible(false);
				btnWertspeichern.setVisible(false);
				btnWertlöschen.setVisible(false);
				
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "kein Gültiger Wert !"); 
				}
			}
		});
		btnWertspeichern.setBounds(124, 203, 104, 23);
		contentPane.add(btnWertspeichern);
		
		btnWertlöschen = new JButton("l\u00F6schen");
		btnWertlöschen.setVisible(false);
		btnWertlöschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					messwerte.remove(messwertnr);
					lblMessAusgabe.setText(messwerte.toString());
					lblMesswert.setText(Integer.toString(messwerte.size() +1) + ". Messwert");
					tfWertbear.setText("");
					tfMessbear.requestFocus();
					tfMessbear.selectAll();
					tfWertbear.setVisible(false);
					lblWertbear.setVisible(false);
					btnWertspeichern.setVisible(false);
					btnWertlöschen.setVisible(false);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "keine Gültige Nr. !");
				}
			}
		});
		btnWertlöschen.setBounds(239, 203, 104, 23);
		contentPane.add(btnWertlöschen);
		
		btnMessreiheAuswerten = new JButton("Messreihe auswerten");
		btnMessreiheAuswerten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Auswerten();
			}
		});
		btnMessreiheAuswerten.setBounds(10, 252, 318, 23);
		contentPane.add(btnMessreiheAuswerten);
		
		lblMaxwert = new JLabel("Maximalwert : ");
		lblMaxwert.setVisible(false);
		lblMaxwert.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaxwert.setBounds(10, 299, 203, 14);
		contentPane.add(lblMaxwert);
		
		lblMinwert = new JLabel("Minimalwert  :");
		lblMinwert.setVisible(false);
		lblMinwert.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMinwert.setBounds(10, 346, 203, 14);
		contentPane.add(lblMinwert);
		
		lblMittelwert = new JLabel("Mittelwert     :");
		lblMittelwert.setVisible(false);
		lblMittelwert.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMittelwert.setBounds(10, 324, 203, 14);
		contentPane.add(lblMittelwert);
		
		lblMessAusgabe = new JLabel("");
		lblMessAusgabe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMessAusgabe.setBounds(10, 98, 333, 23);
		contentPane.add(lblMessAusgabe);
	}
	private void Auswerten() {
		lblMaxwert.setVisible(true);
		lblMinwert.setVisible(true);
		lblMittelwert.setVisible(true);
		
		summe = 0;
		minimalwert = messwerte.size();
		maximalwert = messwerte.size();
		for (double mw : messwerte) {
		    if (minimalwert > mw) {
			minimalwert = mw;
		    }
		    if (maximalwert < mw) {
			maximalwert = mw;
		    }
		    summe = summe + mw;
		}
		mittelwert = summe / messwerte.size();
		lblMinwert.setText("Minimalwert: " + String.valueOf(minimalwert));
		lblMaxwert.setText("Maximalwert: " + String.valueOf(maximalwert));
		lblMittelwert.setText("Mittelwert: " + String.valueOf(fzahl.format(mittelwert)));
	    }
}
