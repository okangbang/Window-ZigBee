
/*
 * SerialExample
SerialExample�Ǳ�������ṩ��һ�����̡�����ʵ�ֵĹ����Ǵ򿪴���COM1��������г�ʼ�����Ӵ��ڶ�ȡ��Ϣ������д���󽫴��������͵���

�ڡ�
 */
package serial;
import serial.*;
import java.io.*;

public class SerialExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TO DO: Add your JAVA codes here
        SerialBean SB = new SerialBean(1);
        String Msg;
        SB.Initialize();
        System.out.println("��ʼ����"+SB.Initialize());
       
        for (int i = 5; i <= 10; i++)
        {
            Msg = SB.ReadPort(100);
            SB.WritePort("Reply: " + Msg);
            System.out.println("�������ݣ�"+Msg);
        }
        SB.ClosePort();

	}

}
