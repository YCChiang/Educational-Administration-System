package pages.TeachersPages;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import entity.ClassInfo;
import entity.ClassSchedule;
import entity.User;
import service.impl.ClassInfoServiceImpl;
import service.impl.ClassScheduleServiceImpl;
public class TeacherClass extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	private User u;
	ClassInfoServiceImpl classinfoservice = null;
	ClassScheduleServiceImpl classscheduleservice= null;
	List<ClassInfo> classInfo = null;
	JButton button;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TeacherClass(User user) {
		u = user;
		classscheduleservice = new ClassScheduleServiceImpl();
		classinfoservice = new ClassInfoServiceImpl();
		setTitle("教师课程表");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("本学期教师课程表");
		label.setBounds(211, 24, 140, 18);
		contentPane.add(label);
		
		// TODO 添加表格组件
		/*
		 * 添加表格：教程http://c.biancheng.net/view/1258.html
		 * 列名有：课程ID，课程名称，课容量，开课学期，开课周，上课时间
		 * 其中开课周为start_week-end_week（例如：1-8）
		 */
		classInfo = classinfoservice.findByTeacher_idAndYear(user.getname(), "2020春");
		if(!classInfo.isEmpty()) {
			for(ClassInfo c:classInfo) {
				List<ClassSchedule> schedule = classscheduleservice.findByClassId(c.getId());
				if(!schedule.isEmpty()) {
					/*
					 *  将数据添加到表格中显示为如下
					 * ------------------------------------------
					 * |课程ID|课程名称|课容量|开课周|上课时间		|
					 * ------------------------------------------
					 * |001232|数据结构|60  |1-8  |星期一  10:05:00|
					 * ------------------------------------------
					 * |			全为空单元格	 |星期二  10:05:00|
					 * -------------------------------------------
					 */
				}
			}			
		}
		textField = new JTextField();
		textField.setBounds(48, 55, 446, 201);
		contentPane.add(textField);
		textField.setColumns(10);
		
		 button = new JButton("返回");
		button.addActionListener(this);
		button.setBounds(225, 287, 113, 27);
		contentPane.add(button);
		this.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button)
			this.dispose();
	}

}
