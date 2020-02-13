package gui10;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.JFormattedTextField;

public class MessreiheListFrame extends JFrame {

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
	private JLabel lblMax;
	private JLabel lblMinimalwert;
	private JLabel lblMittelwert;

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
	public MessreiheListFrame() {
		setTitle("Messreihe List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblMesswert = new JLabel("1. Messwert:");
		lblMesswert.setBounds(10, 21, 104, 14);
		contentPane.add(lblMesswert);
		
		tfMesswert = new JTextField();
		tfMesswert.setBounds(10, 35, 86, 20);
		contentPane.add(tfMesswert);
		tfMesswert.setColumns(10);
		
		btnMesswert = new JButton("OK");
		btnMesswert.setBounds(124, 34, 89, 23);
		contentPane.add(btnMesswert);
		
		JLabel lblMesswerte = new JLabel("Messwerte: ");
		lblMesswerte.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMesswerte.setBounds(10, 66, 486, 32);
		contentPane.add(lblMesswerte);
		
		tfMessbear = new JTextField();
		tfMessbear.setBounds(10, 146, 86, 20);
		contentPane.add(tfMessbear);
		tfMessbear.setColumns(10);
		
		JLabel lblMessbear = new JLabel(". Messwert");
		lblMessbear.setBounds(100, 149, 80, 14);
		contentPane.add(lblMessbear);
		
		btnMessbear = new JButton("bearbeiten");
		btnMessbear.setBounds(176, 145, 152, 23);
		contentPane.add(btnMessbear);
		
		JLabel lblWertbear = new JLabel("Wert");
		lblWertbear.setBounds(10, 190, 46, 14);
		contentPane.add(lblWertbear);
		
		tfWertbear = new JTextField();
		tfWertbear.setBounds(10, 204, 86, 20);
		contentPane.add(tfWertbear);
		tfWertbear.setColumns(10);
		
		btnWertspeichern = new JButton("speichern");
		btnWertspeichern.setBounds(124, 203, 104, 23);
		contentPane.add(btnWertspeichern);
		
		btnWertlöschen = new JButton("l\u00F6schen");
		btnWertlöschen.setBounds(239, 203, 104, 23);
		contentPane.add(btnWertlöschen);
		
		btnMessreiheAuswerten = new JButton("Messreihe auswerten");
		btnMessreiheAuswerten.setBounds(10, 252, 318, 23);
		contentPane.add(btnMessreiheAuswerten);
		
		lblMax = new JLabel("Maximalwert : ");
		lblMax.setVisible(false);
		lblMax.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMax.setBounds(10, 299, 170, 14);
		contentPane.add(lblMax);
		
		lblMinimalwert = new JLabel("Minimalwert  :");
		lblMinimalwert.setVisible(false);
		lblMinimalwert.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMinimalwert.setBounds(10, 324, 170, 14);
		contentPane.add(lblMinimalwert);
		
		lblMittelwert = new JLabel("Mittelwert     :");
		lblMittelwert.setVisible(false);
		lblMittelwert.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMittelwert.setBounds(10, 349, 170, 14);
		contentPane.add(lblMittelwert);
		
		lblMessAusgabe = new JLabel("");
		lblMessAusgabe.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMessAusgabe.setBounds(10, 98, 486, 23);
		contentPane.add(lblMessAusgabe);
	}
}

