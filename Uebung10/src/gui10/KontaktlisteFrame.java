package gui10;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.List;
import javax.swing.JScrollBar;
import java.awt.Scrollbar;

public class KontaktlisteFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfNachname;
	private JTextField tfVorname;
	private JTextField tfTelefon;
	private JTextField tfEMail;
	private JButton btnEnde;
	private JButton btnUebernehmen;
	private JButton btnloeschen;
	private JButton btnBearbeiten;
	private List list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KontaktlisteFrame frame = new KontaktlisteFrame();
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
	public KontaktlisteFrame() {
		setTitle("Kontaktliste");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNachname = new JLabel("Nachname");
		lblNachname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNachname.setBounds(10, 11, 120, 14);
		contentPane.add(lblNachname);
		
		tfNachname = new JTextField();
		tfNachname.setBounds(10, 34, 150, 20);
		contentPane.add(tfNachname);
		tfNachname.setColumns(10);
		
		JLabel lblVorname = new JLabel("Vorname");
		lblVorname.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblVorname.setBounds(170, 11, 120, 14);
		contentPane.add(lblVorname);
		
		tfVorname = new JTextField();
		tfVorname.setBounds(170, 34, 150, 20);
		contentPane.add(tfVorname);
		tfVorname.setColumns(10);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefon.setBounds(330, 11, 170, 14);
		contentPane.add(lblTelefon);
		
		tfTelefon = new JTextField();
		tfTelefon.setBounds(330, 34, 200, 20);
		contentPane.add(tfTelefon);
		tfTelefon.setColumns(10);
		
		JLabel lblEmail = new JLabel("EMail");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(10, 65, 48, 14);
		contentPane.add(lblEmail);
		
		tfEMail = new JTextField();
		tfEMail.setBounds(10, 90, 310, 20);
		contentPane.add(tfEMail);
		tfEMail.setColumns(10);
		
		btnUebernehmen = new JButton("\u00DCbernehmen >>");
		btnUebernehmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.add(tfNachname.getText() + " ; " + tfVorname.getText() + " ; " 
			    + tfTelefon.getText() +" ; " + tfEMail.getText());
			}
		});
		btnUebernehmen.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUebernehmen.setBounds(351, 89, 149, 23);
		contentPane.add(btnUebernehmen);
		
		JLabel lblKontaktliste = new JLabel("Kontaktliste");
		lblKontaktliste.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKontaktliste.setBounds(10, 137, 150, 14);
		contentPane.add(lblKontaktliste);
		
		btnEnde = new JButton("Ende");
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEnde.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEnde.setBounds(596, 473, 89, 23);
		contentPane.add(btnEnde);
		
		btnloeschen = new JButton("Eintrag l\u00F6schen");
		btnloeschen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String l = list.getSelectedItem() ;
				list.remove(l);
			}
		});
		btnloeschen.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnloeschen.setBounds(10, 475, 200, 23);
		contentPane.add(btnloeschen);
		
		btnBearbeiten = new JButton("bearbeiten");
		btnBearbeiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bear = list.getSelectedItem();
				String[] kp = bear.split(";");  // kp = Kontaktparameter
				list.remove(bear);
				tfNachname.setText(kp[0]);
				tfVorname.setText(kp[1]);
				tfTelefon.setText(kp[2]);
				tfEMail.setText(kp[3]);
				
			}
		});
		btnBearbeiten.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBearbeiten.setBounds(247, 475, 200, 23);
		contentPane.add(btnBearbeiten);
		
		list = new List();
		list.setFont(new Font("Dialog", Font.BOLD, 12));
		list.setMultipleSelections(false);
		list.setBounds(10, 157, 675, 310);
		contentPane.add(list);
		
		Scrollbar scrollbar = new Scrollbar();
		scrollbar.setBounds(668, 157, 17, 310);
		contentPane.add(scrollbar);
	}
}
