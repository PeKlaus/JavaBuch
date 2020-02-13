package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class Einkauf extends JFrame {

    private JPanel contentPane;
    private JTextField tfStzahl;
    private JTextField tfStpreis;
    private JTextField tfRabatt;
    private JLabel lblAusgabe;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Einkauf frame = new Einkauf();
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
    public Einkauf() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 534, 186);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblStueckzahl = new JLabel("St\u00FCckzahl");
	lblStueckzahl.setBounds(33, 21, 100, 14);
	contentPane.add(lblStueckzahl);
	
	JLabel lblStueckpreis = new JLabel("St\u00FCckpreis");
	lblStueckpreis.setBounds(143, 21, 100, 14);
	contentPane.add(lblStueckpreis);
	
	JLabel lblRabatt = new JLabel("Rabatt(%)");
	lblRabatt.setBounds(253, 21, 100, 14);
	contentPane.add(lblRabatt);
	
	tfStzahl = new JTextField();
	tfStzahl.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfStzahl.addKeyListener(new KeyAdapter() {
			    @Override
			    public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				    tfStpreis.requestFocus();
				    tfStpreis.selectAll();
				}
			    }
			});
		}
	});
	tfStzahl.setBounds(33, 36, 100, 20);
	contentPane.add(tfStzahl);
	tfStzahl.setColumns(10);
	
	tfStpreis = new JTextField();
	tfStpreis.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		    tfRabatt.requestFocus();
		    tfRabatt.selectAll();
		}
	    }
	});
	tfStpreis.setBounds(143, 36, 100, 20);
	contentPane.add(tfStpreis);
	tfStpreis.setColumns(10);
	
	tfRabatt = new JTextField();
	tfRabatt.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		    Berechnen();
		}
	    }
	});
	tfRabatt.setBounds(253, 36, 100, 20);
	contentPane.add(tfRabatt);
	tfRabatt.setColumns(10);
	
	JButton btnBerechnen = new JButton("Berechnen");
	btnBerechnen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    Berechnen();
		}
	});
	btnBerechnen.setBounds(393, 35, 100, 23);
	contentPane.add(btnBerechnen);

	
	JButton btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	});
	btnEnde.setBounds(425, 94, 68, 23);
	contentPane.add(btnEnde);
	
	lblAusgabe = new JLabel("");
	lblAusgabe.setBounds(33, 67, 320, 50);
	contentPane.add(lblAusgabe);
    }
    
    private void Berechnen() {
	int stueckzahl;
	double stueckpreis, rabattsatz, bruttopreis, rabatt, einkaufspreis;
	try {
	    if (tfStzahl.getText().equals("")) 
		throw new LeereEingabeException("Bitte geben Sie eine Stückzahl an.");
	    if (tfStpreis.getText().equals("")) 
		throw new LeereEingabeException("Bitte geben Sie einen Stückpreis an.");
	    if (tfRabatt.getText().equals("")) 
		throw new LeereEingabeException("Bitte geben Sie einen Rabattsatz an.");
	    stueckzahl = Integer.parseInt(tfStzahl.getText());
	    stueckpreis = Double.parseDouble(tfStpreis.getText());
	    rabattsatz = Double.parseDouble(tfRabatt.getText());
	    bruttopreis = stueckzahl * stueckpreis;
	    rabatt = bruttopreis * rabattsatz / 100;
	    einkaufspreis = bruttopreis - rabatt;
	    DecimalFormat f = new DecimalFormat("#0.00");
	    lblAusgabe.setText("Der Einkaufspreis beträgt " + f.format(einkaufspreis) + " €");
	    tfStzahl.requestFocus();
	    tfStzahl.selectAll();
	}
	catch (LeereEingabeException e) {
	    JOptionPane.showMessageDialog(null, e.getMessage());
	}
	   catch (NumberFormatException e) {
	      lblAusgabe.setText("Falsches Zeichenformat / " + e.getMessage());
	}
	   catch (Exception e) {
	      lblAusgabe.setText("Fehler!");
	}
    }
    
}
	

	/*if (tfStzahl.getText().equals("") || tfStpreis.equals("")
		|| tfRabatt.equals("")) {
	    lblAusgabe.setText("Die Eingaben sind unvollständig!");
	} else {
	    stueckzahl = Integer.parseInt(tfStzahl.getText());
	    stueckpreis = Double.parseDouble(tfStpreis.getText());
	    rabattsatz = Double.parseDouble(tfRabatt.getText());
	    bruttopreis = stueckzahl * stueckpreis;
	    rabatt = bruttopreis * rabattsatz / 100;
	    einkaufspreis = bruttopreis - rabatt;
	    DecimalFormat f = new DecimalFormat("#0.00");
	    lblAusgabe.setText("Der Einkaufspreis beträgt " + f.format(einkaufspreis) + " €");
	}
	tfStzahl.requestFocus();
	tfStzahl.selectAll();
   } */

