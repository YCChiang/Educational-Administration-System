package pages.TeachersPages;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import entity.ClassInfo;

import entity.User;
import service.impl.ClassInfoServiceImpl;
public class TeacherVisitGrade extends JFrame  implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;
	public User u;
	public ClassInfo g;
	JButton button_1;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TeacherVisitGrade(User user) {
		u = user;
		ClassInfoServiceImpl search = new ClassInfoServiceImpl();
		setTitle("成绩查询");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid = new JLabel("课程ID");
		lblid.setBounds(84, 46, 72, 18);
		contentPane.add(lblid);
		
		
		textField = new JTextField();
		textField.setBounds(170, 43, 172, 24);
		contentPane.add(textField);
		textField.setColumns(10);
	
		ClassInfo g = search.findByIdAndTeacher_id(textField.getText(), user.getname());
		
		JButton button = new JButton("查询");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(g == null)
				{
					JOptionPane.showMessageDialog(null, "课程号错误", "错误提示", JOptionPane.ERROR_MESSAGE);
					
				}
				else 
				{
					new ClassGradeinfo(u,textField.getText());
				}
			}
		});
		button.setBounds(66, 152, 113, 27);
		contentPane.add(button);
		
		 button_1 = new JButton("返回");
		button_1.addActionListener(this);
		button_1.setBounds(246, 152, 113, 27);
		contentPane.add(button_1);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==button_1)
			this.dispose();
	}

}
