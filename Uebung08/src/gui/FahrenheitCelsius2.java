package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FahrenheitCelsius2 extends JFrame {

    private JPanel contentPane;
    private JTextField tfFahrenheit;
    private JTextField tfCelsius;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    	try {
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    	} catch (Throwable e) {
    		e.printStackTrace();
    	}
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    FahrenheitCelsius2 frame = new FahrenheitCelsius2();
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
    public FahrenheitCelsius2() {
    	setTitle("Umrechnung Fahrenheit Celsius");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 327, 208);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	// Beschriftung (Grad Fahrenheit)
	JLabel lblFahrenheit = new JLabel("Grad Fahrenheit");
	lblFahrenheit.setBounds(10, 11, 114, 14);
	contentPane.add(lblFahrenheit);
	
	// Textfeld Fahrenheit
	tfFahrenheit = new JTextField();
	tfFahrenheit.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			umrechnen();
		    }
		}
	});
	tfFahrenheit.setBounds(10, 36, 114, 20);
	contentPane.add(tfFahrenheit);
	tfFahrenheit.setColumns(10);
	
	// Beschriftung (Grad Celsius)
	JLabel lblCelsius = new JLabel("Grad Celsius");
	lblCelsius.setBounds(10, 78, 114, 14);
	contentPane.add(lblCelsius);
	
	// Textfeld Celsius
	tfCelsius = new JTextField();
	tfCelsius.setEditable(false);         //nicht editierbar weil wir es als Ergebnissausgabe verwenden
	tfCelsius.setBounds(10, 103, 284, 20);
	contentPane.add(tfCelsius);
	tfCelsius.setColumns(10);
	
	// Button Umrechnen        
	JButton btnUmrechnen = new JButton("Umrechnen");
	      //Action Listener des Buttons btnUmrechnen
	btnUmrechnen.addActionListener(new ActionListener() {    
		public void actionPerformed(ActionEvent e) { 
		    System.out.println("Button Umrechnen wurde betätigt!");  // Controlle auf der Console
		    // Berechnung
		    umrechnen();
		}
	});
	btnUmrechnen.setBounds(180, 35, 114, 23);
	contentPane.add(btnUmrechnen);
	
	// Button Ende
	JButton btnEnde = new JButton("Ende");
	      //Action Listener des Buttons btnEnde
	btnEnde.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.out.println("Button Ende wurde betätigt!"); // Controlle auf der Console
		    System.exit(0);  // Beendet das Programm / (0) gibt an welcher exit Punkt das Programm beendet hat (1 2 3 4 usw.)
		}
	});
	btnEnde.setBounds(180, 136, 114, 23);
	contentPane.add(btnEnde);
	
    }
           // Eigene Methode umrechnen
    private void umrechnen() {
	double fahrenheit, celsius; //lokale Variablen
	try {
	    fahrenheit = Double.parseDouble(tfFahrenheit.getText()); // variable fahrenheit holt sich die eingabe aus dem Textfeld tfFahrenheit
	    celsius = (fahrenheit - 32) * 5 / 9; // Berechnung
	    System.out.println(celsius); // Kontrolle auf der Console
	    tfCelsius.setText(String.valueOf(celsius)); // wandelt den double wert celsius in ein String um und setzt den text für tfCelsius
	    DecimalFormat f = new DecimalFormat("#0.00"); // erzeugt ein neues Objekt DecimalFormat f (mit Parametern)
	    tfCelsius.setText(f.format(celsius)); // Objekt f.format wendet die parameter auf celsius an
	    tfFahrenheit.requestFocus();  // Fokus anfordern 
	    tfFahrenheit.selectAll();   //markiert das tfFahrenheit
	} 
	catch (NumberFormatException e) {
	    tfCelsius.setText("Keine korrekte Fahrenheit-Temperatur");
	}
    }

}
