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
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Osterdatum extends JFrame {

    private JPanel contentPane;
    private JTextField tfJahr;
    private JLabel lblOstersonntag;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Osterdatum frame = new Osterdatum();
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
    public Osterdatum() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 574, 194);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblJahr = new JLabel("Jahr");
	lblJahr.setBounds(10, 11, 70, 14);
	contentPane.add(lblJahr);
	
	tfJahr = new JTextField();
	tfJahr.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			Berechnung();
		    }
		}
	});
	tfJahr.setBounds(10, 28, 80, 20);
	contentPane.add(tfJahr);
	tfJahr.setColumns(10);
	
	JButton btnOstersonntag = new JButton("Datum f\u00FCr Ostersonntag berechnen");
	btnOstersonntag.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    Berechnung();
		}
	});
	btnOstersonntag.setBounds(119, 27, 262, 23);
	contentPane.add(btnOstersonntag);
	
	JLabel lblDat = new JLabel("Datum f\u00FCr Ostersonntag :");
	lblDat.setBounds(10, 83, 174, 14);
	contentPane.add(lblDat);
	
	lblOstersonntag = new JLabel("");
	lblOstersonntag.setBounds(204, 83, 277, 14);
	contentPane.add(lblOstersonntag);
	
	JButton btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	});
	btnEnde.setBounds(233, 122, 89, 23);
	contentPane.add(btnEnde);
    }
    
    private void Berechnung() {
	int y = Integer.parseInt(tfJahr.getText());
	if (y > 1583) {
	    int g = y % 19;
	    int c = y / 100;
	    int h = (c - c / 4 - (8 * c + 13) / 25 + 19 * g + 15) % 30;
	    int i = h - (h / 28) * (1 - (29 / (h + 1)) * ((21 - g) / 11));
	    int j = (y + y / 4 + i + 2 - c + c / 4) % 7;
	    int l = i - j;
	    int m = 3 + (l + 40) / 44;
	    int d = l + 28 - 31 * (m / 4);
	    lblOstersonntag.setText(d + "." + m + "." + tfJahr.getText());
	} else {
	    lblOstersonntag.setText("Berechnung nur für Jahreszahl > 1583");
	}
	tfJahr.requestFocus();
	tfJahr.selectAll();
    }

}
