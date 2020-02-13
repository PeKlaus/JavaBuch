package gui11;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FrameMitBild1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMitBild1 frame = new FrameMitBild1();
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
	public FrameMitBild1() {
		setTitle("Frame mit Bild");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrameMitBild1.class.getResource("/gui11/HPH1.JPG")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(FrameMitBild1.class.getResource("/gui11/gardaseeoel1.jpg")));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		JButton btnEnde = new JButton("Ende");
		btnEnde.setPressedIcon(new ImageIcon(FrameMitBild1.class.getResource("/gui11/HPH1.JPG")));
		btnEnde.setRolloverIcon(new ImageIcon(FrameMitBild1.class.getResource("/gui11/HPH21.gif")));
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEnde.setRolloverSelectedIcon(null);
		btnEnde.setIcon(new ImageIcon(FrameMitBild1.class.getResource("/gui11/HPH31.GIF")));
		contentPane.add(btnEnde, BorderLayout.NORTH);
	}

}
