package pages.Administrator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
		u = u1;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

		JLabel label_7 = new JLabel("家庭地址");

		JLabel label_8 = new JLabel("电话号码");

		JLabel label_9 = new JLabel("入学时间");

		textField_1 = new JTextField();
		textField_1.setColumns(10);

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

		textField_7 = new JTextField();
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setColumns(10);

		textField_9 = new JTextField();
		textField_9.setColumns(10);

		JButton button = new JButton("导入");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == button) {
					try {
						Student info = new Student();
						info.setId(textField_1.getText());
						info.setName(textField.getText());
						if (textField_2.getText().equals("男"))
							info.setGender(1);
						else
							info.setGender(0);
						info.setDepartment(textField_3.getText());
						info.setSpecialty(textField_4.getText());
						info.setClassinfo(textField_5.getText());
						info.setAge(Integer.parseInt(textField_6.getText()));
						info.setAdmission_time(Integer.parseInt(textField_9.getText()));
						info.setAddress(textField_7.getText());
						info.setTel(textField_8.getText());

						administratorinfomationServiceimpl service = new administratorinfomationServiceimpl();
						if (service.addStudent(info) == 1)
							JOptionPane.showMessageDialog(null, "导入成功");
						else if (service.addStudent(info) == 0) {
							JOptionPane.showMessageDialog(null, "导入失败,查看数据库相关问题");
						} else if (service.addStudent(info) == 2)
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
						JOptionPane.showMessageDialog(null, "请输入正确数据");
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
			new manager(u);
			this.frame.dispose();
		}
	}
}
