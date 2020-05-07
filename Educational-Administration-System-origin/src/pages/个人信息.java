package pages;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

class 个人信息 extends JFrame implements ActionListener 
{
	JFrame frame;
	 JButton jb1,l8;
	 JTextArea Jtext1;
	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	        个人信息 d5 = new 个人信息();

	    }

	    // 构造函数
	    public 个人信息() {
	    	frame = new JFrame();// 设置一个新的面板
			frame.setTitle("学生个人信息");

			frame.setSize(550, 670);
			frame.setBackground(Color.LIGHT_GRAY);
			frame.setLocationRelativeTo(null);

			frame.setLayout(null);
	        // 多行文本框会根据情况自己调节大小
			
			l8 = new JButton("个人信息");
			l8.setBounds(35, 100, 140, 30);
			frame.add(l8);
	    	jb1 = new JButton("返回");
	        //this.add(jsp);

			Jtext1 = new JTextArea();//定义成文本区
			Jtext1.setBounds(180, 100, 200, 150);
			frame.add(Jtext1);
			frame.add(jb1);
			jb1.setBounds(200, 500, 60, 20);
	        jb1.addActionListener(this);
	        frame.setVisible(true);
	    }
	    public void actionPerformed(ActionEvent ev)//为按钮添加的注册事件
		{
			if(ev.getSource() == jb1)
			{
				frame.setVisible(false);
				new student();
				
			}
		}
}