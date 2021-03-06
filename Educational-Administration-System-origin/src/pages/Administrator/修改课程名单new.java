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
import entity.User;
import service.impl.ElectiveInfoServiceImpl;
import service.impl.Massage;
public class 修改课程名单new {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	ElectiveInfoServiceImpl electiveinfoservice;
	public User u;

	public 修改课程名单new(User user) {
		initialize(user);
	}

	private boolean validate() {
		if(textField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "请输入学生ID", "错误",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else {
			if(textField.getText().length()!=10) {
				JOptionPane.showMessageDialog(null, "学生ID为10位", "错误",JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		if(textField_1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "请输入课程ID", "错误",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void initialize(User u1) {

		 electiveinfoservice = new ElectiveInfoServiceImpl();
		u = u1;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 334);
	//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("修改课程名单");
		
		JLabel lblid = new JLabel("学生ID");
		
		JLabel lblid_1 = new JLabel("课程ID");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton button = new JButton("插入");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button)
					if(validate()) {
						Massage msg = electiveinfoservice.elective(textField_1.getText(), textField.getText());
						if(msg.isError()) {
							JOptionPane.showMessageDialog(null, msg.getContent(), "错误",JOptionPane.ERROR_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, msg.getContent());
						}
						textField.setText(null);
						textField_1.setText(null);
					}					
			}
		});
		
		JButton button_1 = new JButton("删除");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button_1)
					if(validate()) {
						Massage msg = electiveinfoservice.quit(textField_1.getText(), textField.getText());
						if(msg.isError()) {
							JOptionPane.showMessageDialog(null, msg.getContent(), "错误",JOptionPane.ERROR_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, msg.getContent());
						}
						textField.setText(null);
						textField_1.setText(null);
					}	
			}
		});
		
		JButton button_2 = new JButton("返回");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	new manager(u);
				frame.setVisible(false);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(182, Short.MAX_VALUE)
					.addComponent(label)
					.addGap(178))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(89)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(button)
							.addGap(57)
							.addComponent(button_1)
							.addGap(54)
							.addComponent(button_2))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblid)
								.addComponent(lblid_1))
							.addGap(43)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_1)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(30)
					.addComponent(label)
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblid)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblid_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_2)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}

}
