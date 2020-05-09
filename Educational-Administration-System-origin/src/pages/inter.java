package pages;

import java.awt.*;
import javax.swing.*;

import entity.User;
import service.impl.UserServiceImpl;

import java.awt.event.*;

public class inter extends JFrame implements ActionListener {
	JPanel jp1, jp2, jp3, jp4;
	JLabel jlb1, jlb2, jlb3;
	JButton jb1, jb2;
	JTextField jtf1;
	JPasswordField jpf1;
	JCheckBox jcb1, jcb2, jcb3;

	public static void main(String[] args) {
		inter d1 = new inter();
	}

	// 构造函数
	public inter() {

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();

		jlb1 = new JLabel("用户名");
		jlb2 = new JLabel("密    码");

		jb1 = new JButton("登录");
		jb2 = new JButton("取消");

		jtf1 = new JTextField(10);

		jpf1 = new JPasswordField(10);// 设置布局管理
		this.setLayout(new GridLayout(4, 1));
		jlb3 = new JLabel("身份");
		jcb1 = new JCheckBox("管理员");
		jcb2 = new JCheckBox("教师");
		jcb3 = new JCheckBox("学生");
		// 下面可以设置单选
		ButtonGroup bg2 = new ButtonGroup();
		bg2.add(jcb1);
		bg2.add(jcb2);
		bg2.add(jcb3);

		// 加入各个组件
		jp1.add(jlb1);
		jp1.add(jtf1);

		jp2.add(jlb2);
		jp2.add(jpf1);

		jp3.add(jlb3);
		jp3.add(jcb1);
		jp3.add(jcb2);
		jp3.add(jcb3);

		jp4.add(jb1);
		jp4.add(jb2);

		jb1.addActionListener(this);
		jb2.addActionListener(this);

		// 加入到JFrame
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.setSize(500, 400);
		this.setTitle("登录");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		/*
		 * 设置在桌面中间出现
		 */
		int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 500) / 2;
		int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 400) / 2;
		this.setLocation(w, h);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent ev)// 为按钮添加的注册事件
	{
		if (ev.getSource() == jb1) {
			if (jcb1.isSelected() || jcb2.isSelected() || jcb3.isSelected()) {
				UserServiceImpl login = new UserServiceImpl();
				User get = login.findByName(jtf1.getText());
				if (get != null) {
					if (jcb1.isSelected()) {
						if (get.getpassword().equals(new String(jpf1.getPassword())) && get.gettype().equals("管理员")) {
							new manager();
							this.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "密码错误", "错误提示", JOptionPane.ERROR_MESSAGE);
						}
					}
					if (jcb2.isSelected()) {
						if (get.getpassword().equals(new String(jpf1.getPassword())) && get.gettype().equals("教师")) {
							new teacher();
							this.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "密码错误", "错误提示", JOptionPane.ERROR_MESSAGE);
						}
					}
					if (jcb3.isSelected()) {
						if (get.getpassword().equals(new String(jpf1.getPassword())) && get.gettype().equals("学生")) {
							new student();
							this.setVisible(false);
						} else {
							JOptionPane.showMessageDialog(null, "密码错误", "错误提示", JOptionPane.ERROR_MESSAGE);
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "账户错误", "错误提示", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "未选择身份", "错误提示", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (ev.getSource() == jb2) {
			System.exit(-1);
		}
	}
}
