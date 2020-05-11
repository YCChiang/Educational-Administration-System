package pages.StudentsPages;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import entity.User;
import entity.ClassInfo;

import service.impl.ClassInfoServiceImpl;
import service.impl.ElectiveInfoServiceImpl;
import service.impl.Massage;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JCheckBoxMenuItem;

public class 选课new extends JFrame{
	public JCheckBox checkBox,chckbxNewCheckBox;
	public JMenu mnNewMenu;
	private JFrame frame;
	public User user;
	public JTable table;
	public JButton button_1,button_2;
	public JCheckBoxMenuItem chckbxmntmNewCheckItem,chckbxmntmNewCheckItem_1;
	ClassInfoServiceImpl classinfoservice = null;
	ElectiveInfoServiceImpl electiveinfoservice = null;
	List<ClassInfo> classInfo = null;
	private JTextField textField;
	private JPanel contentPane;
	public boolean IsFull,IsConflict,id,name_t;
	//ActionListener l;
	private Massage msg;
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
		frame.setBounds(100, 100, 609, 437);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(169, 59, 230, 24);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("请选择你要查询的方式：");
		menuBar.add(mnNewMenu_1);
		mnNewMenu_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_2 = new JCheckBoxMenuItem("课程号");
		//boolean name_t = chckbxmntmNewCheckItem_1.isSelected();
		chckbxmntmNewCheckItem_2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if( chckbxmntmNewCheckItem_2.isSelected())
				{
					id = true;
				}
			}
		});
		mnNewMenu_1.add(chckbxmntmNewCheckItem_2);
		
		JCheckBoxMenuItem chckbxmntmNewCheckItem_1_1 = new JCheckBoxMenuItem("课程名称");
		chckbxmntmNewCheckItem_1_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if( chckbxmntmNewCheckItem_1_1.isSelected())
				{
					name_t = true;
				}
			}
		});
		mnNewMenu_1.add(chckbxmntmNewCheckItem_1_1);
		
		
		JCheckBox checkBox = new JCheckBox("有课容量");
		checkBox.setBounds(140, 114, 133, 27);
		// “只显示有课容量的课程”
	    
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( checkBox.isSelected())
				{
					IsFull = true;
				}
			}
		});
		frame.getContentPane().add(checkBox);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("不冲突");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if( chckbxNewCheckBox.isSelected())
				{
					IsConflict = true; 
					//“只显示不与自己课程表冲突的课”
				}
			}
		});
		chckbxNewCheckBox.setBounds(364, 114, 217, 27);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JButton button = new JButton("搜索");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== button)
				{
					String input = textField.getText();
					if(input == null)
					{
						JOptionPane.showMessageDialog(null, "请输入查询内容", "错误提示",
								JOptionPane.ERROR_MESSAGE);
					}
					else {
						//System.out.println(id);
						//System.out.println(name_t);
						if(id && !name_t)
						{
					//		System.out.println(1);
							 classInfo = classinfoservice.seachClassById(input, "2020春", user.getname(), IsFull, IsConflict);
					//if(classInfo == null )
						//		System.out.println(2);

						//	System.out.println(classInfo.isEmpty());
						}
						else if(!id && name_t)
						{
							 classInfo = classinfoservice.seachClassByName(input, "2020春", user.getname(), IsFull, IsConflict);
						}
						
						DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
						if (!(classInfo.isEmpty())) {
							for (ClassInfo c : classInfo) {
								// 将数据添加到表格中
								tableModel.addRow(new Object[] { c.getId(), c.getName(), c.getTeacher_name(), c.getCapacity(),
										c.getYear(), c.getStart_week() + "-" + c.getEnd_week() });
							}
						}
						table.setModel(tableModel);
					}
				}
			}
		});
		button.setBounds(454, 58, 89, 27);
		frame.getContentPane().add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 195, 600, 110);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "\u8BFE\u7A0BID", "\u8BFE\u7A0B\u540D\u79F0", "\u6559\u5E08\u59D3\u540D",
						"\u8BFE\u5BB9\u91CF", "\u5F00\u8BFE\u5B66\u671F", "\u5F00\u8BFE\u5468" }));
		table.getColumnModel().getColumn(2).setMinWidth(25);
		scrollPane.setViewportView(table);
		
		
		
		
		JButton button_1 = new JButton("选课");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == button_1)
				{
					try {
						DefaultTableModel model = (DefaultTableModel) table.getModel();

						int[] selectedRows = table.getSelectedRows();
						for (int i = 0; i < selectedRows.length; i++) {
							if(IsFull&&!IsConflict)// “只显示有课容量的课程”
							{
								ClassInfo selected = new ClassInfo();
								String s0 = table.getValueAt(selectedRows[i],0).toString();
								selected.setId(s0);
								String s1 = table.getValueAt(selectedRows[i],1).toString();
								selected.setName(s1);
								String s2 = table.getValueAt(selectedRows[i],2).toString();
								selected.setTeacher_name(s2);
								int s3 = Integer.parseInt(table.getValueAt(selectedRows[i],3).toString());
								selected.setCapacity(s3);
								String s4 = table.getValueAt(selectedRows[i],4).toString();
								selected.setYear(s4);
								String s5 = table.getValueAt(selectedRows[i],5).toString();
								String s[] = s5.split("\\-");
								selected.setStart_week(Integer.parseInt(s[0]));
								selected.setEnd_week(Integer.parseInt(s[1]));
								//	System.out.println(selected);
								 msg = electiveinfoservice.elective(selected, user.getname());
							}
							else if(!IsFull&&IsConflict)
							{
								String selected = table.getValueAt(selectedRows[i],0).toString();
								//	System.out.println(selected);
								 msg = electiveinfoservice.elective(selected, user.getname());
							}
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
					}
				  catch (Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(null, "请选择课程", "错误提示", JOptionPane.ERROR_MESSAGE);
				}
			}
			}
		}
		);
		button_1.setBounds(74, 338, 113, 27);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("返回");
		
		//button_2.addActionListener(l);
		button_2.setBounds(384, 338, 113, 27);
		contentPane.add(button_2);
		//frame.getContentPane().add(menu_2);
		
		
		frame.setVisible(true);
	}
	
}
