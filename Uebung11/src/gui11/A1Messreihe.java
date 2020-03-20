package gui11;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.ScrollPane;
import java.awt.List;
import java.awt.Scrollbar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class A1Messreihe extends JFrame {

	private JPanel contentPane;
	private JTextField tfMesswert;
	private DefaultListModel<String> MesswertModel;
	private String dateiname = "." + File.separator + ".mwd";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A1Messreihe frame = new A1Messreihe();
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
	public A1Messreihe() {
		setTitle("Messreihe speichern");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 288);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		File datei = new File(dateiname);
		
		
		JLabel lblMesswert = new JLabel("Messwert");
		lblMesswert.setBounds(10, 11, 127, 14);
		contentPane.add(lblMesswert);
		
		tfMesswert = new JTextField();
		tfMesswert.setBounds(10, 27, 127, 20);
		contentPane.add(tfMesswert);
		tfMesswert.setColumns(10);
		
		JButton btnUebernehmen = new JButton("\u00DCbernehmen >>");
		btnUebernehmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    if (tfMesswert.getText().isEmpty()) {
				    JOptionPane.showMessageDialog(null, "Kein Messwert angegeben.");
				    tfMesswert.requestFocus();
				} else {
				    MesswertModel.addElement(tfMesswert.getText());
				    tfMesswert.requestFocus();
				}
			}
		});
		btnUebernehmen.setBounds(10, 58, 127, 23);
		contentPane.add(btnUebernehmen);
		
		JLabel lblMessreihe = new JLabel("Messreihe");
		lblMessreihe.setBounds(180, 11, 225, 14);
		contentPane.add(lblMessreihe);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 27, 225, 168);
		contentPane.add(scrollPane);
		
		JList listMesswerte = new JList();
		scrollPane.setViewportView(listMesswerte);
		
		JButton btnMspeichern = new JButton("Messreihe speichern");
		btnMspeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (BufferedWriter out = new BufferedWriter(new FileWriter(datei))) {
					for (int i = 0; i < MesswertModel.getSize(); i ++) {
						out.write(MesswertModel.get(i).toString());
						out.newLine();
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnMspeichern.setBounds(180, 207, 225, 23);
		contentPane.add(btnMspeichern);
		
		MesswertModel = new DefaultListModel<String>();
		listMesswerte.setModel(MesswertModel);
			
	}
}
