package pages.Administrator;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import entity.ClassInfo;
import entity.User;
import service.impl.ClassInfoServiceImpl;
import service.impl.Massage;
public class 导入课程安排new {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;
	private String[] years = {"2020秋","2020夏", "2020春"};
	private JComboBox<String> comboBox;
	private DefaultComboBoxModel<String> model;
	ClassInfoServiceImpl classinfoservice = null;
	public User u;
	
	public 导入课程安排new(User user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User u1) {
		u = u1;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 535);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("导入课程安排");
		
		JLabel lblid = new JLabel("课程ID");
		textField = new JTextField();
		textField.setColumns(10);
				
		JLabel label_1 = new JLabel("课程名");
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblid_1 = new JLabel("教师ID");
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel label_2 = new JLabel("教师姓名");
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel label_3 = new JLabel("课容量");
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel label_4 = new JLabel("开课周");
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); // 获取键盘输入的字符
				if (Character.isDigit(c)) // 判断输入是否是数字
					return; // true,返回
				e.consume(); // false,消毁不匹配的输入
		}});
		
		JLabel label_5 = new JLabel("结束周");		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); // 获取键盘输入的字符
				if (Character.isDigit(c)) // 判断输入是否是数字
					return; // true,返回
				e.consume(); // false,消毁不匹配的输入
		}});
		
		JLabel label_6 = new JLabel("开课学年");
		model = new DefaultComboBoxModel<String>();
		for(String y:years) {
			model.addElement(y);
		}		
		comboBox = new JComboBox<String>(years);
		comboBox.setBounds(422, 10, 156, 24);
		
		JLabel label_7 = new JLabel("学分");
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); // 获取键盘输入的字符
				if (Character.isDigit(c)) // 判断输入是否是数字
					return; // true,返回
				e.consume(); // false,消毁不匹配的输入
		}});
		
		JLabel label_9 = new JLabel("");
		
		JButton button = new JButton("导入");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(textField.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "请输入课程id", "错误",JOptionPane.ERROR_MESSAGE);
						System.out.print("fdasf");
						return;
					}
					if(textField_1.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "请输入课程名称", "错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(textField_2.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "请输入教师id", "错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(textField_4.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "请输入课容量", "错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(textField_5.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "请输入开课周", "错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(textField_6.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "请输入结束周", "错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(textField_8.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "请输入开课学年", "错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
					int capacity = Integer.parseInt(textField_4.getText());
					int start = Integer.parseInt(textField_5.getText());
					int end = Integer.parseInt(textField_6.getText());
					int credit = Integer.parseInt(textField_8.getText());
					String year = comboBox.getItemAt(comboBox.getSelectedIndex());
					
					if(capacity < 0) {
						JOptionPane.showMessageDialog(null, "课容量必须大于0", "错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(start < 0 || start > 30) {
						JOptionPane.showMessageDialog(null, "开课周必须大于0小于30", "错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(end < 0 || end > 30) {
						JOptionPane.showMessageDialog(null, "结束周必须大于0小于30", "错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(start > end) {
						JOptionPane.showMessageDialog(null, "结束周必须大于开课周", "错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
					if(credit <0 || credit > 10) {
						JOptionPane.showMessageDialog(null, "学分必须大于0小于10", "错误",JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					ClassInfo info = new ClassInfo();
					info.setId(textField.getText());
					info.setName(textField_1.getText());
					info.setTeacher_id(textField_2.getText());
					info.setCapacity(capacity);
					info.setStart_week(start);
					info.setEnd_week(end);
					info.setCredit(credit);
					info.setYear(year); 
					Massage msg = classinfoservice.addOne(info);
					if(msg.isError()) {
						JOptionPane.showMessageDialog(null, "错误", msg.getContent(),JOptionPane.ERROR_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, msg.getContent());  
						textField.setText(null);
						textField_1.setText(null);
						textField_2.setText(null);
						textField_3.setText(null);
						textField_4.setText(null);
						textField_5.setText(null);
						textField_6.setText(null);
						textField_8.setText(null);
					}
			}
		});
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button_1)
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
					.addGap(122)
					.addComponent(button)
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button_1)
						.addComponent(label_9))
					.addContainerGap(123, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(68)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblid)
								.addComponent(label_1)
								.addComponent(lblid_1)
								.addComponent(label_2)
								.addComponent(label_3)
								.addComponent(label_4)
								.addComponent(label_5)
								.addComponent(label_6)
								.addComponent(label_7))
							.addPreferredGap(ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField_8)
								.addComponent(comboBox)
								.addComponent(textField_6)
								.addComponent(textField_5)
								.addComponent(textField_4)
								.addComponent(textField_3)
								.addComponent(textField_2)
								.addComponent(textField_1)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(233, Short.MAX_VALUE)
							.addComponent(label)))
					.addGap(109))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblid)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblid_1)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(label_5)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_6)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_7)
								.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
							.addComponent(label_9))
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(button)
							.addComponent(button_1)))
					.addContainerGap())
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}

}
