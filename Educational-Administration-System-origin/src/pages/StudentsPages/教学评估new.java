package pages.StudentsPages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import entity.Student;
import entity.User;

public class 教学评估new {

	private JFrame frame;
	public User user;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public 教学评估new(User u) {
		initialize(u);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User u) {
		user = u;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 373);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("待评价课程");
		
		JCheckBox checkBox = new JCheckBox("软件工程");
		
		JButton button = new JButton("评价");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button)
				{
		    		if(checkBox.isSelected())
		    		{
		    			评估new.main(null);
		    			frame.setVisible(false);
		    		}
				}
			}
		});
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button_1)
				{
					new student(user);
					frame.setVisible(false);
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(159)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(checkBox)
								.addComponent(label)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(117)
							.addComponent(button)
							.addGap(66)
							.addComponent(button_1)))
					.addContainerGap(123, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(label)
					.addGap(18)
					.addComponent(checkBox)
					.addPreferredGap(ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(21))
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}

}
