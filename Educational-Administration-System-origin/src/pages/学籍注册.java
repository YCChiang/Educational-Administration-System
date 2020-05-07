package pages;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class 学籍注册 extends JFrame implements ActionListener 
{
	JPanel jp1;
    JButton jb1, jb2;
    JTextField jtf1;
    JPasswordField jpf1;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	学籍注册 d1 = new 学籍注册();

    }

    // 构造函数
    public 学籍注册() {

        jp1 = new JPanel();


        jb1 = new JButton("注册");
        jb2 = new JButton("取消");

        jtf1 = new JTextField(10);

        jpf1 = new JPasswordField(10);// 设置布局管理
        this.setLayout(new GridLayout(4, 1));
        // 加入各个组件;


        jp1.add(jb1);
        jp1.add(jb2);
        
        jb1.addActionListener(this);
		jb2.addActionListener(this);
		
        // 加入到JFrame
        this.add(jp1);
        this.setSize(200, 200);
        this.setTitle("学籍注册");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ev)//为按钮添加的注册事件
	{
    	if(ev.getSource() == jb1)
		{
    		
    		JOptionPane.showMessageDialog(null, "注册成功");
    		this.setVisible(false);
    		new student();
		}
		if(ev.getSource() == jb2)
		{
			new student();
			
		}
	}
}