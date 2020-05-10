package pages.Administrator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import entity.ProfProgram;
import entity.User;
import service.impl.profprogramServiceimpl;
public class 导入培养方案new {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public User u;
	
	public 导入培养方案new(User user) {
		initialize(user);
	}

	private void initialize(User u1) {
		u = u1;
		frame = new JFrame();
		frame.setBounds(100, 100, 475, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("导入培养方案");
		
		JLabel label_1 = new JLabel("专业");
		
		JLabel lblid = new JLabel("课程ID");
		
		JLabel label_2 = new JLabel("课程名");
		
		JLabel label_3 = new JLabel("学分");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JButton button = new JButton("导入");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button)
				{
					try {
					//JOptionPane.showMessageDialog(null, "导入成功");
						ProfProgram PP = new ProfProgram();
						PP.setSpecialty(textField_1.getText());
						PP.setClass_id(textField_2.getText());
						PP.setClass_name(textField_3.getText());
						PP.setCredit(Integer.valueOf(textField_4.getText()));
						profprogramServiceimpl service = new profprogramServiceimpl();
						int ans = service.add(PP);
						if(ans == 1)
							JOptionPane.showMessageDialog(null, "插入成功");
						else
							JOptionPane.showMessageDialog(null, "插入失败，请检查数据库");
					textField_1.setText(null);
					textField_2.setText(null);
					textField_3.setText(null);
					textField_4.setText(null);
					}catch(Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "请输入正确数据");
					}
				}
			}
		});
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button_1)
				{
					frame.setVisible(false);
					new manager(u);
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(123)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(label_3)
										.addComponent(label_1)
										.addComponent(lblid, Alignment.TRAILING))
									.addGap(16))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addGap(18)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(10)
									.addComponent(label))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(18)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_2)
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
										.addComponent(textField_3)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(141)
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(button_1)))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(label)
					.addGap(34)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblid))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(24))
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}
}
