package rgks;

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

class teacher extends JFrame implements ActionListener 
{

	    // 工具条
	    JToolBar jtb;
	    // 菜单条组件
	    JMenuBar jmb;
	    JMenu menu1, menu2, menu3, menu4;
	    JMenuItem item1,item2, item3, item4, item5, item6,item7;
	    JLabel jl1;

	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        new teacher();

	    }

	    public teacher() {

	        // 创建工具条
	        jtb = new JToolBar();

	        jmb = new JMenuBar();

	        menu1 = new JMenu("主页");
	        menu2 = new JMenu("个人信息");
	        menu3 = new JMenu("课程管理");
	        menu4 = new JMenu("考务管理");

	        // item1=new JMenuItem(“新建”)
	        item1 = new JMenuItem("本学期课程表");
	        item2 = new JMenuItem("查看个人信息");
	        item3 = new JMenuItem("导入课程信息");
	        item4 = new JMenuItem("学生评价");
	        
	        item5 = new JMenuItem("导入成绩");
	        item6 = new JMenuItem("查看成绩");

	        item7 = new JMenuItem("返回");
	        //jta = new JTextArea();

	        // 设置布局
	        
	        menu1.add(item7);

	        menu3.add(item1);
	        menu3.add(item2);
	        menu3.add(item3);
	        menu3.add(item4);
	        
	        menu4.add(item5);
	        menu4.add(item6);


	        // 将菜单添加到菜单条上
	        jmb.add(menu1);
	        jmb.add(menu2);
	        jmb.add(menu3);
	        jmb.add(menu4);

	        item1.addActionListener(this);
			item2.addActionListener(this);
			item3.addActionListener(this);
			item4.addActionListener(this);
			item5.addActionListener(this);
			item6.addActionListener(this);
			item7.addActionListener(this);
			
	        // 将菜单添加到窗体上
	        this.setJMenuBar(jmb);

	        // 将工具条添加到窗体
	        this.add(jtb, BorderLayout.NORTH);

	        //JScrollPane jsp = new JScrollPane(jta);
	       // jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	        //this.add(jsp);
	        
	        jl1 = new JLabel(new ImageIcon("F://1.jpg"));
	        this.add(jl1);
	        // 展示
	        this.setTitle("教务管理系统（教师端）");
	        this.setSize(1200, 900);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setVisible(true);

	    }
	    
	    public void actionPerformed(ActionEvent ev)//为按钮添加的注册事件
		{
	    	if(ev.getSource()==item7)
			{
	    		new inter();
			}
	    	if(ev.getSource()==item1)
			{
	    		new 本学期课程表();
			}
			if(ev.getSource()==item2)
			{
				new 查看课程信息();
			}
			if(ev.getSource()==item3)
			{
				new 导入课程信息();
			}
			if(ev.getSource()==item4)
			{
				new 学生评价();
			}
			if(ev.getSource()==item5)
			{
				new 导入成绩();
			}
			if(ev.getSource()==item6)
			{
				new 查看成绩();
			}
			this.setVisible(false);
				
			}
		}
