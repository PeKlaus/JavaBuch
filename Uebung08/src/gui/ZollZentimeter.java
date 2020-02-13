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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class ZollZentimeter extends JFrame {

    private JPanel contentPane;
    private JTextField tfZoll;
    private JLabel lblZentimeter;
    private JButton btnUmrechnen;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    ZollZentimeter frame = new ZollZentimeter();
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
    public ZollZentimeter() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 318, 161);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblZoll = new JLabel("Zoll");
	lblZoll.setBounds(10, 0, 100, 25);
	contentPane.add(lblZoll);
	
	tfZoll = new JTextField();
	tfZoll.setBounds(10, 30, 100, 26);
	contentPane.add(tfZoll);
	tfZoll.setColumns(10);
	tfZoll.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			umrechnen();
		    }
		}
	});
	
	JButton btnNewButton = new JButton("Ende");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	});
	btnNewButton.setBounds(225, 89, 67, 23);
	contentPane.add(btnNewButton);
	
	lblZentimeter= new JLabel("");
	lblZentimeter.setBounds(10, 67, 100, 23);
	contentPane.add(lblZentimeter);
	
	btnUmrechnen = new JButton("Umrechnen");
	btnUmrechnen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    umrechnen();
		}
	});
	btnUmrechnen.setBounds(145, 32, 147, 23);
	contentPane.add(btnUmrechnen);
    }
    
    private void umrechnen() {
	double z, cm;
	z = Double.parseDouble(tfZoll.getText());
	cm = z * 2.54;
	DecimalFormat f = new DecimalFormat("#0.00");
	lblZentimeter.setText(f.format(cm) + " cm");
	tfZoll.requestFocus();
	tfZoll.selectAll();
    }

}
