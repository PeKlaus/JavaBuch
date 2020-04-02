package gui12;

/*
 * Programm Textzeichner4 (speichert die gezeichneten Texte in einer Datei)
 * Gibt an beliebigen Positionen eines Panels Text in
 * den Farben schwarz oder rot aus.
 * Es genügt ein Schreib- bzw. Lesevorgang für den gesamten Vector.
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.Color;

import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Textzeichner4 extends JFrame {

    private JPanel contentPane;
    private JTextField tfTexteingabe;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton rdbtnSchwarz;
    private JRadioButton rdbtnRot;
    private String dateiname = "." + File.separator + "Textausgaben.dat";
    private ArrayList<Textausgabe> meinetexte;
    private JButton btnEnde;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Textzeichner4 frame = new Textzeichner4();
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
    public Textzeichner4() {
	setTitle("Textzeichner4");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane
		.setLayout(new MigLayout("", "[283.00,grow][grow]", "[grow]"));

	JMyTextPanel panelZeichenflaeche = new JMyTextPanel();
	panelZeichenflaeche.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Color farbe;
		if (rdbtnSchwarz.isSelected()) {
		    farbe = Color.black;
		} else {
		    farbe = Color.red;
		}
		panelZeichenflaeche.addTextausgabe(x, y,
			tfTexteingabe.getText(), farbe);
		panelZeichenflaeche.repaint();
	    }
	});
	panelZeichenflaeche.setBorder(new LineBorder(new Color(0, 0, 0)));
	panelZeichenflaeche.setBackground(new Color(255, 255, 255));
	contentPane.add(panelZeichenflaeche, "cell 0 0,grow");

	JPanel panelBedienelemente = new JPanel();
	contentPane.add(panelBedienelemente, "cell 1 0,grow");
	panelBedienelemente.setLayout(new MigLayout("", "[grow]",
		"[][][][][][][][]"));

	JLabel lblTexteingabe = new JLabel("Texteingabe");
	panelBedienelemente.add(lblTexteingabe, "cell 0 0");

	tfTexteingabe = new JTextField();
	panelBedienelemente.add(tfTexteingabe, "cell 0 1,growx");
	tfTexteingabe.setColumns(10);

	rdbtnSchwarz = new JRadioButton("schwarz");
	rdbtnSchwarz.setSelected(true);
	buttonGroup.add(rdbtnSchwarz);
	panelBedienelemente.add(rdbtnSchwarz, "cell 0 3");

	rdbtnRot = new JRadioButton("rot");
	buttonGroup.add(rdbtnRot);
	panelBedienelemente.add(rdbtnRot, "cell 0 4");

	btnEnde = new JButton("Ende");
	btnEnde.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		ArrayList<Textausgabe> liste = new ArrayList<Textausgabe>();
		liste = panelZeichenflaeche.getArrayList();
		writeArrayList(liste);
		System.exit(0);
	    }
	});
	panelBedienelemente.add(btnEnde, "cell 0 7,alignx center");
	File datei = new File(dateiname);
	if (!datei.exists()) {
	    meinetexte = null;
	} else {
	    meinetexte = readArrayList();
	}
	if (meinetexte != null) {
	    panelZeichenflaeche.setArrayList(meinetexte);
	}
	datei.delete();
    }

    public ArrayList<Textausgabe> readArrayList() {
	ArrayList<Textausgabe> liste = new ArrayList<Textausgabe>();
	try {
	    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
		    dateiname));
	    liste = (ArrayList<Textausgabe>) ois.readObject();
	    ois.close();

	} catch (Exception e) {
	    JOptionPane.showMessageDialog(null, "Fehler beim Lesen aus Datei!");
	    liste = null;
	}
	return liste;
    }

    public void writeArrayList(ArrayList<Textausgabe> liste) {
	try {
	    ObjectOutputStream oos = new ObjectOutputStream(
		    new FileOutputStream(dateiname, true));
	    oos.writeObject(liste);
	    oos.flush();
	    oos.close();
	} catch (Exception e) {
	    e.printStackTrace();
	    JOptionPane.showMessageDialog(null,
		    "Fehler beim Schreiben in Datei.");
	}
    }

}
