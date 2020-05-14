package pages.StudentsPages;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import entity.Student;
import entity.User;
import service.impl.*;
import entity.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 评估new {
	public User user;
	public Student info;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { 评估new window = new 评估new(u);
	 * window.frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); }
	 * } }); }
	 */

	/**
	 * Create the application.
	 */
	public 评估new(User u) {
		initialize(u);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User u) {
		//System.out.println(u.getname());
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("教学评估");

		JLabel lblid = new JLabel("课程ID");

		JLabel label_1 = new JLabel("课程名字");

		JLabel lblid_1 = new JLabel("教师ID");

		JLabel label_2 = new JLabel("教师名字");

		JLabel label_3 = new JLabel("评价");

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

		JButton button = new JButton("评价");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (arg0.getSource() == button)
					try {
						StudentCommentServiceimpl service = new StudentCommentServiceimpl();
						Comment info = new Comment();
						info.setClass_id(textField.getText());
						info.setClass_name(textField_1.getText());
						info.setTeacher_id(textField_2.getText());
						info.setTeacher_name(textField_3.getText());
						info.setContent(textField_4.getText());
						info.setStudent_id(u.getname());
						int ans = service.add(info);
						if (ans == 1)
							JOptionPane.showMessageDialog(null, "评价成功");
						else if(ans ==2)
							JOptionPane.showMessageDialog(null, "评价过短");
						else
							JOptionPane.showMessageDialog(null, "评价失败");
						
						textField.setText(null);
						textField_1.setText(null);
						textField_2.setText(null);
						textField_3.setText(null);
						textField_4.setText(null);
					} catch (Exception e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "评价有误");
					}
			}
		});

		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button_1)
			//		new student(u);
				frame.setVisible(false);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup().addGap(91)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(label_1)
								.addComponent(lblid).addComponent(lblid_1).addComponent(label_2).addComponent(label_3))
						.addGap(27)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(label)
								.addGroup(groupLayout.createSequentialGroup().addGap(10)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(textField, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
												.addComponent(textField_1).addComponent(textField_2)
												.addComponent(textField_3).addComponent(textField_4)))))
						.addGroup(groupLayout.createSequentialGroup().addGap(123).addComponent(button).addGap(67)
								.addComponent(button_1)))
				.addContainerGap(43, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(29).addComponent(label).addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(lblid).addComponent(
						textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_1).addComponent(
						textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblid_1).addComponent(
						textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_2).addComponent(
						textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(label_3).addComponent(
						textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(52)
				.addGroup(
						groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(button).addComponent(button_1))
				.addContainerGap(67, Short.MAX_VALUE)));
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}
}
