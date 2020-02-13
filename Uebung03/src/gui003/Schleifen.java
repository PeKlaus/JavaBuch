package gui003;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import java.awt.Font;

public class Schleifen extends JFrame {

    private JPanel contentPane;
    private JTextArea textAreaAusgabe1;
    private JTextArea textAreaAusgabe2;
    private JTextArea textAreaAusgabe3;
    private JTextField tfEingabe;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Schleifen frame = new Schleifen();
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
    public Schleifen() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 223, 715);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblZahlZwischen = new JLabel("Zahl zwischen 1 und 100");
	lblZahlZwischen.setHorizontalAlignment(SwingConstants.CENTER);
	lblZahlZwischen.setHorizontalTextPosition(SwingConstants.CENTER);
	lblZahlZwischen.setBounds(10, 11, 187, 14);
	contentPane.add(lblZahlZwischen);
	
	textAreaAusgabe1 = new JTextArea();
	textAreaAusgabe1.setFont(new Font("Monospaced", Font.BOLD, 10));
	textAreaAusgabe1.setBounds(21, 65, 48, 601);
	contentPane.add(textAreaAusgabe1);
	
	textAreaAusgabe2 = new JTextArea();
	textAreaAusgabe2.setFont(new Font("Monospaced", Font.BOLD, 10));
	textAreaAusgabe2.setBounds(79, 65, 48, 601);
	contentPane.add(textAreaAusgabe2);
	
	textAreaAusgabe3 = new JTextArea();
	textAreaAusgabe3.setFont(new Font("Monospaced", Font.BOLD, 10));
	textAreaAusgabe3.setBounds(138, 65, 48, 601);
	contentPane.add(textAreaAusgabe3);
	
	tfEingabe = new JTextField();
	tfEingabe.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			textAreaAusgabe1.setText("");
			textAreaAusgabe2.setText("");
			textAreaAusgabe3.setText("");
			Whileschleife();
		    }		    
		}
	});
	tfEingabe.setBounds(41, 34, 121, 20);
	contentPane.add(tfEingabe);
	tfEingabe.setColumns(10);
    }
    
    private void Whileschleife() {
	try {
	int zahl = Integer.parseInt(tfEingabe.getText());
	while (zahl < 36) {
	    textAreaAusgabe1.append(""+zahl + "\n");
	    zahl++;
	}
	    while (zahl < 70) {
		    textAreaAusgabe2.append(""+zahl + "\n");
		    zahl++;
	    }
		    while (zahl < 101) {
			    textAreaAusgabe3.append(""+zahl + "\n");
			    zahl++;
		    }
		    tfEingabe.requestFocus();
		    tfEingabe.selectAll();
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, "Fehler! falsche Eingabe  /" + e.getMessage());
	}
    }
    
    private void Doschleife() {
	try {
	int zahl = Integer.parseInt(tfEingabe.getText());
	do { 
	    textAreaAusgabe1.append(""+zahl + "\n");
	    zahl++;
	} while (zahl < 36);
	do {
	    textAreaAusgabe2.append(""+zahl + "\n");
	    zahl++;
	} while (zahl < 70);
	do {
	    textAreaAusgabe3.append(""+zahl + "\n");
	    zahl++;
	} while (zahl < 101);
	tfEingabe.requestFocus();
	tfEingabe.selectAll();
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, "Fehler! falsche Eingabe  /" + e.getMessage());
	}
    }
    
    private void Forschleife() {
	try {
	for (int zahl = Integer.parseInt(tfEingabe.getText()) ; zahl < 101; zahl++) {
	    textAreaAusgabe1.append("" + zahl);
	}
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, "Fehler! falsche Eingabe  /" + e.getMessage());
	}
    }
}

