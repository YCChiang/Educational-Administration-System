package pages.StudentsPages;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import entity.User;

public class 课程成绩new {

	private JFrame frame;
	private JTextField textField;
	public User user;

	public 课程成绩new(User u) {
		initialize(u);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User u) {
		user = u;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 354);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("课程成绩");
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button)
				{
					frame.setVisible(false);
					new student(user);
					
				}
			}
		});
		
		JLabel lblid = new JLabel("学生ID");
		
		JLabel label_1 = new JLabel("成绩");
		
		JLabel label_2 = new JLabel("排名");
		
		JLabel lblid_1 = new JLabel("课程ID");
		
		JLabel label_3 = new JLabel("是否补考");
		
		textField = new JTextField();
		textField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(177)
							.addComponent(button))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(48)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(lblid)
									.addGap(38)
									.addComponent(lblid_1)
									.addGap(38)
									.addComponent(label_1))
								.addComponent(label, Alignment.TRAILING))
							.addGap(40)
							.addComponent(label_2)
							.addGap(28)
							.addComponent(label_3)))
					.addContainerGap(28, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(37, Short.MAX_VALUE)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 381, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(label)
					.addGap(9)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblid)
						.addComponent(lblid_1)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(label_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(24))
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}

}
