package pages;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;

class manager extends JFrame implements ActionListener 
{

	    // 工具条
	    JToolBar jtb;
	    // 菜单条组件
	    JMenuBar jmb;
	    JMenu menu1, menu2, menu3, menu4;
	    JMenuItem item1,item2, item3, item4, item5, item6, item7,item8,item9;
	    JLabel jl1;

	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        new manager();

	    }

	    public manager() {

	        // 创建工具条
	        jtb = new JToolBar();

	        jmb = new JMenuBar();

	        menu1 = new JMenu("主页");
	        menu2 = new JMenu("学生管理");
	        menu3 = new JMenu("教师管理");
	        menu4 = new JMenu("课程管理");

	        // item1=new JMenuItem(“新建”)
	        item1 = new JMenuItem("导入学生信息");
	        item2 = new JMenuItem("查询个人信息");
	        
	        item3 = new JMenuItem("导入教师信息");
	        item4 = new JMenuItem("查询教师信息");
	        item5 = new JMenuItem("导出教师评价");
	        
	        item6 = new JMenuItem("导入培养方案");
	        item7 = new JMenuItem("导入课程安排");
	        item8 = new JMenuItem("修改课程名单");
	        
	        item9 = new JMenuItem("返回");

	        //jta = new JTextArea();

	        // 设置布局
	        menu1.add(item9);

	        menu2.add(item1);
	        menu2.add(item2);
	        
	        menu3.add(item3);
	        menu3.add(item4);
	        menu3.add(item5);
	        
	        menu4.add(item6);
	        menu4.add(item7);
	        menu4.add(item8);

	        // 将菜单添加到菜单条上
	        jmb.add(menu1);
	        jmb.add(menu2);
	        jmb.add(menu3);
	        jmb.add(menu4);
	        // 将菜单添加到窗体上
	        this.setJMenuBar(jmb);

	        // 将工具条添加到窗体
	        this.add(jtb, BorderLayout.NORTH);

	        //JScrollPane jsp = new JScrollPane(jta);
	       // jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	        //this.add(jsp);
	        
	        
	        item1.addActionListener(this);
			item2.addActionListener(this);
			item3.addActionListener(this);
			item4.addActionListener(this);
			item5.addActionListener(this);
			item6.addActionListener(this);
			item7.addActionListener(this);
			item8.addActionListener(this);
			item9.addActionListener(this);
			
	        jl1 = new JLabel(new ImageIcon("F://1.jpg"));
	        this.add(jl1);
	        // 展示
	        this.setTitle("教务管理系统（管理员端）");
	        this.setSize(1200, 900);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setVisible(true);

	    }
	    
	    public void actionPerformed(ActionEvent ev)//为按钮添加的注册事件
		{
	    	if(ev.getSource()==item9)
			{
	    		new inter();
			}
	    	if(ev.getSource()==item1)
			{
	    		new 导入学生信息new();
			}
			if(ev.getSource()==item2)
			{
				new 查询学生信息new();
			}
			if(ev.getSource()==item3)
			{
				new 导入教师信息new();
			}
			if(ev.getSource()==item4)
			{
				new 查询教师信息new();
			}
			if(ev.getSource()==item5)
			{
				new 导出教师评价new();
			}
			if(ev.getSource()==item6)
			{
				new 导入培养方案new();
			}
			if(ev.getSource()==item7)
			{
				new 导入课程安排new();
			}
			if(ev.getSource()==item8)
			{
				new 修改课程名单new();
			}
			this.setVisible(false);
		}

}
