package pages.TeachersPages;

import javax.swing.JFrame;
import entity.Comment;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import entity.User;
import service.impl.TeacherCommentServiceimpl;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
public class TeacherCommentInfo extends JFrame implements ActionListener{
	public User u;
	public List<Comment> com;
	public TeacherCommentServiceimpl comment;
	/**
	 * Launch the application.
	 */
	//private JPanel contentPane;
	private JTextField textField;
	JButton button;
	/**
	 * Create the frame.
	 */
	public TeacherCommentInfo(User user,String s) {
		u = user;
		comment = new TeacherCommentServiceimpl();
		com = comment.findCommentListbyteacheridandclassid(user.getname(), s);
		int i = com.size();
		
		setTitle("教师课程评价");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 436);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 59, 558, 280);
		getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setRows(i);
		int j;
		for(j = 0;j < i; j++)
		{
			textArea.append(com.get(j).getClass_name()+"  "+com.get(j).getContent()+"\r\n");
		}
		scrollPane.setViewportView(textArea);
		
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("课程评价信息");
		textField.setBounds(177, 22, 172, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		 button = new JButton("返回");
		button.addActionListener(this);
		button.setBounds(214, 352, 113, 27);
		getContentPane().add(button);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button) {
			new TeacherVisitComment(u);
			this.dispose();
		}
	}
}
