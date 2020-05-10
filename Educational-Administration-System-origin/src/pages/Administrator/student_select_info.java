package pages.Administrator;

import java.awt.Toolkit;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import entity.Student;

public class student_select_info implements ActionListener {

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
	JButton button;

	public student_select_info(Student info) {
		frame = new JFrame();
		frame.setBounds(100, 100, 439, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 439) / 2;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 560) / 2;
		this.frame.setLocation(w, h);

		JLabel label = new JLabel("学生个人信息");

		JLabel label_1 = new JLabel("姓名");

		textField = new JTextField(info.getName());
		textField.setColumns(10);

		JLabel lblid = new JLabel("学号");

		JLabel label_2 = new JLabel("性别");

		JLabel label_3 = new JLabel("学院");

		JLabel label_4 = new JLabel("专业");

		JLabel label_5 = new JLabel("班级");

		JLabel label_6 = new JLabel("年龄");

		JLabel label_7 = new JLabel("家庭住址");

		JLabel label_8 = new JLabel("电话号码");

		JLabel label_9 = new JLabel("入学时间");

		button = new JButton("返回");
		button.addActionListener(this);

		textField_1 = new JTextField(info.getId());
		textField_1.setColumns(10);
		if (info.getGender() == 0)
			textField_2 = new JTextField("女");
		else
			textField_2 = new JTextField("男");

		textField_2.setColumns(10);

		textField_3 = new JTextField(info.getDepartment());
		textField_3.setColumns(10);

		textField_4 = new JTextField(info.getSpecialty());
		textField_4.setColumns(10);

		textField_5 = new JTextField(info.getClassinfo());
		textField_5.setColumns(10);

		textField_6 = new JTextField(String.valueOf(info.getAge()));
		textField_6.setColumns(10);

		textField_7 = new JTextField(info.getAddress());
		textField_7.setColumns(10);

		textField_8 = new JTextField(info.getTel());
		textField_8.setColumns(10);

		textField_9 = new JTextField(String.valueOf(info.getAdmission_time()));
		textField_9.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(179).addComponent(label))
						.addGroup(groupLayout.createSequentialGroup().addGap(125)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(label_1)
										.addComponent(lblid).addComponent(label_2).addComponent(label_3)
										.addComponent(label_4).addComponent(label_5).addComponent(label_6)
										.addComponent(label_7).addComponent(label_8).addComponent(label_9))
								.addGap(21)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textField_9).addComponent(textField_8).addComponent(textField_7)
										.addComponent(textField_6).addComponent(textField_5).addComponent(textField_4)
										.addComponent(textField_3).addComponent(textField_2).addComponent(textField_1)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))))
				.addContainerGap(101, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(196, Short.MAX_VALUE).addComponent(button)
						.addGap(162)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(24).addComponent(label).addGap(18)
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
				.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE).addComponent(button)));
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button) {
			// new manager(u);
			this.frame.dispose();
		}
	}
}
