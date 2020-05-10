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
public class ClassInformation extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public User u;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassInformation frame = new ClassInformation();
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
	public ClassInformation() {
		setTitle("课程信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 521, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("课程信息");
		label.setBounds(46, 37, 72, 18);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(131, 34, 269, 130);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("上课时间");
		label_1.setBounds(46, 197, 72, 18);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(131, 198, 269, 151);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeacherVisitClassInfo();
			}
		});
		button.setBounds(200, 378, 113, 27);
		contentPane.add(button);
	}

}
