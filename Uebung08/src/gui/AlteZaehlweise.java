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
import java.awt.event.ActionEvent;

public class AlteZaehlweise extends JFrame {

    private JPanel contentPane;
    private JTextField tfStueckzahl;
    private JLabel lblGross;
    private JLabel lblSchock;
    private JLabel lblDutzend;
    private JLabel lblStueck;
    private JLabel lblGros;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    AlteZaehlweise frame = new AlteZaehlweise();
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
    public AlteZaehlweise() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 405, 252);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblStueckzahl = new JLabel("Geben Sie eine St\u00FCckzahl an:");
	lblStueckzahl.setBounds(10, 11, 170, 14);
	contentPane.add(lblStueckzahl);
	
	tfStueckzahl = new JTextField();
	tfStueckzahl.setBounds(10, 36, 110, 20);
	contentPane.add(tfStueckzahl);
	tfStueckzahl.setColumns(10);
	tfStueckzahl.addKeyListener(new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
		    if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			umrechnen();
		    }
		}
	});
	
	JButton btnUmrechnen = new JButton("In alte Z\u00E4hlma\u00DFe umrechnen");
	btnUmrechnen.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    umrechnen();
		}
	});
	btnUmrechnen.setBounds(167, 36, 211, 23);
	contentPane.add(btnUmrechnen);
	
	lblGros = new JLabel("Gros");
	lblGros.setBounds(10, 83, 100, 14);
	contentPane.add(lblGros);
	
	lblSchock = new JLabel("Schock");
	lblSchock.setBounds(10, 108, 100, 14);
	contentPane.add(lblSchock);
	
	lblDutzend = new JLabel("Dutzend");
	lblDutzend.setBounds(10, 133, 100, 14);
	contentPane.add(lblDutzend);
	
	lblStueck = new JLabel("St\u00FCck");
	lblStueck.setBounds(10, 163, 100, 14);
	contentPane.add(lblStueck);
	
	JButton btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		    System.exit(0);
		}
		});
	btnEnde.setBounds(289, 159, 89, 23);
	contentPane.add(btnEnde);
	
    }
    
    private void umrechnen() {
	int stueck, gros, schock, dutzend;
	stueck = Integer.parseInt(tfStueckzahl.getText());
	gros = stueck / 144;
	stueck = stueck % 144;
	schock = stueck / 60;
	stueck = stueck % 60;
	dutzend = stueck / 12;
	stueck = stueck % 12;
	lblGros.setText(gros + " Gros");
	lblSchock.setText(schock + " Schock");
	lblDutzend.setText(dutzend + " Dutzend");
	lblStueck.setText(stueck + " Stück");
	tfStueckzahl.requestFocus();
	tfStueckzahl.selectAll();
    }

}
