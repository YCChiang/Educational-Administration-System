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

public class TeacherVisitComment extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherVisitComment frame = new TeacherVisitComment();
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
	public TeacherVisitComment() {
		setTitle("课程评价查询");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("课程ID");
		lblid.setBounds(73, 42, 72, 18);
		contentPane.add(lblid);
		
		textField = new JTextField();
		textField.setBounds(176, 39, 145, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblid_1 = new JLabel("教师ID");
		lblid_1.setBounds(73, 91, 72, 18);
		contentPane.add(lblid_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(176, 88, 145, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeacherCommentInfo();
			}
		});
		button.setBounds(57, 186, 113, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new teacher();
			}
		});
		button_1.setBounds(241, 186, 113, 27);
		contentPane.add(button_1);
		
		JLabel lblNewLabel = new JLabel("学生ID");
		lblNewLabel.setBounds(73, 140, 72, 18);
		contentPane.add(lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setBounds(176, 137, 145, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}

}
