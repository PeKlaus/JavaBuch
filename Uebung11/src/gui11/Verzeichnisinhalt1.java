package gui11;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFileChooser;

public class Verzeichnisinhalt1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfVerzeichnis;
	private File verzeichnis;
	private DefaultListModel<String> verzeichnisseModel, dateienModel;
	private JList<String> listVerzeichnisse;
	private JList<String> listDateien;
	private JButton btnInhaltAnzeigen;
	private JLabel lblVerzeichnisse;
	private JLabel lblDateien;
	private JButton btnEnde;
	private JLabel lblVerzeichnis;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Verzeichnisinhalt1 frame = new Verzeichnisinhalt1();
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
	public Verzeichnisinhalt1() {
		setTitle("Verzeichnisinhalt");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblVerzeichnis = new JLabel("Verzeichnis");
		lblVerzeichnis.setBounds(10, 11, 99, 14);
		contentPane.add(lblVerzeichnis);
		
		tfVerzeichnis = new JTextField();
		tfVerzeichnis.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				    if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				    	Verzeichnissinhaltsanzeige ();
				    }
				}
		});
		tfVerzeichnis.setBounds(10, 28, 414, 20);
		contentPane.add(tfVerzeichnis);
		tfVerzeichnis.setColumns(10);
		
		btnInhaltAnzeigen = new JButton("Inhalt Anzeigen");
		btnInhaltAnzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
   // Methode zum Anzeigen des Verzeichnissinhalts
				verzeichnisseModel.clear();
				dateienModel.clear();
				if (tfVerzeichnis.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Verzeichnisname fehlt!");
				} else {
					verzeichnis = new File(tfVerzeichnis.getText());
					if (verzeichnis.exists() && verzeichnis.isDirectory()) {
					String[] inhalt = verzeichnis.list();
					  for (String eintrag : inhalt) {
						  File f = new File(verzeichnis, eintrag);
						  if (f.isDirectory()) {
							  verzeichnisseModel.addElement(eintrag);
						  } else {
							  dateienModel.addElement(eintrag);
						  }
						  }
				} else {
					JOptionPane.showMessageDialog(null, "Verzeichnis existiert nicht!");
				}
			}
			}
		});
		
		btnInhaltAnzeigen.setBounds(10, 64, 125, 23);
		contentPane.add(btnInhaltAnzeigen);
		
		lblVerzeichnisse = new JLabel("Verzeichnisse");
		lblVerzeichnisse.setBounds(10, 114, 201, 14);
		contentPane.add(lblVerzeichnisse);
		
		lblDateien = new JLabel("Dateien");
		lblDateien.setBounds(221, 114, 201, 14);
		contentPane.add(lblDateien);
		
		btnEnde = new JButton("Ende");
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEnde.setBounds(175, 262, 89, 23);
		contentPane.add(btnEnde);

		// erzeugen der Models zur Aufnahme der Verzeichnis- und Dateieinträge	
		verzeichnisseModel = new DefaultListModel<String>();
		dateienModel = new DefaultListModel<String>();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(221, 139, 203, 112);
		contentPane.add(scrollPane);
		
		listDateien = new JList();
		scrollPane.setViewportView(listDateien);
		listDateien.setModel(dateienModel);
		listDateien.setModel(dateienModel);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 139, 193, 112);
		contentPane.add(scrollPane_1);
		
		listVerzeichnisse = new JList();
		scrollPane_1.setViewportView(listVerzeichnisse);
		listVerzeichnisse.setModel(verzeichnisseModel);
		
		JButton btnAuswaehlen = new JButton("Ausw\u00E4hlen...");
		btnAuswaehlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int status = fc.showOpenDialog(null);
				if (status == JFileChooser.APPROVE_OPTION) {
					File selFile = fc.getSelectedFile();
					tfVerzeichnis.setText(selFile.getPath());
					Verzeichnissinhaltsanzeige ();
				}
			}
		});
		btnAuswaehlen.setBounds(161, 64, 125, 23);
		contentPane.add(btnAuswaehlen);
	}
		
		private void Verzeichnissinhaltsanzeige () {
			verzeichnisseModel.clear();
			dateienModel.clear();
			if (tfVerzeichnis.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Verzeichnisname fehlt!");
			} else {
				verzeichnis = new File(tfVerzeichnis.getText());
				if (verzeichnis.exists() && verzeichnis.isDirectory()) {
				String[] inhalt = verzeichnis.list();
				  for (String eintrag : inhalt) {
					  File f = new File(verzeichnis, eintrag);
					  if (f.isDirectory()) {
						  verzeichnisseModel.addElement(eintrag);
					  } else {
						  dateienModel.addElement(eintrag);
					  }
					  }
			} else {
				JOptionPane.showMessageDialog(null, "Verzeichnis existiert nicht!");
			}
			}
		}
	}

	

		
		
		
		
		
	
