package pages.Administrator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import entity.Comment;
import entity.User;
import service.impl.administratorCommentServiceimpl;
public class 导出教师评价new {

	private JFrame frame;
	private JTextField textField;
	public User u;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public 导出教师评价new(User user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User u1) {
		u = u1;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("教师评价表");
		
		JLabel lblId = new JLabel("ID");
		
		JLabel lblid = new JLabel("课程ID");
		
		JLabel label_1 = new JLabel("评价");
		
		/*
		 * 
		 */
		administratorCommentServiceimpl service = new administratorCommentServiceimpl();
		List<Comment> list = service.findCommentList();
		int size = list.size();
		textField = new JTextField();
	
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button)
				{
					frame.setVisible(false);
				//	new manager(u);
					
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(175)
					.addComponent(label)
					.addContainerGap(182, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(lblId)
					.addGap(43)
					.addComponent(lblid)
					.addPreferredGap(ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
					.addComponent(label_1)
					.addGap(114))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(24)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 378, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(187, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(182))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(lblid)
						.addComponent(label_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
					.addComponent(button)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}

}
