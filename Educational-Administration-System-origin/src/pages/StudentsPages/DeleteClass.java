package pages.StudentsPages;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entity.ClassInfo;
import entity.User;
import service.impl.ClassInfoServiceImpl;
import service.impl.ElectiveInfoServiceImpl;
import service.impl.Massage;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteClass extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	ElectiveInfoServiceImpl electiveinfoservice = null;
	ClassInfoServiceImpl classinfoservice = null;
	List<ClassInfo> classInfo = null;
	JButton button_1;
	User u;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */

	public DeleteClass(User user) {
		u = user;
		setTitle("退课");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 618, 330);
		addWindowListener(new WindowAdapter() {
			public void windowActivated(WindowEvent e) {
				// myWindowListener(e);
			}
		});
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		classinfoservice = new ClassInfoServiceImpl();
		electiveinfoservice = new ElectiveInfoServiceImpl();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 80, 600, 110);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u8BFE\u7A0BID", "\u8BFE\u7A0B\u540D\u79F0", "\u6559\u5E08\u59D3\u540D",
						"\u8BFE\u5BB9\u91CF", "\u5F00\u8BFE\u5B66\u671F", "\u5F00\u8BFE\u5468" }));
		table.getColumnModel().getColumn(2).setMinWidth(25);
		scrollPane.setViewportView(table);
		classInfo = classinfoservice.findByStudentIdAndYear(user.getname(), "2020春");
		//System.out.println(classInfo.size());
		/*
		 * 
		 */
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

		if (!classInfo.isEmpty()) {
			for (ClassInfo c : classInfo) {
				// 将数据添加到表格中
				tableModel.addRow(new Object[] { c.getId(), c.getName(), c.getTeacher_name(), c.getCapacity(),
						c.getYear(), c.getStart_week() + "-" + c.getEnd_week() });
			}
		}
		table.setModel(tableModel);
		JLabel label = new JLabel("已选课程");
		label.setBounds(242, 26, 72, 18);
		contentPane.add(label);

		JButton button = new JButton("退课");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button) {
					// TODO 判断表格里是否有内容和是否有被选列
					/*
					 * 监听表格，用getSelectedRow getSelectedRow会返回索引
					 */
					try {
						DefaultTableModel model = (DefaultTableModel) table.getModel();

						int[] selectedRows = table.getSelectedRows();
						for (int i = 0; i < selectedRows.length; i++) {
							String selected = table.getValueAt(selectedRows[i],0).toString();
						//	System.out.println(selected);
							Massage msg = electiveinfoservice.quit(selected, user.getname());
							if (msg.isError()) {
								// TODO 警告弹窗，消息为msg.getContent()
								JOptionPane.showMessageDialog(null, msg.getContent(), "错误提示",
										JOptionPane.ERROR_MESSAGE);
							} else {
								// TODO 提示弹窗，消息为msg.getContent()
								JOptionPane.showMessageDialog(null, msg.getContent(), "提示信息",
										JOptionPane.ERROR_MESSAGE);
								// TODO 删除索引对应的表格行，更新表格
								model.removeRow(selectedRows[0]);
							}

						}
						table.setModel(model);
					} catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "请选择课程", "错误提示", JOptionPane.ERROR_MESSAGE);
					}

				}
			}

		});
		button.setBounds(110, 225, 113, 27);
		contentPane.add(button);

		button_1 = new JButton("返回");
		button_1.addActionListener(this);
		button_1.setBounds(342, 225, 113, 27);
		contentPane.add(button_1);
		this.setVisible(true);
	}

	/*
	 * protected void myWindowListener(WindowEvent e) { classInfo =
	 * classinfoservice.findByStudentIdAndYear(u.getname(), "2020春");
	 * DefaultTableModel tableModel=(DefaultTableModel) table.getModel(); int size =
	 * classInfo.size(); if(!classInfo.isEmpty()) { for(ClassInfo c:classInfo) { //
	 * 将数据添加到表格中 tableModel.addRow(new Object[]
	 * {c.getId(),c.getName(),c.getTeacher_name(),c.getCapacity(),c.getYear(),c.
	 * getStart_week()+"-"+c.getEnd_week()}); } } table.setModel(tableModel); }
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.dispose();
	}

}
