package gui12;

/*
 * Programm Zeichnen7 (mit verbesserter Funktionalität beim Aufziehen
 * eines Rechtecks)
 * Dem Anwender steht ein Panel, auf das er verschiedene geometrische
 * Figuren zeichnen kann, zur Verfügung. Position und Größe der Figuren
 * können frei bestimmt werden.
 * Die Zeichnungen bleiben beim Neuzeichnen z.B. nach Verschieben des
 * Fensters dauerhaft erhalten.
 * Beim Aufziehen eines Rechtecks zur Vorgabe der Größe der zu zeichnenden
 * >>>>Figur muss nicht mit der linken oberen Ecke begonnen werden.<<<<
 */

import java.awt.BasicStroke;
import java.awt.EventQueue;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.ButtonGroup;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;

public class Zeichnen7 extends JFrame {

    private JPanel contentPane;
    private JTextField tfPositionX1;
    private JTextField tfPositionY1;
    private JTextField tfPositionX2;
    private JTextField tfPositionY2;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton rdbtnRechteck;
    private JRadioButton rdbtnKreis;
    private JRadioButton rdbtnOval;
    private JRadioButton rdbtnLinie;
    private JCheckBox chckbxGefuellt;
    private JLabel lblPositionX1;
    private JLabel lblPositionY1;
    private JLabel lblPositionX2;
    private JLabel lblPositionY2;
    private char figur = 'R';
    private int x1, y1, x2, y2, xstart, ystart, xend, yend;
    private Color farbe = Color.black;
    private Zeichenobjekt zo;
    private JButton btnFarbeWhlen;
    private JPanel colorPanel;
    private JLabel lblMausposition;
    private boolean zeichnen = false;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Zeichnen7 frame = new Zeichnen7();
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
    public Zeichnen7() {
	setTitle("Zeichnen7");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 697, 437);
	contentPane = new JMyPaintPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[grow][]", "[][grow][]"));

	JLabel lblZeichenflaeche = new JLabel("Zeichenfl\u00E4che");
	contentPane.add(lblZeichenflaeche, "cell 0 0");

	JMyPaintPanel panelZeichenflaeche = new JMyPaintPanel();
	panelZeichenflaeche.addMouseMotionListener(new MouseMotionAdapter() {
	    @Override
	    public void mouseMoved(MouseEvent e) {
		lblMausposition.setText("x: " + e.getX() + " y: " + e.getY());
	    }

	    @Override
	    public void mouseDragged(MouseEvent e) {
		xend = e.getX();
		yend = e.getY();
		Koordinatenbestimmen();
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
		    tfPositionX2.setText(String.valueOf(xend));
		    tfPositionY2.setText(String.valueOf(yend));
		} else {
		    tfPositionX2.setText(String.valueOf(x2));
		    tfPositionY2.setText(String.valueOf(y2));
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
	    public void mousePressed(MouseEvent e) {
		xstart = e.getX();
		ystart = e.getY();
		tfPositionX1.setText(String.valueOf(xstart));
		tfPositionY1.setText(String.valueOf(ystart));
	    }

	    @Override
	    public void mouseReleased(MouseEvent e) {
		if (zeichnen) {
		    xend = e.getX();
		    yend = e.getY();
		    Koordinatenbestimmen();    // Methode zum bestimmen der Koordinaten damit sie richtig eingetragen werden!!!!
		    switch (figur) {
		    case 'L':
			zo = new LinieZeichenobjekt(xstart, ystart, xend, yend,
				farbe, 1.0f);
			break;
		    case 'R':
			zo = new RechteckZeichenobjekt(x1, y1, x2, y2, farbe,
				1.0f, chckbxGefuellt.isSelected());
			break;
		    case 'O':
			zo = new OvalZeichenobjekt(x1, y1, x2, y2, farbe, 1.0f,
				chckbxGefuellt.isSelected());
			break;
		    case 'K':
			zo = new KreisZeichenobjekt(x1, y1, x2, y2, farbe,
				1.0f, chckbxGefuellt.isSelected());
			break;
		    }
		    panelZeichenflaeche.addZeichenobjekt(zo);
		    panelZeichenflaeche.repaint();
		    zeichnen = false;
		}

	    }
	});
	panelZeichenflaeche.setBorder(new LineBorder(new Color(0, 0, 0)));
	panelZeichenflaeche.setBackground(new Color(255, 255, 255));
	contentPane.add(panelZeichenflaeche, "cell 0 1,grow");

	JPanel panelBedienelemente = new JPanel();
	contentPane.add(panelBedienelemente, "cell 1 1,grow");
	panelBedienelemente.setLayout(new MigLayout("", "[][grow][][][grow]",
		"[][][][][][][][][][][][]"));

	lblPositionX1 = new JLabel("Position x:");
	panelBedienelemente.add(lblPositionX1, "cell 0 0,alignx trailing");

	tfPositionX1 = new JTextField();
	tfPositionX1.setText("0");
	panelBedienelemente.add(tfPositionX1, "cell 1 0,growx");
	tfPositionX1.setColumns(10);

	lblPositionY1 = new JLabel("y:");
	panelBedienelemente.add(lblPositionY1, "cell 3 0,alignx trailing");

	tfPositionY1 = new JTextField();
	tfPositionY1.setText("0");
	panelBedienelemente.add(tfPositionY1, "cell 4 0,growx");
	tfPositionY1.setColumns(10);

	lblPositionX2 = new JLabel("Breite:");
	panelBedienelemente.add(lblPositionX2, "cell 0 1,alignx trailing");

	tfPositionX2 = new JTextField();
	tfPositionX2.setText("0");
	panelBedienelemente.add(tfPositionX2, "cell 1 1,growx");
	tfPositionX2.setColumns(10);

	lblPositionY2 = new JLabel("H\u00F6he:");
	panelBedienelemente.add(lblPositionY2, "cell 3 1,alignx trailing");

	tfPositionY2 = new JTextField();
	tfPositionY2.setText("0");
	panelBedienelemente.add(tfPositionY2, "cell 4 1,growx");
	tfPositionY2.setColumns(10);

	rdbtnRechteck = new JRadioButton("Rechteck");
	rdbtnRechteck.setSelected(true);
	rdbtnRechteck.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		setzeBeschriftungen();
		chckbxGefuellt.setVisible(true);
		lblPositionY2.setVisible(true);
		tfPositionY2.setVisible(true);
		figur = 'R';
	    }
	});
	buttonGroup.add(rdbtnRechteck);
	panelBedienelemente.add(rdbtnRechteck, "cell 1 3");

	chckbxGefuellt = new JCheckBox("gef\u00FCllt");
	panelBedienelemente.add(chckbxGefuellt, "cell 4 3");

	rdbtnKreis = new JRadioButton("Kreis");
	rdbtnKreis.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		setzeBeschriftungen();
		chckbxGefuellt.setVisible(true);
		lblPositionY2.setVisible(false);
		tfPositionY2.setVisible(false);
		figur = 'K';
	    }
	});
	buttonGroup.add(rdbtnKreis);
	panelBedienelemente.add(rdbtnKreis, "cell 1 4");

	rdbtnOval = new JRadioButton("Oval");
	rdbtnOval.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		setzeBeschriftungen();
		chckbxGefuellt.setVisible(true);
		lblPositionY2.setVisible(true);
		tfPositionY2.setVisible(true);
		figur = 'O';
	    }
	});
	buttonGroup.add(rdbtnOval);
	panelBedienelemente.add(rdbtnOval, "cell 1 5");

	rdbtnLinie = new JRadioButton("Linie");
	rdbtnLinie.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		setzeBeschriftungen();
		chckbxGefuellt.setVisible(false);
		lblPositionY2.setVisible(true);
		tfPositionY2.setVisible(true);
		figur = 'L';
	    }
	});
	buttonGroup.add(rdbtnLinie);
	panelBedienelemente.add(rdbtnLinie, "cell 1 6");

	JButton btnZeichnen = new JButton("Zeichnen");
	btnZeichnen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		try {
		    x1 = Integer.parseInt(tfPositionX1.getText());
		    y1 = Integer.parseInt(tfPositionY1.getText());
		    x2 = Integer.parseInt(tfPositionX2.getText());
		    y2 = Integer.parseInt(tfPositionY2.getText());
		    switch (figur) {
		    case 'L':
			zo = new LinieZeichenobjekt(x1, y1, x2, y2, farbe, 1.0f);
			break;
		    case 'R':
			zo = new RechteckZeichenobjekt(x1, y1, x2, y2, farbe,
				1.0f, chckbxGefuellt.isSelected());
			break;
		    case 'O':
			zo = new OvalZeichenobjekt(x1, y1, x2, y2, farbe, 1.0f,
				chckbxGefuellt.isSelected());
			break;
		    case 'K':
			zo = new KreisZeichenobjekt(x1, y1, x2, y2, farbe,
				1.0f, chckbxGefuellt.isSelected());
			break;
		    }
		    panelZeichenflaeche.addZeichenobjekt(zo);
		    panelZeichenflaeche.repaint();
		} catch (Exception ex) {
		    JOptionPane.showMessageDialog(null,
			    "Die Eingaben sind ungültig.");
		}
	    }
	});

	btnFarbeWhlen = new JButton("Zeichenfarbe");
	btnFarbeWhlen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		farbe = JColorChooser.showDialog(null,
			"Wähle neue Zeichenfarbe", Color.black);
		colorPanel.setBackground(farbe);
	    }
	});
	panelBedienelemente.add(btnFarbeWhlen, "cell 1 7");

	colorPanel = new JPanel();
	colorPanel.setBackground(new Color(0, 0, 0));
	panelBedienelemente.add(colorPanel, "cell 3 7,grow");
	panelBedienelemente.add(btnZeichnen, "cell 1 9,alignx center");

	JButton btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		System.exit(0);
	    }
	});
	panelBedienelemente.add(btnEnde, "cell 1 11,alignx center");

	lblMausposition = new JLabel("x:");
	lblMausposition.setVisible(false);
	contentPane.add(lblMausposition, "cell 0 2");
	tfPositionX1.selectAll();

    }

    private void setzeBeschriftungen() {
	if (rdbtnLinie.isSelected()) {
	    lblPositionX1.setText("Startpunkt x:");
	    lblPositionX2.setText("Endpunkt x:");
	    lblPositionY2.setText("y:");
	} else {
	    lblPositionX1.setText("Position x:");
	    if (rdbtnKreis.isSelected()) {
		lblPositionX2.setText("Durchmesser:");
	    } else {
		lblPositionX2.setText("Breite:");
	    }
	    lblPositionY2.setText("Höhe:");
	}
    }

    private void Koordinatenbestimmen() {
	if ((xend > xstart) && (yend > ystart)) {
	    x1 = xstart;
	    x2 = xend - xstart;
	    y1 = ystart;
	    y2 = yend - ystart;
	} else if ((xend < xstart) && (yend > ystart)) {
	    x1 = xend;
	    x2 = xstart - xend;
	    y1 = ystart;
	    y2 = yend - ystart;
	} else if ((xend > xstart) && (yend < ystart)) {
	    x1 = xstart;
	    x2 = xend - xstart;
	    y1 = yend;
	    y2 = ystart - yend;
	} else if ((xend < xstart) && (yend < ystart)) {
	    x1 = xend;
	    x2 = xstart - xend;
	    y1 = yend;
	    y2 = ystart - yend;
	}
    }
}