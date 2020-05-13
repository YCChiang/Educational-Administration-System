package pages.Administrator;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import entity.Teacher;
import entity.User;
import service.impl.administratorinfomationServiceimpl;

public class 导入教师信息new {

	private JFrame frame;
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
	 * Create the application.
	 */
	public 导入教师信息new(User user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User u1) {
		u = u1;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 427);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("导入教师信息");

		JLabel lblid = new JLabel("教师工号");

		JLabel label_1 = new JLabel("教师姓名");

		JLabel label_2 = new JLabel("性别");

		JLabel label_3 = new JLabel("学院");

		JLabel label_4 = new JLabel("职称");

		JLabel label_5 = new JLabel("电话号码");

		textField = new JTextField();
		textField.setColumns(10);

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

		JButton button = new JButton("导入");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == button)
					try {
						administratorinfomationServiceimpl service = new administratorinfomationServiceimpl();
						Teacher info = new Teacher();
						info.setId(textField.getText());
						if(textField.getText().length()!=4) {
							JOptionPane.showMessageDialog(null, "教师工号为4位整数", "错误提示",	JOptionPane.ERROR_MESSAGE);
							return;
						}
						info.setName(textField_1.getText());
						if(textField_1.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "请输入教师姓名", "错误提示",	JOptionPane.ERROR_MESSAGE);
							return;
						}
						
						if(textField_2.getText().equals("男"))
							info.setGender(1);
						else if(textField_2.getText().equals("女"))
							info.setGender(0);
						else {
							JOptionPane.showMessageDialog(null, "请输入正确性别(男/女)", "错误提示",	JOptionPane.ERROR_MESSAGE);
							return;
						}
						info.setDepartment(textField_3.getText());
						if(textField_3.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "请输入学院", "错误提示",	JOptionPane.ERROR_MESSAGE);
							return;
						}
						info.setTitle(textField_4.getText());
						if(textField_4.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "请输入正确职称", "错误提示",	JOptionPane.ERROR_MESSAGE);
							return;
						}
						info.setTel(textField_5.getText());
						int ans = service.addTeacher(info);
						if(ans == 1) {
							JOptionPane.showMessageDialog(null, "插入成功");
						}
						else if(ans == 2)
							JOptionPane.showMessageDialog(null, "工号冲突");
						else if(ans == 0)
							JOptionPane.showMessageDialog(null, "插入失败，请查看数据库");
						textField.setText(null);
						textField_1.setText(null);
						textField_2.setText(null);
						textField_3.setText(null);
						textField_4.setText(null);
						textField_5.setText(null);
					} catch (Exception e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "请输入正确数据", "错误提示",	JOptionPane.ERROR_MESSAGE);
					}
			}
		});

		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button_1)
			//		new manager(u);
					frame.setVisible(false);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING,
						groupLayout.createSequentialGroup().addContainerGap(186, Short.MAX_VALUE).addComponent(label)
								.addGap(174))
				.addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout
						.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING,
								groupLayout.createSequentialGroup().addGap(134).addComponent(button)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(button_1))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addGap(133)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblid)
										.addComponent(label_1).addComponent(label_2).addComponent(label_3)
										.addComponent(label_4).addComponent(label_5))
								.addGap(31)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textField_5).addComponent(textField_4).addComponent(textField_3)
										.addComponent(textField_2).addComponent(textField_1)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))))
						.addContainerGap(101, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(23).addComponent(label).addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblid))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_2)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_3)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_4)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_5)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE).addGroup(groupLayout
								.createParallelGroup(Alignment.BASELINE).addComponent(button).addComponent(button_1))
						.addGap(30)));
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}

}
