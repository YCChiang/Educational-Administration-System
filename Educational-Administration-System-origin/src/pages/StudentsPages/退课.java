package pages.StudentsPages;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class 退课 extends JFrame implements ActionListener 
{
	JPanel jp1,jp2;
    JLabel jlb1, jlb2,jlb3;
    JButton jb1, jb2,jb3;
    JTextField jtf1;
    JPasswordField jpf1;
    JCheckBox jcb1;

    public static void main(String[] args) {
    	退课 d1 = new 退课();

    }

    // 构造函数
    public 退课() {

        jb1 = new JButton("退课");
        jb2 = new JButton("返回");

        jp1 = new JPanel();
        jp2 = new JPanel();

        jpf1 = new JPasswordField(10);// 设置布局管理
        int n=2;
        this.setLayout(new GridLayout(n, 1));
        jlb3 = new JLabel("课程");
        jcb1 = new JCheckBox("软件工程");
        // 下面可以设置单选
        //ButtonGroup bg2=new ButtonGroup();
        //bg2.add(jcb1);

        // 加入各个组件
        
        jp1.add(jlb3);
        jp1.add(jcb1);

        jp2.add(jb1);
        jp2.add(jb2);
        
        jb1.addActionListener(this);
		jb2.addActionListener(this);
		
        // 加入到JFrame
        this.add(jp1);
        this.add(jp2);
        this.setSize(500, 400);
        this.setTitle("退课");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ev)//为按钮添加的注册事件
	{
    	if(ev.getSource() == jb1)
		{
    		JOptionPane.showMessageDialog(null, "退课成功");
		}
		if(ev.getSource() == jb2)
		{
			new student();
		}
	}
}
