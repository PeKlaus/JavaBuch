package gui003;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Vokaltest01 extends JFrame {

    private JPanel contentPane;
    private JTextField tfBuchstabe;
    private JLabel lblAusgabe;
    private JButton btnOK;
    private JButton btnEnde;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Vokaltest01 frame = new Vokaltest01();
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
    public Vokaltest01() {
    	setTitle("Vokaltest");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 386, 158);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblGebenSieEinen = new JLabel("geben Sie einen Buchstaben ein :");
	lblGebenSieEinen.setBounds(10, 11, 212, 14);
	contentPane.add(lblGebenSieEinen);
	
	tfBuchstabe = new JTextField();
	tfBuchstabe.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			Vokaltest2();
		    }
		}
	});
	tfBuchstabe.setBounds(220, 8, 54, 20);
	contentPane.add(tfBuchstabe);
	tfBuchstabe.setColumns(10);
	
	btnOK = new JButton("OK");
	btnOK.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    Vokaltest2();
		}
	});
	btnOK.setBounds(284, 7, 69, 23);
	contentPane.add(btnOK);
	
	lblAusgabe = new JLabel("");
	lblAusgabe.setHorizontalAlignment(SwingConstants.CENTER);
	lblAusgabe.setHorizontalTextPosition(SwingConstants.CENTER);
	lblAusgabe.setFont(new Font("Tahoma", Font.BOLD, 18));
	lblAusgabe.setBounds(10, 56, 212, 30);
	contentPane.add(lblAusgabe);
	
	btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	});
	btnEnde.setBounds(281, 86, 89, 23);
	contentPane.add(btnEnde);
    }
    // Verschachtelte if else Anweisung
    private void Vokaltest() {
	String eingabe;
	char c;
	boolean istVokal;
	try {
	eingabe = tfBuchstabe.getText();
	c = eingabe.charAt(0);
	if (c == 'a') {
	    istVokal = true;
	} else {
	    if (c == 'e') {
		istVokal = true;
	    } else {
		if ( c == 'i') {
		    istVokal = true;
		} else {
		    if (c == 'o') {
			istVokal = true;
		    } else {
			if ( c == 'u') {
			    istVokal = true;
			} else {
				if (c == 'A') {
				    istVokal = true;
				} else {
				    if (c == 'E') {
					istVokal = true;
				    } else {
					if ( c == 'I') {
					    istVokal = true;
					} else {
					    if (c == 'O') {
						istVokal = true;
					    } else {
						if ( c == 'U') {
						    istVokal = true;			    
			                        } else {
			                            istVokal = false;
			                        }
					    }
					}
				    }
				}
			}
		    }
		}
	    }
	}
if (istVokal == true) {
    String.valueOf('c');
     lblAusgabe.setText("(" + c + ") ist ein Vokal!");
} else {
    lblAusgabe.setText("(" + c + ") ist kein Vokal!");
}
tfBuchstabe.requestFocus();
tfBuchstabe.selectAll();
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Fehler! falsche Eingabe  /" + e.getMessage());
}
    }
    // switch Case Anweisung
    private void Vokaltest2() {
	String eingabe;
	char c;
	boolean istVokal;
	try {
	eingabe = tfBuchstabe.getText();
	c = eingabe.charAt(0);
	switch (c) {
	case 'a':;
	case 'e':;
	case 'i':;
	case 'o':;
	case 'u':;
	case 'A':;
	case 'E':;
	case 'I':;
	case 'O':;
	case 'U':
	    lblAusgabe.setText("(" + c + ") ist ein Vokal!");
	    break;
	    default:
	    lblAusgabe.setText("(" + c + ") ist kein Vokal!");
	
	}
	tfBuchstabe.requestFocus();
	tfBuchstabe.selectAll();
    } catch (Exception e) {
	JOptionPane.showMessageDialog(null, "Fehler! falsche Eingabe  /" + e.getMessage());
    }
    }
}
   
    
    			
   
	


    

		
	    
	
    


