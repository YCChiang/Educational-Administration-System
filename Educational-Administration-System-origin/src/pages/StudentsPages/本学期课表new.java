package pages.StudentsPages;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import entity.ClassInfo;
import entity.ClassSchedule;
import entity.User;
import service.impl.ClassInfoServiceImpl;
import service.impl.ElectiveInfoServiceImpl;
import service.impl.ClassScheduleServiceImpl;

public class 本学期课表new {

	private JFrame frame;
	public User user;
	ClassInfoServiceImpl classinfoservice = null;
	ClassScheduleServiceImpl classscheduleservice= null;
	List<ClassInfo> classInfo = null;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public 本学期课表new(User u) {
		initialize(u);
		classscheduleservice = new ClassScheduleServiceImpl();
		classinfoservice = new ClassInfoServiceImpl();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User u1) {
		user = u1;
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
		
		// TODO 添加表格组件
		/*
		 * 添加表格：教程http://c.biancheng.net/view/1258.html
		 * 列名有：课程ID，课程名称，教师名称，课容量，开课学期，开课周，上课时间
		 * 其中开课周为start_week-end_week（例如：1-8）
		 */
		classInfo = classinfoservice.findByStudentIdAndYear(user.getname(), "2020春");
		if(!classInfo.isEmpty()) {
			for(ClassInfo c:classInfo) {
				List<ClassSchedule> schedule = classscheduleservice.findByClassId(c.getId());
				if(!schedule.isEmpty()) {
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
		frame.setVisible(true);
	}
}
