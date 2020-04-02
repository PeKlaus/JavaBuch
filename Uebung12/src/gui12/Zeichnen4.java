package gui12;

/*
 * Programm Zeichnen4 (Unter Verwendung von Graphics2D statt Graphics)
 * Dem Anwender steht ein Panel, auf das er verschiedene geometrische
 * Figuren zeichnen kann, zur Verfügung. Position und Größe der Figuren
 * können frei bestimmt werden.
 * Die Zeichnungen bleiben beim Neuzeichnen z.B. nach Verschieben des
 * Fensters dauerhaft erhalten.
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JInternalFrame;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;          // RadioButtons
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Graphics;

public class Zeichnen4 extends JFrame {

	private JMyPaintPanel contentPane;             // Eigens erstelltes JMyPaintPanel (Klasse)
	private JTextField tfPosX;
	private JTextField tfPosY;
	private JTextField tfBreite;
	private JTextField tfHoehe;
	private final ButtonGroup buttonGroup = new ButtonGroup();    // eine ButtonGroup wurde erstellt in der Design ansicht per Rechtsklick auf einen RadioButton
	private JCheckBox chbxGefuellt;
	private JRadioButton rdbtnLinie;
	private JRadioButton rdbtnOval;
	private JRadioButton rdbtnKreis;
	private JRadioButton rdbtnRechteck;
	private JLabel lblPositionX;
	private JLabel lblBreite;
	private JLabel lblPositionY;
	private JLabel lblHoehe;
	private char figur;
	private Zeichenobjekt zo;
	private Color farbe = Color.black;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zeichnen4 frame = new Zeichnen4();
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
	public Zeichnen4() {
		setTitle("Zeichnen 4");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 476);
		contentPane = new JMyPaintPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JMyPaintPanel panelZeichenflaeche = new JMyPaintPanel();
		panelZeichenflaeche.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelZeichenflaeche.setBackground(new Color(255, 255, 255));
		contentPane.add(panelZeichenflaeche, BorderLayout.CENTER);
		
		JPanel panelMenue = new JPanel();
		contentPane.add(panelMenue, BorderLayout.EAST);
		panelMenue.setLayout(new MigLayout("", "[][grow][][grow]", "[][][][][][][][][][][][][][][]"));
		
		lblPositionX = new JLabel("Position x:");
		panelMenue.add(lblPositionX, "cell 0 0,alignx trailing");
		
		tfPosX = new JTextField();
		panelMenue.add(tfPosX, "cell 1 0,growx");
		tfPosX.setColumns(10);
		
		lblPositionY = new JLabel(" y:");
		panelMenue.add(lblPositionY, "cell 2 0,alignx trailing");
		
		tfPosY = new JTextField();
		panelMenue.add(tfPosY, "cell 3 0,growx");
		tfPosY.setColumns(10);
		
		lblBreite = new JLabel("Breite:");
		panelMenue.add(lblBreite, "cell 0 1,alignx trailing");
		
		tfBreite = new JTextField();
		panelMenue.add(tfBreite, "cell 1 1,growx");
		tfBreite.setColumns(10);
		
		lblHoehe = new JLabel("H\u00F6he:");
		panelMenue.add(lblHoehe, "cell 2 1,alignx trailing");
		
		tfHoehe = new JTextField();
		panelMenue.add(tfHoehe, "cell 3 1,growx");
		tfHoehe.setColumns(10);
		
		rdbtnRechteck = new JRadioButton("Rechteck");  
		rdbtnRechteck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setzeBeschriftung();
				figur = 'r';
			}
		});
		buttonGroup.add(rdbtnRechteck);                                // Der Button von dem aus die ButtonGroup erstellt wurde
		panelMenue.add(rdbtnRechteck, "cell 1 3");
		
		chbxGefuellt = new JCheckBox("gef\u00FCllt");
		panelMenue.add(chbxGefuellt, "cell 3 3");
		
		rdbtnKreis = new JRadioButton("Kreis");
		rdbtnKreis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setzeBeschriftung();
				lblHoehe.setVisible(false);
				tfHoehe.setVisible(false);
				figur = 'k';
			}
		});
		buttonGroup.add(rdbtnKreis);
		panelMenue.add(rdbtnKreis, "cell 1 4");
		
		rdbtnOval = new JRadioButton("Oval");
		rdbtnOval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setzeBeschriftung();
				figur = 'o';
			}
		});
		buttonGroup.add(rdbtnOval);
		panelMenue.add(rdbtnOval, "cell 1 5");
		
		rdbtnLinie = new JRadioButton("Linie");
		rdbtnLinie.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				setzeBeschriftung();
				chbxGefuellt.setVisible(false);
				lblHoehe.setVisible(true);
				tfHoehe.setVisible(true);
				figur = 'l';                    //char Variable für die zuweisung was gezeichnet werden soll
			}
		});
		buttonGroup.add(rdbtnLinie);
		panelMenue.add(rdbtnLinie, "cell 1 6");
		
		JButton btnZeichnen = new JButton("Zeichnen");
		btnZeichnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { // panelZeichenflaeche.getGraphics() >>.drawLine(x1, y1, x2, y2)<< ;
					int x1 = Integer.parseInt(tfPosX.getText());        
					int y1 = Integer.parseInt(tfPosY.getText());
					int x2 = Integer.parseInt(tfBreite.getText());
					int y2 = Integer.parseInt(tfHoehe.getText());
					switch (figur) {                                          // Switch/Case Abfrage nach dem gewählten Radio-Button
					                                                          // mit der Anweisung zum zeichnen auf das >>JMyPaintPanel<< !!!
					case 'r' : 
			 // ruft den Konstruktor aus der Klasse RechteckZeichenobjekt auf
						zo = new RechteckZeichenobjekt( x1, y1, x2, y2, farbe, 1.0f, chbxGefuellt.isSelected());					
						break;
					case 'k' :
						zo = new KreisZeichenobjekt( x1, y1, x2, y2, farbe, 1.0f, chbxGefuellt.isSelected());
						break;
					case 'o' :
						zo = new OvalZeichenobjekt(x1, y1, x2, y2, farbe, 1.0f, chbxGefuellt.isSelected());
						break;
					case 'l' :
							zo = new LinieZeichenobjekt(x1, y1, x2, y2, farbe, 1.0f);
						    break;
					}
					panelZeichenflaeche.addZeichenobjekt(zo);  // Zeichnet auf das panelZeichenflaeche
					panelZeichenflaeche.repaint();             // Zeichnet neu
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Die Eingaben sind ungültig.");
				}
			}
		});
		panelMenue.add(btnZeichnen, "cell 1 8");
		
		JLabel lblZeichenfläche = new JLabel("Zeichenfl\u00E4che");
		contentPane.add(lblZeichenfläche, BorderLayout.NORTH);
		
		
	}
	
	private void setzeBeschriftung() {    //Methode zum setzen der Beschriftung
		if (rdbtnLinie.isSelected()) {
			lblPositionX.setText("Startpunkt x:");
			lblBreite.setText("Endpunkt x:");
			lblHoehe.setText("y:");
		} else {
			lblPositionX.setText("Position x:");
			chbxGefuellt.setVisible(true);
			if (rdbtnKreis.isSelected()) {
				lblBreite.setText("Durchmesser:");
			} else {
				lblBreite.setText("Breite:");
				lblHoehe.setVisible(true);
				tfHoehe.setVisible(true);
			}
			lblHoehe.setText("Höhe:");
		}
	}

}