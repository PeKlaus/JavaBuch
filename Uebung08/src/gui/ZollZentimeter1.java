package gui;

/*
 * Programm ZollZentimeter zur Umrechnung einer Längenangabe
 * von Zoll in Zentimeter.
 * @author Hans-Peter Habelitz
 * @date 2014-08-24
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ZollZentimeter1 extends JFrame {

    private JPanel contentPane;
    private JTextField tfZoll;
    private JLabel lblZentimeter;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    ZollZentimeter1 frame = new ZollZentimeter1();
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
    public ZollZentimeter1() {
    	setTitle("Umrechnung von Zoll in Zentimeter");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 355, 158);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lblZoll = new JLabel("Zoll");
	lblZoll.setBounds(10, 11, 46, 14);
	contentPane.add(lblZoll);

	tfZoll = new JTextField();
	tfZoll.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		    umrechnen();
		}
	    }
	});
	tfZoll.setBounds(10, 27, 110, 20);
	contentPane.add(tfZoll);
	tfZoll.setColumns(10);

	JButton btnUmrechnen = new JButton("Umrechnen");
	btnUmrechnen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		umrechnen();
	    }
	});
	btnUmrechnen.setBounds(10, 68, 110, 23);
	contentPane.add(btnUmrechnen);

	JButton btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		System.exit(0);
	    }
	});
	btnEnde.setBounds(200, 68, 89, 23);
	contentPane.add(btnEnde);

	lblZentimeter = new JLabel("");
	lblZentimeter.setBounds(214, 27, 62, 14);
	contentPane.add(lblZentimeter);
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
