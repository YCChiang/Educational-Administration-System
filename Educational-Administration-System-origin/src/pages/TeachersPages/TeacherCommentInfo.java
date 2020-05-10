package pages.TeachersPages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeacherCommentInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherCommentInfo frame = new TeacherCommentInfo();
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
	public TeacherCommentInfo() {
		setTitle("教师课程评价");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("课程ID");
		lblid.setBounds(38, 32, 72, 18);
		contentPane.add(lblid);
		
		textField = new JTextField();
		textField.setBounds(140, 29, 221, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("课程评价");
		label.setBounds(38, 76, 72, 18);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(140, 73, 288, 145);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeacherVisitComment();
			}
		});
		button.setBounds(198, 249, 113, 27);
		contentPane.add(button);
	}

}
