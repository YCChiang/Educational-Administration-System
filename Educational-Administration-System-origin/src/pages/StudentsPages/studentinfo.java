package pages.StudentsPages;

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
import java.awt.Font;

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
		textField.setBounds(307, 43, 223, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("学号:");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		label.setBounds(215, 46, 72, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("姓名:");
		label_1.setFont(new Font("宋体", Font.PLAIN, 20));
		label_1.setBounds(215, 87, 72, 18);
		contentPane.add(label_1);
		
		JLabel lblNewLabel = new JLabel("性别:");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(215, 131, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel label_2 = new JLabel("学院");
		label_2.setFont(new Font("宋体", Font.PLAIN, 20));
		label_2.setBounds(215, 177, 72, 18);
		contentPane.add(label_2);
		
		JLabel lblNewLabel_1 = new JLabel("专业");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(196, 228, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("班级");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(183, 275, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("年龄");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(183, 331, 72, 18);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("住址");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(165, 362, 72, 18);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("电话");
		lblNewLabel_5.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(149, 393, 72, 18);
		contentPane.add(lblNewLabel_5);
	}
}
