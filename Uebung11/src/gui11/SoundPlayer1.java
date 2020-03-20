package gui11;

/*
 * Programm SoundPlayer
 * Über einen Dateiauswahldialog kann eine Sounddatei (wav)
 * geladen werden. Die Sounddatei kann einmalig oder in
 * einer Schleife abgespielt werden.
 * 
 * @author Hans-Peter Habelitz
 * @date 2014-10-05
 */

import java.awt.EventQueue;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.miginfocom.swing.MigLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class SoundPlayer1 extends JFrame {

    private JPanel contentPane;
    private Clip audioClip;
    private JButton btnEinmal;
    private JButton btnSounddateiOeffnen;
    private JButton btnSchleife;
    private JButton btnStop;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    SoundPlayer1 frame = new SoundPlayer1();
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
    public SoundPlayer1() {
	setTitle("SoundPlayer1");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 388, 227);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(new MigLayout("", "[grow]30[grow]",
		"[grow]30[grow]30[grow]10"));

	btnSounddateiOeffnen = new JButton("Sounddatei \u00F6ffnen");
	btnSounddateiOeffnen.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		fc.setFileFilter(new FileNameExtensionFilter("*.wav", "wav"));
		fc.setCurrentDirectory(new File("C:\\Windows\\Media\\"));
		int status = fc.showOpenDialog(null);
		if (status == JFileChooser.APPROVE_OPTION) {
		    btnSchleife.setEnabled(true);
		    btnEinmal.setEnabled(true);
		    try {
			audioClip = AudioSystem.getClip();
			AudioInputStream ais = AudioSystem
				.getAudioInputStream(fc.getSelectedFile());
			audioClip.open(ais);
			btnEinmal.setEnabled(true);
			btnSchleife.setEnabled(true);
			btnStop.setEnabled(false);
		    } catch (Exception ex) {
			JOptionPane.showMessageDialog(null,
				"Fehler beim Öffnen der datei!");
		    }
		}
	    }
	});
	contentPane.add(btnSounddateiOeffnen, "cell 0 0, grow");

	btnEinmal = new JButton("Sound einmal abspielen");
	btnEinmal.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		audioClip.loop(1);
	    }
	});
	btnEinmal.setEnabled(false);
	contentPane.add(btnEinmal, "cell 0 1, grow");

	btnSchleife = new JButton("Sound in einer Schleife abspielen");
	btnSchleife.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		btnStop.setEnabled(true);
		audioClip.loop(Clip.LOOP_CONTINUOUSLY);
	    }
	});
	btnSchleife.setEnabled(false);
	contentPane.add(btnSchleife, "cell 0 2, grow");

	btnStop = new JButton("Stop");
	btnStop.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		audioClip.stop();
		btnStop.setEnabled(false);
	    }
	});
	btnStop.setEnabled(false);
	contentPane.add(btnStop, "cell 1 2, grow");
    }

}