
/*
 * SerialExample
SerialExample是本类库所提供的一个例程。它所实现的功能是打开串口COM1，对其进行初始化，从串口读取信息对其进行处理后将处理结果发送到串

口。
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
        System.out.println("初始化："+SB.Initialize());
       
        for (int i = 5; i <= 10; i++)
        {
            Msg = SB.ReadPort(100);
            SB.WritePort("Reply: " + Msg);
            System.out.println("串口数据："+Msg);
        }
        SB.ClosePort();

	}

}
