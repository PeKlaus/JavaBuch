package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.format.DecimalStyle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FahrenheitCelsius extends JFrame {

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
		    FahrenheitCelsius frame = new FahrenheitCelsius();
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
    public FahrenheitCelsius() {
	setTitle("Umrechnung Fahrenheit in Celsius");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblFahrenheit = new JLabel("Grad Fahrenheit");
	lblFahrenheit.setBounds(10, 0, 144, 22);
	contentPane.add(lblFahrenheit);
	
	tfFahrenheit = new JTextField();
	tfFahrenheit.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			umrechnen();
			/*double fahrenheit, celsius;
			fahrenheit = Double.parseDouble(tfFahrenheit.getText());
			celsius = (fahrenheit - 32) * 5 / 9;
			DecimalFormat f = new DecimalFormat("#0.00");
			    tfCelsius.setText(f.format(celsius));
			    tfFahrenheit.requestFocus();
			    tfFahrenheit.selectAll();
			    */
		    }
		}
	});
	tfFahrenheit.setBounds(10, 33, 144, 20);
	contentPane.add(tfFahrenheit);
	tfFahrenheit.setColumns(10);
	
	JLabel lblCelsius = new JLabel("Celsius");
	lblCelsius.setBounds(10, 58, 144, 14);
	contentPane.add(lblCelsius);
	
	tfCelsius = new JTextField();
	tfCelsius.setEditable(false);
	tfCelsius.setBounds(10, 83, 144, 20);
	contentPane.add(tfCelsius);
	tfCelsius.setColumns(10);
	
	
	JButton btnUmrechnen = new JButton("Umrechnen");
	btnUmrechnen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    umrechnen();
		   // System.out.println("Der Schalter Umrechnen wurde betätigt");
		/*    double fahrenheit, celsius;
		    fahrenheit = Double.parseDouble(tfFahrenheit.getText());
		    celsius = (fahrenheit - 32) * 5 / 9;    
		    tfCelsius.setText(String.valueOf(celsius));
		    DecimalFormat f = new DecimalFormat("#0.00");
		    tfCelsius.setText(f.format(celsius));
		    tfFahrenheit.requestFocus();
		    tfFahrenheit.selectAll();
		 */   
		}
	});
	btnUmrechnen.setBounds(199, 30, 130, 23);
	contentPane.add(btnUmrechnen);
	
	JButton btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	});
	btnEnde.setBounds(199, 82, 130, 23);
	contentPane.add(btnEnde);
    }
    
    private void umrechnen() {
	double fahrenheit, celsius;
	    fahrenheit = Double.parseDouble(tfFahrenheit.getText());
	    celsius = (fahrenheit - 32) * 5 / 9;    
	    tfCelsius.setText(String.valueOf(celsius));
	    DecimalFormat f = new DecimalFormat("#0.00");
	    tfCelsius.setText(f.format(celsius));
	    tfFahrenheit.requestFocus();
	    tfFahrenheit.selectAll();
    }
}
