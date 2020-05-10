package pages.Administrator;

import java.awt.BorderLayout;
import entity.User;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JLabel;

public class OutComment extends JFrame {

	private JPanel contentPane;
	public User u;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public OutComment(User user) {
		setTitle("课程评价信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(14, 50, 420, 221);
		contentPane.add(textArea);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(448, 0, 21, 305);
		contentPane.add(scrollBar);
		
		JLabel label = new JLabel("课程评价信息");
		label.setBounds(183, 19, 128, 18);
		contentPane.add(label);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setOrientation(JScrollBar.HORIZONTAL);
		scrollBar_1.setBounds(0, 284, 444, 21);
		contentPane.add(scrollBar_1);
	}
}
