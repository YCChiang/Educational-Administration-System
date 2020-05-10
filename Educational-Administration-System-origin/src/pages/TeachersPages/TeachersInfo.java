package pages.TeachersPages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JTable;
import entity.User;
public class TeachersInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	public User u;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TeachersInfo(User user) {
		u = user;
		setBackground(Color.CYAN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setTitle("教师个人信息");
		
		textField = new JTextField();
		textField.setBounds(95, 23, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("姓名：");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setBounds(14, 26, 72, 18);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(95, 60, 86, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblid = new JLabel("教师ID：");
		lblid.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblid.setForeground(new Color(0, 0, 0));
		lblid.setBounds(14, 66, 72, 18);
		contentPane.add(lblid);
		
		JLabel label = new JLabel("性别：");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label.setBounds(14, 102, 72, 18);
		contentPane.add(label);
		
		textField_2 = new JTextField();
		textField_2.setBounds(95, 99, 86, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("学院：");
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(14, 138, 75, 18);
		contentPane.add(lblNewLabel_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(95, 136, 86, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_1 = new JLabel("电话号码：");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_1.setBounds(14, 182, 72, 18);
		contentPane.add(label_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(95, 180, 86, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_2 = new JLabel("职称：");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		label_2.setBounds(14, 222, 72, 18);
		contentPane.add(label_2);
		
		textField_5 = new JTextField();
		textField_5.setBounds(95, 220, 86, 24);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton button_2 = new JButton("返回");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new teacher(u);
			}
		});
		button_2.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		button_2.setBounds(282, 98, 113, 27);
		contentPane.add(button_2);
		this.setVisible(true);
	}
}
