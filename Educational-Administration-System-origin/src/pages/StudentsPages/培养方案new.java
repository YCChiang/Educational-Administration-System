package pages.StudentsPages;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
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


public class 培养方案new {

	public Student info;
	private JFrame frame;
	public User user;
	public List<ProfProgram> prof;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					培养方案new window = new 培养方案new();
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
	public 培养方案new(User u) {
		initialize(u);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User u) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("学生培养方案");
		user = u;
		System.out.println(user.getname());
		studentinfoserviceimpl s = new studentinfoserviceimpl();
		info = s.findById(user.getname());
		
		studentprofprogramServiceimpl service = new studentprofprogramServiceimpl();
		List<ProfProgram> list = service.findProfProgramList(info.getSpecialty());
		int size = list.size();
		JTextArea textArea = new JTextArea();
		
		for(int i  = 0 ; i< size ; i++) {
			String temp = list.get(i).getClass_id()+" "+(list.get(i)).getClass_name()+" "+list.get(i).getCredit()+"\r\n";
			textArea.append(temp);
		}
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(174)
							.addComponent(label))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(55, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
		frame.setVisible(true);
	}
}
