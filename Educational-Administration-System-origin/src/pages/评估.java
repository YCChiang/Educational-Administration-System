package pages;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class 评估 extends JFrame implements ActionListener 
{
	JFrame frame;
	 JButton jb1,l8,jb2;
	 JTextArea Jtext1;
	    public static void main(String[] args) {
	        // TODO Auto-generated method stub
	    	评估 d5 = new 评估();

	    }

	    // 构造函数
	    public 评估() {
	    	frame = new JFrame();// 设置一个新的面板
			frame.setTitle("评估");

			frame.setSize(550, 670);
			frame.setBackground(Color.LIGHT_GRAY);
			frame.setLocationRelativeTo(null);

			frame.setLayout(null);
	        // 多行文本框会根据情况自己调节大小
			
			l8 = new JButton("评估内容");
			l8.setBounds(35, 100, 140, 30);
			frame.add(l8);
	    	jb1 = new JButton("返回");
	    	jb2 = new JButton("提交");
	        //this.add(jsp);

			Jtext1 = new JTextArea();//定义成文本区
			Jtext1.setBounds(180, 100, 200, 150);
			frame.add(Jtext1);
			frame.add(jb1);
			frame.add(jb2);
			jb1.setBounds(250, 500, 60, 20);
			jb2.setBounds(180, 500, 60, 20);
	        jb1.addActionListener(this);
	        jb2.addActionListener(this);
	        frame.setVisible(true);
	    }
	    public void actionPerformed(ActionEvent ev)//为按钮添加的注册事件
		{
			if(ev.getSource() == jb1)
			{
				frame.setVisible(false);
				new 教学评估();
				
			}
			if(ev.getSource() == jb2)
			{
				JOptionPane.showMessageDialog(null, "评估成功");
			}
		}
}
