package gui9;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Uhrzeit extends JFrame {

    private JPanel contentPane;
    private JTextField tfStunden;
    private JTextField tfMinuten;
    private JLabel lblAusgabe;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Uhrzeit frame = new Uhrzeit();
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
    public Uhrzeit() {
    	setTitle("Uhrzeit");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 403, 217);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblStunden = new JLabel("Stunden");
	lblStunden.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblStunden.setBounds(28, 23, 63, 14);
	contentPane.add(lblStunden);
	
	JLabel lblMinuten = new JLabel("Minuten");
	lblMinuten.setFont(new Font("Tahoma", Font.BOLD, 11));
	lblMinuten.setBounds(120, 23, 63, 14);
	contentPane.add(lblMinuten);
	
	tfStunden = new JTextField();
	tfStunden.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			tfMinuten.requestFocus();
			tfMinuten.selectAll();
		    }
		}
	});
	tfStunden.setBounds(28, 42, 60, 20);
	contentPane.add(tfStunden);
	tfStunden.setColumns(10);
	
	tfMinuten = new JTextField();
	tfMinuten.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			Eingaben();
		    }
		}
	});
	tfMinuten.setBounds(120, 42, 60, 20);
	contentPane.add(tfMinuten);
	tfMinuten.setColumns(10);
	
	JButton btnbernehmen = new JButton("\u00DCbernehmen");
	btnbernehmen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    Eingaben();
		}
	});
	btnbernehmen.setBounds(226, 41, 137, 23);
	contentPane.add(btnbernehmen);
	
	lblAusgabe = new JLabel("");
	lblAusgabe.setBounds(27, 75, 336, 20);
	contentPane.add(lblAusgabe);
	
	JButton btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	});
	btnEnde.setBounds(274, 125, 89, 23);
	contentPane.add(btnEnde);
    }
    
    private void Eingaben() {
	int st, min;
	try {
	st = Integer.parseInt(tfStunden.getText());
	min = Integer.parseInt(tfMinuten.getText());
	    if (st>23)
		throw new EigeneEingabeException("Falsche Stundenzahl (0 - 23)");
	    if (st<0)
		throw new EigeneEingabeException("Falsch Stundenzahl (kleiner 0!)");
	    if (min>59)
		throw new EigeneEingabeException("Falsche Minutenzahl (0 - 59)");
	    if (min<0)
		throw new EigeneEingabeException("Falsche Minutenzahl (klainer 0!)");
	    lblAusgabe.setText("Ihre Uhrzeit ist " + st + ":" + min + " Uhr!");
	    tfStunden.requestFocus();
	    tfStunden.selectAll();
	}
	catch (EigeneEingabeException e) {
	    lblAusgabe.setText(e.getMessage());
	    tfStunden.requestFocus();
	    tfStunden.selectAll();
	}
	   catch (NumberFormatException e) {
	      lblAusgabe.setText("Falsche Eingabe / " + e.getMessage());
	      tfStunden.requestFocus();
	      tfStunden.selectAll();
	}
    }
}
