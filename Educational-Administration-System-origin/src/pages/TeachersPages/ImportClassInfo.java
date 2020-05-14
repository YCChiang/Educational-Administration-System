package pages.TeachersPages;

import entity.User;
import service.impl.ClassInfoServiceImpl;
import service.impl.Massage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.ActionEvent;
import entity.ClassInfo;
import java.awt.event.KeyEvent;

public class ImportClassInfo extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_8;
	private JComboBox<String> comboBox;
	private DefaultComboBoxModel<String> model;
	private String[] years = {"2020秋","2020夏", "2020春"};
	//private User u;
	ClassInfoServiceImpl classinfoservice = null;
	JButton button_1;
	
	public ImportClassInfo(User u1) {
		//u = u1;
		classinfoservice = new 	ClassInfoServiceImpl();
		setTitle("课程信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 658, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("课程ID");
		lblNewLabel.setBounds(29, 13, 72, 18);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(100, 10, 193, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("课程名");
		label.setBounds(29, 59, 72, 18);
		contentPane.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(100, 56, 193, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("课容量");
		lblNewLabel_1.setBounds(29, 154, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(100, 151, 193, 24);
		textField_4.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); // 获取键盘输入的字符
				if (Character.isDigit(c)) // 判断输入是否是数字
					return; // true,返回
				e.consume(); // false,消毁不匹配的输入
		}});
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("开课周");
		lblNewLabel_2.setBounds(29, 104, 72, 18);
		contentPane.add(lblNewLabel_2);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); // 获取键盘输入的字符
				if (Character.isDigit(c)) // 判断输入是否是数字
					return; // true,返回
				e.consume(); // false,消毁不匹配的输入
		}});
		textField_5.setBounds(100, 101, 193, 24);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_2 = new JLabel("结束周");
		label_2.setBounds(336, 104, 72, 18);
		contentPane.add(label_2);
		
		textField_6 = new JTextField();
		textField_6.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); // 获取键盘输入的字符
				if (Character.isDigit(c)) // 判断输入是否是数字
					return; // true,返回
				e.consume(); // false,消毁不匹配的输入
		}});
		textField_6.setBounds(422, 101, 156, 24);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_3 = new JLabel("开课学年");
		label_3.setBounds(336, 13, 72, 18);
		contentPane.add(label_3);
		
		model = new DefaultComboBoxModel<String>();
		for(String y:years) {
			model.addElement(y);
		}		
		comboBox = new JComboBox<String>(years);
		comboBox.setBounds(422, 10, 156, 24);
		contentPane.add(comboBox);
		
		JLabel label_4 = new JLabel("学分");
		label_4.setBounds(336, 59, 72, 18);
		contentPane.add(label_4);
		
		textField_8 = new JTextField();
		textField_8.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar(); // 获取键盘输入的字符
				if (Character.isDigit(c)) // 判断输入是否是数字
					return; // true,返回
				e.consume(); // false,消毁不匹配的输入
		}});
		textField_8.setBounds(422, 56, 156, 24);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "请输入课程id", "错误",JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(textField_1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "请输入课程名称", "错误",JOptionPane.ERROR_MESSAGE);
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
				info.setCapacity(capacity);
				info.setStart_week(start);
				info.setEnd_week(end);
				info.setCredit(credit);
				info.setYear(year); 
				Massage msg = classinfoservice.addOne(info);
				if(msg.isError()) {
					JOptionPane.showMessageDialog(null, msg.getContent(), "错误",JOptionPane.ERROR_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, msg.getContent());  
					textField.setText(null);
					textField_1.setText(null);
					textField_4.setText(null);
					textField_5.setText(null);
					textField_6.setText(null);
					textField_8.setText(null);
				}
		}
		});
		button.setBounds(129, 301, 113, 27);
		contentPane.add(button);
		
		 button_1 = new JButton("返回");
		button_1.addActionListener(this);
		button_1.setBounds(401, 301, 113, 27);
		contentPane.add(button_1);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button_1)
			this.dispose();
	}
}
