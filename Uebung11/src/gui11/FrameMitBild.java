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

public class FrameMitBild extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMitBild frame = new FrameMitBild();
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
	public FrameMitBild() {
		setTitle("Frame mit Bild");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.RIGHT);	
		lblNewLabel.setIcon(new ImageIcon(FrameMitBild.class.getResource("/gui11/gardaseeoel.jpg")));
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		JButton btnEnde = new JButton("Ende");
		btnEnde.setIcon(new ImageIcon(FrameMitBild.class.getResource("/gui11/HPH3.GIF")));
		btnEnde.setRolloverIcon(new ImageIcon(FrameMitBild.class.getResource("/gui11/HPH.JPG")));
		btnEnde.setPressedIcon(new ImageIcon(FrameMitBild.class.getResource("/gui11/HPH2.gif")));
		btnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		contentPane.add(btnEnde, BorderLayout.NORTH);
	}

}
