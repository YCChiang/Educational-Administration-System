package pages.TeachersPages;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import entity.Comment;
import entity.User;
import service.impl.TeacherCommentServiceimpl;
public class TeacherVisitComment extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField_1;
	public User u;
	JButton button_1;
	public List<Comment> com;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TeacherVisitComment(User user) {
		u = user;
		//TeacherCommentServiceimpl comment = new TeacherCommentServiceimpl();
		
		setTitle("课程评价查询");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblid_1 = new JLabel("课程ID");
		lblid_1.setBounds(75, 64, 72, 18);
		contentPane.add(lblid_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(181, 61, 145, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		String p = textField_1.getText();
		//com = comment.findCommentListbyteacheridandclassid(user.getname(), p);
		JButton button = new JButton("查询");
		//String s = com.get(0).getContent();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println(s);
				/*if(com.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "课程号错误", "错误提示", JOptionPane.ERROR_MESSAGE);
				}
				else 
				{
					new TeacherCommentInfo(u,p);
				}*/
				new TeacherCommentInfo(u,p);
			}
		});
		button.setBounds(57, 186, 113, 27);
		contentPane.add(button);
		
		button_1 = new JButton("返回");
		button_1.addActionListener(this);
		button_1.setBounds(241, 186, 113, 27);
		contentPane.add(button_1);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button_1) {
			this.dispose();
		}
	}

}
