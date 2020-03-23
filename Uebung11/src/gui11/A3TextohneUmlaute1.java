package gui11;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class A3TextohneUmlaute1 extends JFrame {

	private JPanel contentPane;
	private String dateiname = "." + File.separator + "Textdatei.txt";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A3TextohneUmlaute1 frame = new A3TextohneUmlaute1();
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
	public A3TextohneUmlaute1() {
		setTitle("A1 Text ohne Umlaute");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow,center][right][][][][][][]", "[grow][][][][][][][]"));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 0,grow");
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		
		JButton btnOeffnen = new JButton("\u00D6ffnen");
		btnOeffnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				fc.setFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
				fc.setCurrentDirectory(new File("."));
				int status = fc.showOpenDialog(null);
				BufferedReader in = null;
				if (status == JFileChooser.APPROVE_OPTION) {
				    dateiname = fc.getSelectedFile().getAbsolutePath();
				    try {
					in = new BufferedReader(new FileReader(dateiname));
					int c;
					StringBuffer zeile = new StringBuffer();
					while ((c = in.read()) >= 0) {
					    zeile.append((char) c);
					}
					textPane.setText(zeile.toString());

				    } catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Fehler beim Lesen!");
				    } finally {
					if (in != null) {
					    try {
						in.close();
					    } catch (IOException ex) {
						ex.printStackTrace();
					    }
					}
				    }
				}
			}
		});
			
		contentPane.add(btnOeffnen, "flowx,cell 0 1");
		
		JButton btnSpeichern = new JButton("speichern...");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try (OhneUmlautWriter out = new OhneUmlautWriter(new FileWriter(dateiname))) {
					out.write(textPane.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Fehler beim Speichern");
				}
				textPane.requestFocus();
				JOptionPane.showMessageDialog(null, "Speichern erfolgreich!!");
			}
		});
		contentPane.add(btnSpeichern, "cell 0 1");
	}

}
