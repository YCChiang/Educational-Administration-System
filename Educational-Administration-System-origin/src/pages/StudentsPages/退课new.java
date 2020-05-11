package pages.StudentsPages;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Container;
import java.awt.event.ActionEvent;

import entity.ClassInfo;
import entity.User;
import service.impl.ClassInfoServiceImpl;
import service.impl.ElectiveInfoServiceImpl;
import service.impl.Massage;

public class 退课new {

	private JFrame frame;
	User user;
	ElectiveInfoServiceImpl electiveinfoservice = null;
	ClassInfoServiceImpl classinfoservice = null;
	List<ClassInfo> classInfo = null;

	public 退课new(User u) {
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
		frame.setBounds(100, 100, 450, 366);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel("所有课程");
		
		// TODO 添加表格组件
		/*
		 * 添加表格：教程http://c.biancheng.net/view/1258.html
		 * 列名有：课程ID，课程名称，教师名称，课容量，开课学期，开课周
		 * 其中开课周为start_week-end_week（例如：1-8）
		 */
		Object[][] tabledate = new Object[2][6];
		for(int i = 0; i < 6; i++)
		{
			tabledate[1][i] = 0;
		}
		String[] name = {"课程ID","课程名称","教师姓名","课容量","开课学期","开课周"};
		JTable table =  new JTable(tabledate,name);
		JScrollPane pane = new JScrollPane(table);
		frame.getContentPane().add(pane);
		
		classInfo = classinfoservice.findByStudentIdAndYear(user.getname(), "2020春");
		if(!classInfo.isEmpty()) {
			for(ClassInfo c:classInfo) {
				// 将数据添加到表格中
			}			
		}
		
		
		
		JButton button = new JButton("退课");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button)
				{
					// TODO 判断表格里是否有内容和是否有被选列
					/*
					 * 监听表格，用getSelectedRow
					 * getSelectedRow会返回索引
					 */
					ClassInfo selected = classInfo.get(0); // 将0换成索引
					Massage msg = electiveinfoservice.quit(selected.getId(), user.getname());
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
		
		JButton button_1 = new JButton("返回");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button_1)
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
		frame.setVisible(true);
	}

}
