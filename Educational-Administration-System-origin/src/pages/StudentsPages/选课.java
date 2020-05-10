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

public class 选课 extends JFrame implements ActionListener 
{
	JPanel jp1,jp2,jp3;
    JLabel jlb1, jlb2,jlb3;
    JButton jb1, jb2,jb3;
    JTextField jtf1;
    JPasswordField jpf1;
    JCheckBox jcb1;

    public static void main(String[] args) {
    	选课 d1 = new 选课();

    }

    // 构造函数
    public 选课() {

        jlb1 = new JLabel("课程名/课程ID");

        jb1 = new JButton("选课");
        jb2 = new JButton("返回");
        jb3 = new JButton("搜索");

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        
        jtf1 = new JTextField(10);

        jpf1 = new JPasswordField(10);// 设置布局管理
        int n=3;
        this.setLayout(new GridLayout(n, 1));
        jlb3 = new JLabel("课程");
        jcb1 = new JCheckBox("软件工程");
        // 下面可以设置单选
        //ButtonGroup bg2=new ButtonGroup();
        //bg2.add(jcb1);

        // 加入各个组件
        jp1.add(jlb1);
        jp1.add(jtf1);
        jp1.add(jb3);
        
        jp2.add(jlb3);
        jp2.add(jcb1);

        jp3.add(jb1);
        jp3.add(jb2);
        
        jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		
        // 加入到JFrame
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.setSize(500, 400);
        this.setTitle("选课");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ev)//为按钮添加的注册事件
	{
    	if(ev.getSource() == jb1)
		{
    		if(jcb1.isSelected())
    		{
    			JOptionPane.showMessageDialog(null, "选课成功");
    		}
		}
		if(ev.getSource() == jb2)
		{
			new student();
		}
		if(ev.getSource() == jb3)
		{
			//搜索所有课程
		}
		
	}
}
