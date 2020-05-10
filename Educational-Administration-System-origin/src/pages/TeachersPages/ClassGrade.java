package pages.TeachersPages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClassGrade extends JFrame {

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
					ClassGrade frame = new ClassGrade();
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
	public ClassGrade() {
		setTitle("课程成绩");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("课程ID");
		lblid.setBounds(12, 32, 72, 18);
		contentPane.add(lblid);
		
		textField = new JTextField();
		textField.setBounds(88, 26, 219, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("课程成绩");
		label.setBounds(12, 80, 72, 18);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(88, 80, 331, 169);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.setBounds(166, 262, 63, 27);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TeacherVisitGrade();
			}
		});
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(452, 12, 21, 282);
		contentPane.add(scrollBar);
		contentPane.add(btnNewButton);
	}
}
