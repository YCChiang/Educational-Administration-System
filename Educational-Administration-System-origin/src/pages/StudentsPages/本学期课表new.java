package pages.StudentsPages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 本学期课表new {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					本学期课表new window = new 本学期课表new();
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
	public 本学期课表new() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 451, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("本学期课程表");
		
		JTextArea textArea = new JTextArea();
		
		JTextArea textArea_1 = new JTextArea();
		
		JTextArea textArea_2 = new JTextArea();
		
		JTextArea textArea_3 = new JTextArea();
		
		JTextArea textArea_4 = new JTextArea();
		
		JTextArea textArea_5 = new JTextArea();
		
		JTextArea textArea_6 = new JTextArea();
		
		JTextArea textArea_7 = new JTextArea();
		
		JTextArea textArea_8 = new JTextArea();
		
		JTextArea textArea_9 = new JTextArea();
		
		JTextArea textArea_10 = new JTextArea();
		
		JTextArea textArea_11 = new JTextArea();
		
		JTextArea textArea_12 = new JTextArea();
		
		JTextArea textArea_13 = new JTextArea();
		
		JTextArea textArea_14 = new JTextArea();
		
		JTextArea textArea_15 = new JTextArea();
		
		JTextArea textArea_16 = new JTextArea();
		
		JTextArea textArea_17 = new JTextArea();
		
		JTextArea textArea_18 = new JTextArea();
		
		JTextArea textArea_19 = new JTextArea();
		
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
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
									.addGap(31)
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(textArea_5, Alignment.LEADING)
										.addComponent(textArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
										.addComponent(textArea_6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
										.addComponent(textArea_7, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
									.addGap(36)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textArea_10, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
										.addComponent(textArea_9, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
										.addComponent(textArea_8)
										.addComponent(textArea_1, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
									.addGap(33)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(textArea_13, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
										.addComponent(textArea_12, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
										.addComponent(textArea_11)
										.addComponent(textArea_2, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(button)))
							.addGap(37)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textArea_16, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
								.addComponent(textArea_15, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
								.addComponent(textArea_14)
								.addComponent(textArea_3, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE))
							.addGap(33)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textArea_19, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
								.addComponent(textArea_18, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
								.addComponent(textArea_17)
								.addComponent(textArea_4, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(174)
							.addComponent(label)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textArea_4, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_2, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_3, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textArea_5, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_8, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_11, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_14, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_17, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textArea_6, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_9, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_12, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_15, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_18, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textArea_7, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_10, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_13, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_16, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
						.addComponent(textArea_19, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addComponent(button)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
