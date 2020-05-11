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
		frame.setTitle("选课");
		frame.setBounds(100, 100, 450, 383);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
	}
}
