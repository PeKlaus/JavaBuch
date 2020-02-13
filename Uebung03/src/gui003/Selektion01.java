package gui003;

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

@SuppressWarnings("serial")
public class Selektion01 extends JFrame {

    private JPanel contentPane;
    private JTextField tfAlter;
    private JLabel lblAusgabe;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Selektion01 frame = new Selektion01();
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
    public Selektion01() {
    	setTitle("SelektionJFrame");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 266, 214);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblAlter = new JLabel("Geben Sie ihr Alter ein :");
	lblAlter.setBounds(10, 11, 207, 14);
	contentPane.add(lblAlter);
	
	tfAlter = new JTextField();
	
	tfAlter.addKeyListener(new KeyAdapter() {
	   
	
		@Override
		public void keyPressed(KeyEvent e1) {
		    if (e1.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
			    int alter;
			    alter = Integer.parseInt(tfAlter.getText());
			    if (alter < 18) {
				lblAusgabe.setText("Sie sind leider noch nicht volljährig!!");
			    } else {
				lblAusgabe.setText("Sie sind volljährig!");
				}
			    tfAlter.requestFocus();
		            tfAlter.selectAll();
	
		    } catch (Exception e) {
			    JOptionPane.showMessageDialog(null, "Fehler! falsche Eingabe  /" + e.getMessage());
		    }
		    }
		}
});
		

	tfAlter.setBounds(10, 25, 109, 20);
	contentPane.add(tfAlter);
	tfAlter.setColumns(10);	
	JButton btnOk = new JButton("OK");	
	btnOk.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e2) {
		    int alter;
		    try {
		    alter = Integer.parseInt(tfAlter.getText());
		    if (alter < 18) {
			lblAusgabe.setText("Sie sind leider noch nicht volljährig!!");
		    } else {
			lblAusgabe.setText("Sie sind volljährig!");
		    }
		    tfAlter.requestFocus();
	            tfAlter.selectAll();
		
	} catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fehler! falsche Eingabe  /" + e.getMessage());
	}
		}
});
	btnOk.setBounds(142, 24, 89, 23);
	contentPane.add(btnOk);
	
	lblAusgabe = new JLabel("");
	lblAusgabe.setBounds(10, 74, 221, 14);
	contentPane.add(lblAusgabe);
	
	JButton btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
	});
	btnEnde.setBounds(77, 115, 89, 23);
	contentPane.add(btnEnde);
    }
}
