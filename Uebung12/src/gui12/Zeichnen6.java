package gui12;

import java.awt.BasicStroke;

/*
 * Programm Zeichnen6 mit >>Maus<< als Zeichengerät
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
import javax.swing.JColorChooser;
import javax.swing.JButton;          // RadioButtons
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;

public class Zeichnen6 extends JFrame {

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
	private JButton btnFarbeWaehlen;
	private JPanel colorpanel;
	private JLabel lblMausposition;
	private JLabel lblMP;
	private JButton btnZeichnen;
	private int x1, y1, x2, y2, xend, yend;
	private boolean zeichnen = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zeichnen6 frame = new Zeichnen6();
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
	public Zeichnen6() {
		setTitle("Zeichnen 6");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 476);
		contentPane = new JMyPaintPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JMyPaintPanel panelZeichenflaeche = new JMyPaintPanel();
		panelZeichenflaeche.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				lblMausposition.setText("x: " + e.getX() + "  y: " + e.getY());
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				xend = e.getX();
				yend = e.getY();
				x2 = e.getX() - x1;
				y2 = e.getY() - y1;
				panelZeichenflaeche.repaint();
				Graphics2D g2d = (Graphics2D) panelZeichenflaeche.getGraphics();
				g2d.setColor(Color.black);
				BasicStroke stil = new BasicStroke(0.5f, BasicStroke.CAP_BUTT,
					BasicStroke.JOIN_MITER);
				g2d.setStroke(stil);
				Rectangle2D.Float rechteck = new Rectangle2D.Float(x1, y1, x2,
					y2);
				g2d.draw(rechteck);
				if (figur == 'L') {
				    tfBreite.setText(String.valueOf(xend));
				    tfHoehe.setText(String.valueOf(yend));
				} else {
				    tfBreite.setText(String.valueOf(x2));
				    tfHoehe.setText(String.valueOf(y2));
				}
				zeichnen = true;
			    }
			});
		
		panelZeichenflaeche.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMausposition.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMausposition.setVisible(false);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if (zeichnen) {
					xend = e.getX();
					yend = e.getY();
					x2 = e.getX() - x1;
					y2 = e.getY() - y1;
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
                         zo = new LinieZeichenobjekt(x1, y1, xend, yend, farbe, 1.0f);
                         break;
                         }
                         panelZeichenflaeche.addZeichenobjekt(zo);  // Zeichnet auf das panelZeichenflaeche
                         panelZeichenflaeche.repaint();
                         zeichnen = false;
				}
			}
			public void mousePressed(MouseEvent e) {
				x1 = e.getX();
				y1 = e.getY();
				tfPosX.setText(String.valueOf(x1));
				tfPosY.setText(String.valueOf(y1));
			}
		});
		panelZeichenflaeche.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelZeichenflaeche.setBackground(new Color(255, 255, 255));
		contentPane.add(panelZeichenflaeche, BorderLayout.CENTER);
		
		JPanel panelMenue = new JPanel();
		contentPane.add(panelMenue, BorderLayout.EAST);
		panelMenue.setLayout(new MigLayout("", "[][grow][][grow]", "[][][][][][][][][grow][][][][][][][][][]"));
		
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
		
	// Aufruf des Farbauswahldialogs und  Anzeigen der gewählten Farbe.	
		btnFarbeWaehlen = new JButton("Farbeauswahl...");
		btnFarbeWaehlen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				farbe = JColorChooser.showDialog(null, "Wähle neue Zeichenfarbe", Color.black);  // farbe gibt die auswahl an die Figur weiter
				colorpanel.setBackground(farbe);  // setzt das colorpanel auf die ausgewählte Farbe
			}
		});
		panelMenue.add(btnFarbeWaehlen, "cell 1 7,growx,aligny center");
		
		
		btnZeichnen = new JButton("Zeichnen");
		btnZeichnen.setVisible(false);
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
	
		panelMenue.add(btnZeichnen, "cell 3 7,alignx center,aligny center");
		
		colorpanel = new JPanel();
		colorpanel.setPreferredSize(new Dimension(50, 50));
		colorpanel.setBackground(Color.BLACK);
		panelMenue.add(colorpanel, "cell 1 8,alignx center,aligny top");
		
		lblMP = new JLabel("Mausposition:");
		panelMenue.add(lblMP, "cell 3 14,alignx center,aligny bottom");
		
		lblMausposition = new JLabel("");
		lblMausposition.setVisible(false);
		panelMenue.add(lblMausposition, "cell 3 15,alignx center,aligny center");
		
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