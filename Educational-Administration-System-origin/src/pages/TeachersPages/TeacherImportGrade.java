package pages.TeachersPages;

import java.awt.EventQueue;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import entity.ClassGrade;
import entity.User;
public class TeacherImportGrade extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;
	private JTextField textField_3;
	private ClassGrade grade1;
	public User u;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherImportGrade frame = new TeacherImportGrade();
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
	public TeacherImportGrade() {
		setTitle("教师成绩录入");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 397);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("学号");
		lblNewLabel_1.setBounds(58, 35, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(164, 29, 143, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblid = new JLabel("课程ID");
		lblid.setBounds(58, 71, 72, 18);
		contentPane.add(lblid);
		
		textField_2 = new JTextField();
		textField_2.setBounds(164, 68, 143, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label = new JLabel("成绩");
		label.setBounds(58, 115, 72, 18);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(164, 108, 142, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("排名");
		label_1.setBounds(59, 151, 72, 18);
		contentPane.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(164, 148, 147, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JCheckBox checkBox = new JCheckBox("需要补考");
		checkBox.setBounds(163, 195, 95, 27);
		contentPane.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("非补考");
		checkBox_1.setBounds(303, 195, 82, 27);
		contentPane.add(checkBox_1);
		
		JLabel label_2 = new JLabel("补考");
		label_2.setBounds(58, 198, 72, 18);
		contentPane.add(label_2);
		
		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				ClassGrade info = new ClassGrade() ;
				info.setStudent_id(textField_1.getText());
				info.setClass_id(textField_2.getText());
				info.setGrade(Float.parseFloat(textField.getText()));
				info.setRank(Integer.parseInt(textField_3.getText()));
				if(checkBox_1.isSelected())
				{
					info.setMakeup("NULL");
				}
				else if(checkBox.isSelected())
				{
					info.setMakeup("补考");
				}
				
			}
		});
		button.setBounds(78, 280, 113, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new teacher();
			}
		});
		button_1.setBounds(318, 280, 113, 27);
		contentPane.add(button_1);
	}
}
