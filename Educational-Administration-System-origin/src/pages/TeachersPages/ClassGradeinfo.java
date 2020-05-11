package pages.TeachersPages;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import entity.ClassGrade;
import entity.User;
import service.impl.ElectiveInfoServiceImpl;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class ClassGradeinfo extends JFrame {

	private JPanel contentPane;
	public User u;
	public List<String> ret;
	JButton button;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ClassGradeinfo(User user, String cla) {
		u = user;
		ElectiveInfoServiceImpl elect = new ElectiveInfoServiceImpl();

		ret = elect.findByClass_id(cla);
		int s = ret.size();
		setTitle("课程成绩");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 65, 565, 254);
		contentPane.add(scrollPane);

		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setRows(s);
		int j;
		for (j = 0; j < s; j++) {
			textArea.append(ret.get(j) + "\r\n");
		}

		button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new TeacherVisitGrade(user);
				contentPane.setVisible(false);
			}
		});
		button.setBounds(220, 332, 113, 27);
		contentPane.add(button);

		JLabel label = new JLabel("课程成绩");
		label.setBounds(238, 23, 72, 18);
		contentPane.add(label);
		this.setVisible(true);
	}
}
