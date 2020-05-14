package pages.StudentsPages;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.*;

import entity.ClassGrade;
import entity.ClassInfo;
import entity.ClassSchedule;
import entity.*;
import service.impl.*;
import javax.swing.table.DefaultTableModel;

public class 本学期课表new {

	private JFrame frame;
	public User user;
	ClassInfoServiceImpl classinfoservice = null;
	ClassScheduleServiceImpl classscheduleservice= null;
	List<ClassInfo> classInfo = null;
	private JTable table;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public 本学期课表new(User u) {
		classscheduleservice = new ClassScheduleServiceImpl();
		classinfoservice = new ClassInfoServiceImpl();
		initialize(u);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User u1) {
		user = u1;
		//System.out.println(user.getname());
		frame = new JFrame();
		frame.setBounds(100, 100, 549, 521);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		DefaultTableModel model = new DefaultTableModel();
		JLabel label = new JLabel("本学期课程表");
		table = new JTable(model);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"课程ID", "课程名称", "教师名称", "课容量", "开课周", "上课时间"
			}
		));
		/*
		 * 添加表格：教程http://c.biancheng.net/view/1258.html
		 * 列名有：课程ID，课程名称，教师名称，课容量，开课学期，开课周，上课时间
		 * 其中开课周为start_week-end_week（例如：1-8）
		 */
		//ElectiveInfoServiceImpl service = new ElectiveInfoServiceImpl();
		/*List<ClassInfo> classInfo = service.findByStudentId(user.getname());*/
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		table.setModel(tableModel);
		classInfo = classinfoservice.findByStudentIdAndYear(user.getname(), "2020春");
		if(!classInfo.isEmpty()) {
			for(ClassInfo c:classInfo) {
				List<ClassSchedule> schedule = classscheduleservice.findByClassId(c.getId());
				if(!schedule.isEmpty()) {
						System.out.println(c.getId());
					tableModel.addRow(new Object[] { c.getId(), c.getName(), c.getTeacher_name(), c.getCapacity(),
					 c.getStart_week() + "-" + c.getEnd_week() ,c.getYear()});
					/*
					 *  将数据添加到表格中显示为如下
					 * -----------------------------------------------------
					 * |课程ID|课程名称|教师名称|课容量|开课周|上课时间|
					 * -----------------------------------------------------
					 * |001232|数据结构|连XX	   |60  |1-8  |星期一  10:05:00|
					 * -----------------------------------------------------
					 * |			全为空单元格			  |星期二  10:05:00|
					 * -----------------------------------------------------
					 */
				}
				
			}	
			table.setModel(tableModel);
		}
		
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button)
				{
					
					frame.setVisible(false);
					new student(user);
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(46, Short.MAX_VALUE)
					.addComponent(button)
					.addGap(233))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(219)
					.addComponent(label)
					.addContainerGap(222, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(46, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 462, GroupLayout.PREFERRED_SIZE)
					.addGap(23))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addComponent(label)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
					.addGap(24)
					.addComponent(button)
					.addContainerGap())
		);
		
		
		scrollPane.setViewportView(table);
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}
}
