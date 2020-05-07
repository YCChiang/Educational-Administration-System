package pages;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class studentinfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentinfo frame = new studentinfo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public studentinfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("修改");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(189, 511, 113, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(arg0.getSource()== btnNewButton_1) {
					System.exit(0);
				}
			}
		});
		btnNewButton_1.setBounds(478, 511, 113, 27);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(335, 43, 223, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("学号:");
		label.setBounds(215, 46, 72, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("姓名:");
		label_1.setBounds(215, 87, 72, 18);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("性别:");
		lblNewLabel.setBounds(215, 131, 72, 18);
		contentPane.add(lblNewLabel);
	}
}
