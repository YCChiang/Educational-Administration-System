package pages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class 培养方案new {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					培养方案new window = new 培养方案new();
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
	public 培养方案new() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("培养方案");
		
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
		
		JTextArea textArea = new JTextArea();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(34)
					.addComponent(label)
					.addGap(18)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 290, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(186, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(183))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(button)
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
	}

}
