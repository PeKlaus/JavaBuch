package gui12;

/*
 * Programm Textzeichner1
 * Gibt an beliebigen Positionen eines Panels Text in den Farben
 * schwarz oder rot aus.
 */

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.Color;

import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Textzeichner2 extends JFrame {

    private JPanel contentPane;
    private JTextField tfTexteingabe;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private Graphics2D g2d;
    private JRadioButton rdbtnSchwarz;
    private JRadioButton rdbtnRot;
    private JButton btnSchriftart;
    private Font f;
    private JLabel lblSchriftprobe;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Textzeichner2 frame = new Textzeichner2();
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
    public Textzeichner2() {
    	setTitle("Textzeichner2");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 683, 455);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[283.00,grow][grow]", "[grow]"));
	
	JPanel panelTextflaeche = new JPanel();
	panelTextflaeche.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
		    int x = e.getX();
			int y = e.getY();
			Color farbe;
			if (rdbtnSchwarz.isSelected())
			{
				farbe = Color.black;
			}
			else
			{
				farbe = Color.red;
			}
			g2d = (Graphics2D)panelTextflaeche.getGraphics();
			if (f != null) {
			    g2d.setFont(f);
			}
			g2d.setColor(farbe);
			g2d.drawString(tfTexteingabe.getText(), x, y);	
		}
	});
	panelTextflaeche.setBorder(new LineBorder(new Color(0, 0, 0)));
	panelTextflaeche.setBackground(new Color(255, 255, 255));
	contentPane.add(panelTextflaeche, "cell 0 0,grow");
	
	JPanel panelBedienelemente = new JPanel();
	contentPane.add(panelBedienelemente, "cell 1 0,grow");
	panelBedienelemente.setLayout(new MigLayout("", "[grow]", "[][][][][][]"));
	
	JLabel lblTexteingabe = new JLabel("Texteingabe");
	panelBedienelemente.add(lblTexteingabe, "cell 0 0");
	
	tfTexteingabe = new JTextField();
	panelBedienelemente.add(tfTexteingabe, "cell 0 1,growx");
	tfTexteingabe.setColumns(10);
	
	btnSchriftart = new JButton("Schriftart...");
	btnSchriftart.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			g2d = (Graphics2D) panelTextflaeche.getGraphics();
			if (f == null) {
			    f = g2d.getFont();
			}
			Font nf = JMyFontChooser.showDialog(null, f);
			if (nf != null) {
			    f = nf;
			}
			lblSchriftprobe.setFont(f);
			g2d.setFont(f);
		    }
		
	});
	panelBedienelemente.add(btnSchriftart, "cell 0 2");
	
	lblSchriftprobe = new JLabel("");
	panelBedienelemente.add(lblSchriftprobe, "cell 0 3");
	
	rdbtnSchwarz = new JRadioButton("schwarz");
	rdbtnSchwarz.setSelected(true);
	buttonGroup.add(rdbtnSchwarz);
	panelBedienelemente.add(rdbtnSchwarz, "cell 0 4");
	
	rdbtnRot = new JRadioButton("rot");
	buttonGroup.add(rdbtnRot);
	panelBedienelemente.add(rdbtnRot, "cell 0 5");
    }

}