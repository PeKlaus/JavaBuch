package gui11;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.miginfocom.swing.MigLayout;  // Miglayout muss erst eingebunden werden (Download der externen libary)

public class Bildbetrachter extends JFrame {

	private JPanel contentPane;
	private ImageComponent bild;
	private BufferedImage bufImg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bildbetrachter frame = new Bildbetrachter();
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
	public Bildbetrachter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow]", "[][grow]"));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 1,grow");
		
		bild = new ImageComponent();
		
		JButton btnBilddatiOeffnen = new JButton("Bilddatei \u00F6ffnen");
		btnBilddatiOeffnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				fc.setFileFilter(new FileNameExtensionFilter("*.jpg;*.gif","jpg","gif"));
				fc.setCurrentDirectory(new File("."));
				int status = fc.showOpenDialog(null);
				if (status == JFileChooser.APPROVE_OPTION) {
					String selFile = fc.getSelectedFile().getAbsolutePath();
					try {
						bufImg = ImageIO.read(new File(selFile));
						System.out.println(bufImg);
						bild.setImage(bufImg);
						scrollPane.setSize(bufImg.getWidth() + 2, bufImg.getHeight() + 2);
						scrollPane.setViewportView(bild);
						setSize(bufImg.getWidth() + 43, bufImg.getHeight() + 95);
						
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "Fehler beim öffnen der Datei!");
						ex.printStackTrace();
						
					}
				}
			}
		});
		contentPane.add(btnBilddatiOeffnen, "cell 0 0,width 130");
		
		
		try {
			bufImg = ImageIO.read(
//					(Bildbetrachter.class.getResource("/gui11/bewblau.jpg")));
					(getClass().getResource("/gui11/bewblau.jpg")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		bild.setImage(bufImg);
		scrollPane.setViewportView(bild);
	}
}
