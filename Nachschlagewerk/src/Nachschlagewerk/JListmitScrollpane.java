package Nachschlagewerk;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class JListmitScrollpane extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JListmitScrollpane frame = new JListmitScrollpane();
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
	public JListmitScrollpane() {
		setTitle("JListmitScrollpane");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// es gehen auch andere Layouts
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		//Einen JscrollPane anlegen aus Container
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		
		//Eine JListBeispiel in den JScrollPane (Container) einfügen
		
		JList list = new JList();
		scrollPane.setViewportView(list);
	}

}
