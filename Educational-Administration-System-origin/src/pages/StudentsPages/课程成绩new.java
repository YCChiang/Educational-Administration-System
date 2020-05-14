package pages.StudentsPages;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import service.*;
import service.impl.*;
import dao.*;
import dao.impl.*;
import entity.*;

public class 课程成绩new {

	public Student info;
	private JFrame frame;
	public User user;
	public List<ClassGrade> prof;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					课程成绩new window = new 课程成绩new();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public 课程成绩new(User u) {
		initialize(u);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User u) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
	//	frame.setDefaultCloseOperation(JFrame.);
		frame.setTitle("课程成绩");
		JLabel label = new JLabel("课程成绩");
	
		user = u;
		System.out.println(user.getname());
		studentinfoserviceimpl s = new studentinfoserviceimpl();
		info = s.findById(user.getname());
		
		ClassGradeServiceimpl service = new ClassGradeServiceimpl();
		List<ClassGrade> list = service.findbyStudentid(info.getId());
		int size = list.size();
		JTextArea textArea = new JTextArea();
		for(int i  = 0 ; i< size ; i++) {
			String temp = "课程ID："+list.get(i).getClass_id()+"   成绩"+(list.get(i)).getGrade()+"     排名"+list.get(i).getRank()+"\r\n";
			textArea.append(temp);
		}
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(178)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(48)
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(label)
					.addGap(18)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(40, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}

}
