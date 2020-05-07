package pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 课程成绩new {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					课程成绩new window = new 课程成绩new();
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
	public 课程成绩new() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 354);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("课程成绩");
		
		JTextArea textArea = new JTextArea();
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button)
				{
					frame.setVisible(false);
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
							.addGap(172)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(75)
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(177)
							.addComponent(button)))
					.addContainerGap(97, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(24))
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
