package pages.TeachersPages;

import java.awt.BorderLayout;
import entity.User;
import java.awt.EventQueue;
import pages.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import entity.ClassInfo;
public class ImportClassInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private User u;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImportClassInfo frame = new ImportClassInfo();
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
	public ImportClassInfo() {
		setTitle("课程信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("课程ID");
		lblNewLabel.setBounds(29, 13, 72, 18);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(100, 10, 193, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("课程名");
		label.setBounds(29, 59, 72, 18);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 56, 193, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblid = new JLabel("教师ID");
		lblid.setBounds(29, 104, 72, 18);
		contentPane.add(lblid);
		
		textField_2 = new JTextField();
		textField_2.setBounds(100, 101, 193, 24);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_1 = new JLabel("教师姓名");
		label_1.setBounds(29, 154, 72, 18);
		contentPane.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(100, 151, 193, 24);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("客容量");
		lblNewLabel_1.setBounds(29, 203, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(100, 200, 193, 24);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("开课周");
		lblNewLabel_2.setBounds(336, 104, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		textField_5 = new JTextField();
		textField_5.setBounds(422, 101, 156, 24);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_2 = new JLabel("结束周");
		label_2.setBounds(336, 154, 72, 18);
		contentPane.add(label_2);
		
		textField_6 = new JTextField();
		textField_6.setBounds(422, 151, 156, 24);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_3 = new JLabel("开课学年");
		label_3.setBounds(336, 13, 72, 18);
		contentPane.add(label_3);
		
		textField_7 = new JTextField();
		textField_7.setBounds(422, 10, 156, 24);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel label_4 = new JLabel("学分");
		label_4.setBounds(336, 59, 72, 18);
		contentPane.add(label_4);
		
		textField_8 = new JTextField();
		textField_8.setBounds(422, 56, 156, 24);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ClassInfo info = new ClassInfo();
				info.setId(textField.getText());
				info.setName(textField_1.getText());
				info.setTeacher_id(textField_2.getText());
				info.setTeacher_name(textField_3.getText());
				info.setCapacity(Integer.parseInt(textField_4.getText()));
				info.setStart_week(Integer.parseInt(textField_5.getText()));
				info.setEnd_week(Integer.parseInt(textField_6.getText()));
				info.setCredit(Integer.parseInt(textField_8.getText()));
				info.setYear(textField_7.getText());
				
			}
		});
		button.setBounds(129, 301, 113, 27);
		contentPane.add(button);
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new teacher();
			}
		});
		button_1.setBounds(401, 301, 113, 27);
		contentPane.add(button_1);
	}
}
