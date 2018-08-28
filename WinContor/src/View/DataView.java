package View;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import serial.SerialBean;
import win.data.WindowsData;
import win.db.DuAndXue;

public class DataView extends JInternalFrame {
	private TextArea text=null;
	private JPanel table=null;
	private JPanel btn_panel = null;// 按钮面板
	private Button btn_exit=null;
	public DataView() throws Exception{
		init();
	}
	public void init() throws Exception{
		btn_panel=new JPanel(new GridLayout(3, 1,0,10));
		btn_exit=new Button("退出");
		DuAndXue data=new DuAndXue();
		this.setSize(800,500);
		this.setTitle("历史数据");
		this.setResizable(false);//不可改变窗口大小
		this.setIconifiable(true);//窗体可最小化
		this.setClosable(true);//窗体可关闭
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	//	setDebugGraphicsOptions(DISPOSE_ON_CLOSE);
		table=new JPanel(new BorderLayout());
		text=new TextArea();
		btn_panel.add(new JPanel());
		btn_panel.add(btn_exit);
		btn_panel.add(new JPanel());
		
		btn_exit.setFont(new Font("宋体", Font.BOLD, 16));
		btn_exit.setForeground(Color.RED);
		btn_exit.setBackground(Color.green);
		text.setBackground(Color.white);
		List<WindowsData> windata=new ArrayList<WindowsData>();
		windata=data.query();
		text.setFont(new Font("宋体", Font.BOLD, 16));
		text.setForeground(Color.BLUE);
		String str=windata.toString();
		
		text.setText(str);
		text.setEditable(false);
		table.add(btn_panel,BorderLayout.EAST);
		table.add( text,BorderLayout.CENTER);	
		this.getContentPane().add(table);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.pack();
		this.setVisible(true);
		
		btn_exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
	}

}
