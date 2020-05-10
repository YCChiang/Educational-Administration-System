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
public class TeacherVisitGrade extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public User u;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TeacherVisitGrade(User user) {
		u = user;
		setTitle("成绩查询");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("课程ID");
		lblid.setBounds(84, 46, 72, 18);
		contentPane.add(lblid);
		
		textField = new JTextField();
		textField.setBounds(170, 43, 172, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ClassGrade(u);
			}
		});
		button.setBounds(66, 152, 113, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new teacher(u);
			}
		});
		button_1.setBounds(246, 152, 113, 27);
		contentPane.add(button_1);
		this.setVisible(true);
	}

}
