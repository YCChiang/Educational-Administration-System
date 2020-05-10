package pages.Administrator;

import java.awt.BorderLayout;
import entity.User;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CommentOut extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public User u;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public CommentOut(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 462, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 48, 444, 168);
		contentPane.add(scrollPane);
		
		textField = new JTextField();
		scrollPane.setViewportView(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("返回");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new manager(user);
			}
		});
		btnNewButton.setBounds(158, 229, 113, 27);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("课程评价");
		label.setBounds(181, 13, 72, 18);
		contentPane.add(label);
		this.setVisible(true);
	}

}
