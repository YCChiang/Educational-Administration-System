package pages.TeachersPages;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import entity.User;
public class TeacherVisitComment extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	public User u;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TeacherVisitComment(User user) {
		u = user;
		setTitle("课程评价查询");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid_1 = new JLabel("教师ID");
		lblid_1.setBounds(75, 64, 72, 18);
		contentPane.add(lblid_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(181, 61, 145, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeacherCommentInfo(u);
			}
		});
		button.setBounds(57, 186, 113, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new teacher(u);
			}
		});
		button_1.setBounds(241, 186, 113, 27);
		contentPane.add(button_1);
		this.setVisible(true);
	}

}
