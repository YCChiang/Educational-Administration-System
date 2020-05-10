package pages.Administrator;

import java.awt.BorderLayout;

import entity.Comment;
import entity.User;
import service.impl.administratorCommentServiceimpl;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class OutComment extends JFrame {

	private JPanel contentPane;
	public User u;
	public static void main(String [] args ) {
		//new OutComment(null);
	}
	public OutComment(User user) {
		
		administratorCommentServiceimpl service = new administratorCommentServiceimpl();
		List<Comment> list = service.findCommentList();
		int size = list.size();
		
		setTitle("课程评价信息");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("课程评价信息");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(183, 19, 128, 18);
		contentPane.add(label);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 63, 510, 233);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		
		scrollPane.setViewportView(textArea);
		//textArea.appen);
		
		for(int i  = 0 ; i< size ; i++) {
			String temp = list.get(i).getClass_name()+" "+(list.get(i)).getTeacher_name()+" "+list.get(i).getContent()+"\r\n";
			textArea.append(temp);
		}
		
		JButton button = new JButton("返回");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new manager(user);
			}
		});
		button.setBounds(198, 297, 113, 27);
		contentPane.add(button);

		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setOrientation(JScrollBar.HORIZONTAL);
		scrollBar_1.setBounds(0, 284, 444, 21);
		contentPane.add(scrollBar_1);

		this.setVisible(true);
	}
}
