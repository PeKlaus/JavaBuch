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
import java.awt.event.ActionEvent;

public class Rechner extends JFrame {

    private JPanel contentPane;
    private JTextField tfOperand1;
    private JTextField tfOperand2;
    private JTextField tfErgebnis;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Rechner frame = new Rechner();
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
    public Rechner() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 227);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblOperand1 = new JLabel("Operand 1");
	lblOperand1.setBounds(25, 29, 100, 14);
	contentPane.add(lblOperand1);
	
	JLabel lblOperand2 = new JLabel("Operand 2");
	lblOperand2.setBounds(305, 29, 100, 14);
	contentPane.add(lblOperand2);
	
	tfOperand1 = new JTextField();
	tfOperand1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    tfOperand2.requestFocus();
		    tfOperand2.selectAll();
		}
	});
	tfOperand1.setBounds(25, 46, 100, 20);
	contentPane.add(tfOperand1);
	tfOperand1.setColumns(10);
	
	tfOperand2 = new JTextField();
	tfOperand2.setBounds(305, 46, 100, 20);
	contentPane.add(tfOperand2);
	tfOperand2.setColumns(10);
	
	JButton btnPlus = new JButton("+");
	btnPlus.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    plus();
		    
		}
	});
	btnPlus.setBounds(158, 45, 50, 23);
	contentPane.add(btnPlus);
	
	JButton btnMinus = new JButton("-");
	btnMinus.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    minus();
		}
	});
	btnMinus.setBounds(218, 45, 50, 23);
	contentPane.add(btnMinus);
	
	JButton btnMal = new JButton("*");
	btnMal.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    mal();
		}
	});
	btnMal.setBounds(158, 79, 50, 23);
	contentPane.add(btnMal);
	
	JButton btnGeteilt = new JButton("/");
	btnGeteilt.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    geteilt();
		}
	});
	btnGeteilt.setBounds(218, 79, 50, 23);
	contentPane.add(btnGeteilt);
	
	JLabel lblErgebnis = new JLabel("Ergebnis");
	lblErgebnis.setBounds(25, 116, 100, 14);
	contentPane.add(lblErgebnis);
	
	tfErgebnis = new JTextField();
	tfErgebnis.setEditable(false);
	tfErgebnis.setBounds(25, 132, 380, 20);
	contentPane.add(tfErgebnis);
	tfErgebnis.setColumns(10);
    }
    private void plus() {
	double op1, op2, ergebnis;
	try {
	op1 = Double.parseDouble(tfOperand1.getText());
	op2 = Double.parseDouble(tfOperand2.getText());
	ergebnis = op1 + op2;
	tfErgebnis.setText(op1 + " + " + op2 + " = " + ergebnis);
	tfOperand1.requestFocus();
	tfOperand1.selectAll();
	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, "Fehler! falsche Eingabe  /" + e.getMessage());
	}
    }
    
    private void minus() {
   	double op1, op2, ergebnis;
   	try {
   	op1 = Double.parseDouble(tfOperand1.getText());
   	op2 = Double.parseDouble(tfOperand2.getText());
   	ergebnis = op1 - op2;
   	tfErgebnis.setText(op1 + " - " + op2 + " = " + ergebnis);
   	tfOperand1.requestFocus();
   	tfOperand1.selectAll();
   	} catch (Exception e) { 
   	    JOptionPane.showMessageDialog(null, "Fehler! falsche Eingabe  /" + e.getMessage()); 
   	}
    }
    
    private void mal() {
   	double op1, op2, ergebnis;
   	try {
   	op1 = Double.parseDouble(tfOperand1.getText());
   	op2 = Double.parseDouble(tfOperand2.getText());
   	ergebnis = op1 * op2;
   	tfErgebnis.setText(op1 + " * " + op2 + " = " + ergebnis);
   	tfOperand1.requestFocus();
   	tfOperand1.selectAll();
   	} catch (Exception e) {
   	 JOptionPane.showMessageDialog(null, "Fehler! falsche Eingabe  /" + e.getMessage());
   	}
    }
    
    private void geteilt() {
   	double op1, op2, ergebnis;
        try {
   	op1 = Double.parseDouble(tfOperand1.getText());
   	op2 = Double.parseDouble(tfOperand2.getText());
   	ergebnis = op1 / op2;
   	tfErgebnis.setText(op1 + " / " + op2 + " = " + ergebnis);
   	tfOperand1.requestFocus();
   	tfOperand1.selectAll();
   	} catch (NumberFormatException e) {
   	 tfErgebnis.setText("Fehler! falsche Eingabe  /" + e.getMessage()); 
        }
    }

}
