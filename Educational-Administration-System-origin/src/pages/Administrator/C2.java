package pages.Administrator;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import entity.Comment;

import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class C2 extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	JLabel j;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					C2 frame = new C2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public C2(List<Comment> list) {
		this.setTitle("查看教师评价");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//administratorCommentServiceimpl service = new administratorCommentServiceimpl();
	//	List<Comment> list = service.findCommentList();
		int size = list.size();
		String [] name = {"课程名","教师名","评价"};
		String[][] out = new String[size][3];
		for(int i = 0 ; i < size; i++) {
			out[i][0] = list.get(i).getClass_name();
			out[i][1] = list.get(i).getTeacher_name();
			out[i][2] = list.get(i).getContent();
		}
		table = new JTable(out,name);

		
		JScrollPane scrollpane=new JScrollPane();
		scrollpane.setViewportView(table);
		scrollpane.setBounds(28, 68, 440, 203);
		getContentPane().add(scrollpane);
		//contentPane.add(table);
		
		j = new JLabel();
		//textField = new JTextField();
		j.setHorizontalAlignment(SwingConstants.CENTER);
		j.setFont(new Font("宋体", Font.PLAIN, 18));
		j.setText("教师评价");
		j.setBounds(183, 31, 137, 24);
		contentPane.add(j);
		//textField.setColumns(10);
		
		JButton button = new JButton("返回");
		button.addActionListener(this);
		button.setBounds(194, 284, 113, 27);
		contentPane.add(button);
		//contentPane.add(pane);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
	}
}
