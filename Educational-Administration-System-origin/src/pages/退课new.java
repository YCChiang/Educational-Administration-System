package pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 退课new {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					退课new window = new 退课new();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public 退课new() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 366);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("所有课程");
		
		JCheckBox checkBox = new JCheckBox("软件工程");
		
		JButton button = new JButton("退课");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button)
				{
		    		JOptionPane.showMessageDialog(null, "退课成功");
				}
			}
		});
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button_1)
				{
					new student();
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(171)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(154)
							.addComponent(checkBox))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(108)
							.addComponent(button)
							.addGap(71)
							.addComponent(button_1)))
					.addContainerGap(127, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(label)
					.addGap(18)
					.addComponent(checkBox)
					.addPreferredGap(ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addGap(25))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
