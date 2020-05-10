package pages.StudentsPages;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import entity.User;
import entity.ClassInfo;

import service.impl.ClassInfoServiceImpl;
import service.impl.ElectiveInfoServiceImpl;
import service.impl.Massage;

public class 选课new {

	private JFrame frame;
	private JTextField textField;
	public User user;
	ClassInfoServiceImpl classinfoservice = null;
	ElectiveInfoServiceImpl electiveinfoservice = null;
	List<ClassInfo> classInfo = null;
	

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public 选课new(User u) {
		initialize(u);
		classinfoservice = new ClassInfoServiceImpl();
		electiveinfoservice = new ElectiveInfoServiceImpl();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User u) {
		user = u;
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 383);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("搜索课程号");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		// TODO 添加下拉选课
		/*
		 * 通过下拉选框确定搜索的数据类型
		 * 类型选项有：课程号，课程名
		 */
		
		// TODO 添加两个单选框
		/*
		 * 一个单选框为“只显示有课容量的课程”
		 * 一个单选框为“只显示不与自己课程表冲突的课”
		 */
		
		JButton button = new JButton("搜索");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button)
				{
					// TODO 判断搜索框里是否输入
					String input = null;
					
					// TODO 判断两个单选框是否勾选，勾选了为true，反之为false
					boolean IsFull = true; // “只显示有课容量的课程”
					boolean IsConflict = true; //“只显示不与自己课程表冲突的课”
					
					// TODO 判断下拉菜单输入的类型
					// 如果是课程名
					// List<ClassInfo> classInfo = classinfoservice.seachClassByName(input, "2020春", user.getname(), IsFull, IsConflict);
					// 如果是课程号
					// List<ClassInfo> classInfo = classinfoservice.seachClassById(input, "2020春", user.getname(), IsFull, IsConflict);
					
					// 判断是否有信息

					// TODO 课程信息插入表格，用addROW
					
				}
			}
		});
		
		// TODO 添加表格组件
		/*
		 * 添加表格：教程http://c.biancheng.net/view/1258.html
		 * 列名有：课程ID，课程名称，教师名称，课容量，开课学期，开课周
		 */
		
		JCheckBox checkBox = new JCheckBox("软件工程");// 不要了
		JButton button_1 = new JButton("选课");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button_1)
				{
					// TODO 判断表格里是否有内容和是否有被选列
					/*
					 * 监听表格，用getSelectedRow
					 * getSelectedRow会返回索引
					 */
					ClassInfo selected = classInfo.get(0); // 将0换成索引
					
					Massage msg = electiveinfoservice.elective(selected, user.getname());
					if(msg.isError()) {
						// TODO 警告弹窗，消息为msg.getContent()						
					}
					else {
						// TODO 提示弹窗，消息为msg.getContent()	
						
						// TODO 删除索引对应的表格行，更新表格
					}
						
				}
			}
		});
		
		JButton button_2 = new JButton("返回");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button_2)
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
							.addGap(48)
							.addComponent(label)
							.addGap(28)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(checkBox)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(button))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(115)
							.addComponent(button_1)
							.addGap(78)
							.addComponent(button_2)))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addGap(18)
					.addComponent(checkBox)
					.addPreferredGap(ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(button_2))
					.addGap(22))
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}
}
