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
import java.util.List;
import java.awt.event.ActionEvent;

import entity.Comment;
import entity.User;
import service.impl.ElectiveInfoServiceImpl;
import service.impl.Massage;
import service.impl.TeacherCommentServiceimpl;
public class searchComment {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	TeacherCommentServiceimpl service;

	private JLabel empty;

	public static void  main(String[] args) {
		new searchComment();
	}
	public searchComment( ) {
		initialize();
	}

	private boolean validate() {
		if(textField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "请输入教师ID", "错误",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else {
			if(textField.getText().length()!=4) {
				JOptionPane.showMessageDialog(null, "教师ID为4位", "错误",JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		if(textField_1.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "请输入课程ID", "错误",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void initialize() {

		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 334);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		empty = new JLabel();
		JLabel label = new JLabel("修改课程名单");
		
		JLabel lblid = new JLabel("教师ID");
		
		JLabel lblid_1 = new JLabel("课程ID");
		
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton button = new JButton("搜索");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button)
					if(validate()) {
						service = new TeacherCommentServiceimpl();
						List<Comment> list = service.findCommentListbyteacheridandclassid(textField.getText(),textField_1.getText());
						if(list.isEmpty()) {
							JOptionPane.showMessageDialog(null, "该老师没有此门课程评教", "错误",JOptionPane.ERROR_MESSAGE);
						}
						else {
							new C2(list);
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
							.addComponent(empty)
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
						.addComponent(empty))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}

}
