package rgks;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class student extends JFrame implements ActionListener 
{

	    // 工具条
	    JToolBar jtb;
	    // 菜单条组件
	    JMenuBar jmb;
	    JMenu menu1, menu2, menu3, menu4, menu5;
	    JMenuItem item1,item2, item3, item4, item5, item6, item7,item8,item9;
	    JLabel jl1;

	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        new student();

	    }

	    public student() {

	        // 创建工具条
	        jtb = new JToolBar();
	        jmb = new JMenuBar();

	        menu1 = new JMenu("主页");
	        menu2 = new JMenu("个人管理");
	        menu3 = new JMenu("选课管理");
	        menu4 = new JMenu("考务管理");
	        menu5 = new JMenu("教学评估");

	        // item1=new JMenuItem(“新建”)
	        item1 = new JMenuItem("个人信息");
	        item2 = new JMenuItem("培养方案");
	        item3 = new JMenuItem("学籍注册");
	        
	        item4 = new JMenuItem("本学期课表");
	        item5 = new JMenuItem("选课");
	        item6 = new JMenuItem("退课");
	        
	        item7 = new JMenuItem("课程成绩");
	        item8 = new JMenuItem("补考报名");
	        
	        item9 = new JMenuItem("返回");

	        //jta = new JTextArea();

	        // 设置布局
	        
	        menu1.add(item9);

	        menu2.add(item1);
	        menu2.add(item2);
	        menu2.add(item3);
	        
	        menu3.add(item4);
	        menu3.add(item5);
	        menu3.add(item6);
	        
	        menu4.add(item7);
	        menu4.add(item8);

	        // 将菜单添加到菜单条上
	        jmb.add(menu1);
	        jmb.add(menu2);
	        jmb.add(menu3);
	        jmb.add(menu4);
	        jmb.add(menu5);

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
	        this.setTitle("教务管理系统（学生端）");
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
	    		new 个人信息();
			}
			if(ev.getSource()==item2)
			{
				new 培养方案();
			}
			if(ev.getSource()==item3)
			{
				new 学籍注册();
			}
			if(ev.getSource()==item4)
			{
				new 本学期课表();
			}
			if(ev.getSource()==item5)
			{
				new 选课();
			}
			if(ev.getSource()==item6)
			{
				new 退课();
			}
			if(ev.getSource()==item7)
			{
				new 课程成绩();
			}
			if(ev.getSource()==item8)
			{
				new 补考报名();
			}
			this.setVisible(false);
		}

}
