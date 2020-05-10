package pages.Administrator;

import java.awt.Toolkit;

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

import entity.Student;
import entity.User;
import service.impl.studentinfoserviceimpl;

public class 查询学生信息new implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	public User u;
	JButton button;
	JButton button_1;

	public 查询学生信息new(User u1) {
		u = u1;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 450) / 2;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 300) / 2;
		this.frame.setLocation(w, h);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("查询学生信息");

		JLabel lblid = new JLabel("输入学生ID");

		textField = new JTextField();
		textField.setColumns(10);

		button = new JButton("查询");
		button.addActionListener(this);

		button_1 = new JButton("返回");
		button_1.addActionListener(this);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup().addGap(166).addComponent(label))
						.addGroup(groupLayout.createSequentialGroup().addGap(65).addComponent(lblid).addGap(50)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING,
								groupLayout.createSequentialGroup().addGap(96).addComponent(button)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(button_1)))
				.addContainerGap(74, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(27).addComponent(label).addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblid).addComponent(
						textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
				.addGroup(
						groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(button_1).addComponent(button))
				.addGap(41)));
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button) {
			studentinfoserviceimpl service = new studentinfoserviceimpl();
			Student student = service.findById(textField.getText());
			if (student == null) {
				JOptionPane.showMessageDialog(null, "没有此学生");
			} else
				new student_select_info(student);
		} else if (e.getSource() == button_1) {
			new manager(u);
			this.frame.dispose();
		}
	}

}
