package pages.TeachersPages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import entity.User;
public class TeacherClass extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private User u;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TeacherClass(User user) {
		u = user;
		setTitle("教师课程表");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("本学期教师课程表");
		label.setBounds(211, 24, 140, 18);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(48, 55, 446, 201);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new teacher(u);
			}
		});
		button.setBounds(225, 287, 113, 27);
		contentPane.add(button);
		this.setVisible(true);
	}

}
