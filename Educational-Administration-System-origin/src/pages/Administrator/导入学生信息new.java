package pages.Administrator;


import java.awt.Toolkit;


import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import entity.Student;
import entity.User;
import service.impl.administratorinfomationServiceimpl;

public class 导入学生信息new implements ActionListener {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	JButton button_1;
	public User u;
	administratorinfomationServiceimpl service;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
//	public 导入学生信息new(User user) {
//		initialize(user);
//	}

	/**
	 * Initialize the contents of the frame.
	 */
	public 导入学生信息new(User u1) {
		service = new administratorinfomationServiceimpl();
		u = u1;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 580);
	//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 450) / 2;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 580) / 2;
		this.frame.setLocation(w, h);


		JLabel label = new JLabel("导入学生信息");

		JLabel label_1 = new JLabel("姓名");

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblid = new JLabel("学号");

		JLabel label_2 = new JLabel("性别");

		JLabel label_3 = new JLabel("学院");

		JLabel label_4 = new JLabel("专业");

		JLabel label_5 = new JLabel("班级");

		JLabel label_6 = new JLabel("年龄");

		JLabel label_7 = new JLabel("家庭地址(可空)");

		JLabel label_8 = new JLabel("电话号码(可空)");

		JLabel label_9 = new JLabel("入学时间");

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); // 获取键盘输入的字符
				if (Character.isDigit(c)) // 判断输入是否是数字
					return; // true,返回
				e.consume(); // false,消毁不匹配的输入
		}});

		textField_2 = new JTextField();
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); // 获取键盘输入的字符
				if (Character.isDigit(c)) // 判断输入是否是数字
					return; // true,返回
				e.consume(); // false,消毁不匹配的输入
		}});

		textField_7 = new JTextField();
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); // 获取键盘输入的字符
				if (Character.isDigit(c)) // 判断输入是否是数字
					return; // true,返回
				e.consume(); // false,消毁不匹配的输入
		}});

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); // 获取键盘输入的字符
				if (Character.isDigit(c)) // 判断输入是否是数字
					return; // true,返回
				e.consume(); // false,消毁不匹配的输入
		}});

		JButton button = new JButton("导入");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == button) {
					try {						
						if(textField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "请输入姓名", "错误提示",	JOptionPane.ERROR_MESSAGE);
							return;
						}
						if(textField_1.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "请输入学号", "错误提示",	JOptionPane.ERROR_MESSAGE);
							return;
						}
						if(textField_3.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "请输入院系", "错误提示",	JOptionPane.ERROR_MESSAGE);
							return;
						}
						if(textField_4.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "请输入专业信息", "错误提示",	JOptionPane.ERROR_MESSAGE);
							return;
						}
						if(textField_5.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "请输入班级信息", "错误提示",	JOptionPane.ERROR_MESSAGE);
							return;
						}
						if(textField_6.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "请输入年龄(整数)", "错误提示",	JOptionPane.ERROR_MESSAGE);
							return;
						}
						if(textField_9.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "请输入入学时间(整数)", "错误提示",	JOptionPane.ERROR_MESSAGE);
							return;
						}
						
						
						String id = textField_1.getText();				
						int age = Integer.parseInt(textField_6.getText());
						int year = Integer.parseInt(textField_9.getText());
						if(id.length() != 10) {
							JOptionPane.showMessageDialog(null, "学生学号必须为10位数字", "错误提示",	JOptionPane.ERROR_MESSAGE);
							return;
						}
						if(age<0 || age>100) {
							JOptionPane.showMessageDialog(null, "学生年龄在0-100之间", "错误提示",	JOptionPane.ERROR_MESSAGE);
							return;
						}
						if(year<1000 || year >= 10000) {
							JOptionPane.showMessageDialog(null, "学生入学年份为4位数", "错误提示",	JOptionPane.ERROR_MESSAGE);
							return;
						}
						
						Student info = new Student();
						info.setId(id);
						info.setName(textField.getText());
						if (textField_2.getText().equals("男"))
							info.setGender(1);
						else if(textField_2.getText().equals("女"))
							info.setGender(0);
						else {
							JOptionPane.showMessageDialog(null, "请输入正确性别格式:男/女", "错误提示",	JOptionPane.ERROR_MESSAGE);
							return;
						}
						info.setDepartment(textField_3.getText());						
						info.setSpecialty(textField_4.getText());
						info.setClassinfo(textField_5.getText());						
						info.setAge(age);
						info.setAdmission_time(year);						
						info.setAddress(textField_7.getText());
						info.setTel(textField_8.getText());

						int ans = service.addStudent(info);
						if (ans == 1)
							JOptionPane.showMessageDialog(null, "导入成功");
						else if (ans == 0) {
							JOptionPane.showMessageDialog(null, "导入失败,查看数据库相关问题");
						} else if (ans == 2)
							JOptionPane.showMessageDialog(null, "学号被占用,请修改");
						textField.setText(null);
						textField_1.setText(null);
						textField_2.setText(null);
						textField_3.setText(null);
						textField_4.setText(null);
						textField_5.setText(null);
						textField_6.setText(null);
						textField_7.setText(null);
						textField_8.setText(null);
						textField_9.setText(null);

					} catch (Exception e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "请输入正确数据", "错误提示",	JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		button_1 = new JButton("返回");
		button_1.addActionListener(this);

		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(170).addComponent(label))
						.addGroup(groupLayout.createSequentialGroup().addGap(137).addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(label_7).addGap(18)
										.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addComponent(label_8).addGap(18)
										.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup().addComponent(label_9).addGap(18)
										.addComponent(textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout
												.createParallelGroup(Alignment.LEADING).addComponent(label_1)
												.addComponent(lblid).addComponent(label_2).addComponent(label_3)
												.addComponent(label_4).addComponent(label_5).addComponent(label_6))
										.addGap(31)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(textField_6, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_5, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_4, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_3, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_2, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
				.addContainerGap(131, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING,
						groupLayout.createSequentialGroup().addGap(109).addComponent(button)
								.addPreferredGap(ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
								.addComponent(button_1).addGap(79)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(21).addComponent(label).addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_1).addComponent(
						textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblid).addComponent(
						textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_2).addComponent(
						textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_3).addComponent(
						textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_4).addComponent(
						textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_5).addComponent(
						textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_6).addComponent(
						textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_7).addComponent(
						textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_8).addComponent(
						textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_9).addComponent(
						textField_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
				.addGroup(
						groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(button).addComponent(button_1))
				.addContainerGap()));
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button_1) {
		//	new manager(u);
			this.frame.dispose();
		}
	}
}
