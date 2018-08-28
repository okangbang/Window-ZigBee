package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import serial.SerialBean;
import win.data.WindowsData;
import win.db.DuAndXue;

public class MainView extends JFrame {

	public static void main(String[] args) throws Exception {
		new MainView();
		
	}

	/**
	 * 
	 */
	private int flag = 1;// 默认自动控制
	private static final long serialVersionUID = 1L;
	private JPanel main_panel = null;// 主面板
	private JPanel wel_panel = null;// 欢迎面板
	private JPanel btn_panel = null;// 按钮面板
	private JPanel windw_01 = null;
	private JPanel windw_02 = null;
	private JPanel windw_03 = null;
	private JPanel windw = null;
	private JPanel mainwindw = null;
	private JDesktopPane funcDesktop = null;// 桌面面板

	private JTextField con_state = null; // 控制方式
	private JTextField text_number = null;
	private JTextField text_state = null;
	private JTextField text_temperature = null;
	private JTextField text_humidity = null;

	private JTextField con_state2 = null; // 控制方式
	private JTextField text_number2 = null;
	private JTextField text_state2 = null;
	private JTextField text_temperature2 = null;
	private JTextField text_humidity2 = null;

	private JTextField con_state3 = null; // 控制方式
	private JTextField text_number3 = null;
	private JTextField text_state3 = null;
	private JTextField text_temperature3 = null;
	private JTextField text_humidity3 = null;

	private JButton open_window = null;// 开启窗户
	private JButton close_window = null;// 关闭窗户
	private JButton btn_self = null;// 手动
	private JButton btn_hand = null;// 自动
	private JButton btn_selet = null;// 查询数据

	private JLabel lb_con_state = null;// 控制方式标签
	private JLabel lb_number = null;
	private JLabel lb_state = null;
	private JLabel lb_temperature = null;
	private JLabel lb_humidity = null;

	private JLabel lb_con_state2 = null;// 控制方式标签
	private JLabel lb_number2 = null;
	private JLabel lb_state2 = null;
	private JLabel lb_temperature2 = null;
	private JLabel lb_humidity2 = null;

	private JLabel lb_con_state3 = null;// 控制方式标签
	private JLabel lb_number3 = null;
	private JLabel lb_state3 = null;
	private JLabel lb_temperature3 = null;
	private JLabel lb_humidity3 = null;

	private JLabel deskLabel = null;// 图片标签
	private JLabel lb_welcom = null;// 欢迎标题
	public MainView() throws Exception {
		
		WindowsData winData = new WindowsData();
		init();
		
		WindowsControl(winData);
	}

	public void init() {
		main_panel = new JPanel(new BorderLayout());
		btn_panel = new JPanel(new GridLayout(7, 1, 0, 35));
		windw_01 = new JPanel(new GridLayout(10, 1, 0, 10));
		windw_02 = new JPanel(new GridLayout(10, 1, 0, 10));
		windw_03 = new JPanel(new GridLayout(10, 1, 0, 10));
		windw = new JPanel(new GridLayout(1, 3, 10, 0));
		mainwindw=new JPanel();
		mainwindw.setOpaque(false);
		funcDesktop = new JDesktopPane();
		
		open_window = new JButton("打开窗户");
		close_window = new JButton("关闭窗户");
		btn_self = new JButton("自动控制");
		btn_hand = new JButton("手动控制");
		btn_selet=new JButton("历史数据查询");
		///////////
		lb_con_state = new JLabel("控制方式");
		lb_number = new JLabel("窗口编号1");
		lb_state = new JLabel("窗口状态");
		lb_temperature = new JLabel("空气温度");
		lb_humidity = new JLabel("空气湿度%");

		con_state = new JTextField();
		text_number = new JTextField();
		text_state = new JTextField();
		text_temperature = new JTextField();
		text_humidity = new JTextField();
		//设置文本框不可写
		con_state.setEditable(false);
		con_state.setBackground(Color.white);
		text_number.setEditable(false);
		text_number.setBackground(Color.white);
		text_state.setEditable(false);
		text_state.setBackground(Color.white);
		text_temperature.setEditable(false);
		text_temperature.setBackground(Color.white);
		text_humidity.setEditable(false);
		text_humidity.setBackground(Color.white);
		///////////////
		lb_con_state2 = new JLabel("控制方式");
		lb_number2 = new JLabel("窗口编号2");
		lb_state2 = new JLabel("窗口状态");
		lb_temperature2 = new JLabel("空气温度");
		lb_humidity2 = new JLabel("空气湿度%");

		con_state2 = new JTextField();
		text_number2 = new JTextField();
		text_state2 = new JTextField();
		text_temperature2 = new JTextField();
		text_humidity2 = new JTextField();
		
		//设置文本框不可写
				con_state2.setEditable(false);
				con_state2.setBackground(Color.white);
				text_number2.setEditable(false);
				text_number2.setBackground(Color.white);
				text_state2.setEditable(false);
				text_state2.setBackground(Color.white);
				text_temperature2.setEditable(false);
				text_temperature2.setBackground(Color.white);
				text_humidity2.setEditable(false);
				text_humidity2.setBackground(Color.white);

		///////////////
		lb_con_state3 = new JLabel("控制方式");
		lb_number3 = new JLabel("窗口编号3");
		lb_state3 = new JLabel("窗口状态");
		lb_temperature3 = new JLabel("空气温度");
		lb_humidity3 = new JLabel("空气湿度%");

		con_state3 = new JTextField();
		text_number3 = new JTextField();
		text_state3 = new JTextField();
		text_temperature3 = new JTextField();
		text_humidity3 = new JTextField();
		
		//设置文本框不可写
				con_state3.setEditable(false);
				con_state3.setBackground(Color.white);
				text_number3.setEditable(false);
				text_number3.setBackground(Color.white);
				text_state3.setEditable(false);
				text_state3.setBackground(Color.white);
				text_temperature3.setEditable(false);
				text_temperature3.setBackground(Color.white);
				text_humidity3.setEditable(false);
				text_humidity3.setBackground(Color.white);

		// 初始化显示面板
		con_state.setText("自动");
		windw_01.add(lb_con_state);
		windw_01.add(con_state);
		windw_01.add(lb_number);
		windw_01.add(text_number);
		windw_01.add(lb_state);
		windw_01.add(text_state);
		windw_01.add(lb_temperature);
		windw_01.add(text_temperature);
		windw_01.add(lb_humidity);
		windw_01.add(text_humidity);

		windw_02.add(lb_con_state2);
		windw_02.add(con_state2);
		windw_02.add(lb_number2);
		windw_02.add(text_number2);
		windw_02.add(lb_state2);
		windw_02.add(text_state2);
		windw_02.add(lb_temperature2);
		windw_02.add(text_temperature2);
		windw_02.add(lb_humidity2);
		windw_02.add(text_humidity2);

		windw_03.add(lb_con_state3);
		windw_03.add(con_state3);
		windw_03.add(lb_number3);
		windw_03.add(text_number3);
		windw_03.add(lb_state3);
		windw_03.add(text_state3);
		windw_03.add(lb_temperature3);
		windw_03.add(text_temperature3);
		windw_03.add(lb_humidity3);
		windw_03.add(text_humidity3);

		windw.add(windw_01);
		windw.add(windw_02);
		windw.add(windw_03);
		
		btn_panel.add(new JLabel());// 用来填充的标签控件

		btn_panel.add(open_window);
		btn_panel.add(close_window);
		btn_panel.add(btn_self);
		btn_panel.add(btn_hand);
		btn_panel.add(btn_selet);

		btn_panel.add(new JLabel());// 用来填充的标签控件

		// 设置面板边框
		btn_panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "快捷功能区"));
		windw.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "数据区"));
		// 初始化欢迎面板
		wel_panel = new JPanel();
		lb_welcom = new JLabel("欢    迎     使     用    窗    户    自    动    开    关    系    统");
		lb_welcom.setFont(new Font("宋体", Font.BOLD, 23));
		lb_welcom.setForeground(Color.BLUE);
		wel_panel.add(lb_welcom);

		// 初始化桌面面板
		
		funcDesktop.setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "数据显示区"));
		ImageIcon image = new ImageIcon("src/back.jpg");
		deskLabel = new JLabel(image);
		deskLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		
//		deskLabel.add(windw);

//		funcDesktop.add(deskLabel, new Integer(Integer.MIN_VALUE));
		
		// 设置文本框字体
		con_state.setFont(new Font("宋体", Font.BOLD, 23));
		con_state.setForeground(Color.BLUE);
		text_number.setForeground(Color.BLUE);
		text_number.setFont(new Font("宋体", Font.BOLD, 23));
		text_number.setForeground(Color.BLUE);
		text_state.setFont(new Font("宋体", Font.BOLD, 23));
		text_state.setForeground(Color.BLUE);
		text_temperature.setFont(new Font("宋体", Font.BOLD, 23));
		text_temperature.setForeground(Color.BLUE);
		text_humidity.setFont(new Font("宋体", Font.BOLD, 23));
		text_humidity.setForeground(Color.BLUE);

		
		main_panel.add(btn_panel, BorderLayout.EAST);
		main_panel.add(wel_panel, BorderLayout.NORTH);	
//		main_panel.add(funcDesktop,BorderLayout.CENTER);
		main_panel.add(windw, BorderLayout.CENTER);
		
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {

				new Thread(new DynaminThread()).start();
			}
		});

		this.setTitle("窗户自动控制系统");
		this.getContentPane().add(main_panel);
		this.setSize(1000, 650);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
		

	

	}

	private void WindowsControl(WindowsData winData) throws Exception {
		
		registerListener(winData);
//		SerialBean SB = new SerialBean(1);
//		SB.Initialize();
//		System.out.println("初始化：" + SB.Initialize());
//		winData.setState(1);// 默认开窗
//				
//			while (true) {
//				registerListener(winData);
//				if (flag == 1) {
//			
//				String Msg;
//				String Temperature;
//				String Humidity;
//				float temp;
//				float hum;
//				Msg = SB.ReadPort(28);
//				Date now = new Date();
//				Temperature = Msg.substring(12, 17);
//				Humidity = Msg.substring(21, 26);
//				temp = Float.parseFloat(Temperature);
//				hum = Float.parseFloat(Humidity);
//
//				winData.setNumber(1);
//				winData.setTime(now);
//				winData.setTemperature(temp);
//				winData.setHumidity(hum);
//						
//				DuAndXue.add(winData);
//
//				System.out.println(winData.toString());
//				if (winData.getState() == 1) {
//					text_state.setText("开");
//				} else {
//					text_state.setText("关");
//				}
//				text_number.setText(winData.getNumber() + "");
//				text_temperature.setText(winData.getTemperature() + "");
//				text_humidity.setText(winData.getHumidity() + "");
//
//				if ((winData.getHumidity() >= 95.25) && winData.getState() == 1) {
//					SB.WritePort(0 + "");// 关窗
//					winData.setState(0);
//					text_state.setText("关");
//					// System.out.println(winData.getState());
//				}
//				if ((winData.getHumidity() < 95.25) && winData.getState() == 0) {
//					SB.WritePort(1 + "");// 开窗
//					winData.setState(1);
//					text_state.setText("开");
//					// System.out.println(winData.getState());
//				}
//				
//			}
//				if (flag == 0) {
//					
//					String Msg;
//					String Temperature;
//					String Humidity;
//					float temp;
//					float hum;
//					Msg = SB.ReadPort(28);
//					Date now = new Date();
//					Temperature = Msg.substring(12, 17);
//					Humidity = Msg.substring(21, 26);
//					temp = Float.parseFloat(Temperature);
//					hum = Float.parseFloat(Humidity);
//
//					winData.setNumber(1);
//					winData.setTime(now);
//					winData.setTemperature(temp);
//					winData.setHumidity(hum);
//
//					System.out.println(winData.toString());
//					if (winData.getState() == 1) {
//						text_state.setText("开");
//					} else {
//						text_state.setText("关");
//					}
//					text_number.setText(winData.getNumber() + "");
//					text_temperature.setText(winData.getTemperature() + "");
//					text_humidity.setText(winData.getHumidity() + "");
//		}
//			}

	}

	private void registerListener(WindowsData windata) throws Exception {

		SerialBean SB = new SerialBean(1);

		open_window.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windata.setState(1);
				SB.WritePort(1 + "");
				text_state.setText("开");
			}
		});

		close_window.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				windata.setState(0);
				SB.WritePort(0 + "");
				text_state.setText("关");
			}
		});

		btn_self.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				flag = 1; // 自动
				con_state.setText("自动");
			}
		});

		btn_hand.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				flag = 0; // 手动
				con_state.setText("手动");
			}
		});
		
		btn_selet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					//main_panel.add(funcDesktop,BorderLayout.SOUTH);
					DataView dataView=new DataView();					
					main_panel.add(dataView,BorderLayout.SOUTH);
					dataView.toFront();//视图显示在前面
					
										
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}

	// 线程类，让欢迎字移动
	private class DynaminThread implements Runnable {
		@Override
		public void run() {
			while (true) {
				for (int i = 1000; i > -750; i--) {
					try {
						Thread.sleep(10);

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					lb_welcom.setLocation(i, 5);
				}
			}
		}
	}
}
