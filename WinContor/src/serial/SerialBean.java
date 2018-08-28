/*
 * SerialBean
SerialBean�Ǳ����������Ӧ�ó���Ľӿڡ�������ж�����SerialBean�Ĺ��췽���Լ���ʼ�����ڣ��Ӵ��ڶ�ȡ���ݣ�������д�������Լ��رմ��ڵĺ���������������£�

public SerialBean(int PortID) 
����������һ��ָ���ض����ڵ�SerialBean���ô����ɲ���PortID��ָ����PortID = 1 ��ʾCOM1��PortID = 2 ��ʾCOM2���ɴ����ơ� 
public int Initialize() 
��������ʼ����ָ���Ĵ��ڲ����س�ʼ������������ʼ���ɹ�����1�����򷵻�-1����ʼ���Ľ���Ǹô��ڱ�SerialBean��ռ��ʹ�ã������������Ϊ9600, N, 8, 1��������ڱ��ɹ���ʼ�������һ�����̶�ȡ�Ӵ��ڴ�������ݲ����䱣���ڻ������С� 
public String ReadPort(int Length) 
�������Ӵ���(������)�ж�ȡָ�����ȵ�һ���ַ���������Lengthָ���������ַ����ĳ��ȡ� 
public void WritePort(String Msg) 
�������򴮿ڷ���һ���ַ���������Msg����Ҫ���͵��ַ����� 
public void ClosePort() 
������ֹͣ���ڼ����̲��رմ��ڡ� 


��ע���ã�

��javacomm20-win32 .zip���ص��ļ���ѹ������\javacomm20-win32\commapiĿ¼���б���������ļ���

comm.jar��javax.comm. properties��win32comm.dll��

���ļ�comm.jar������%JAVA_HOME%\jre\lib\ext;

�ļ� javax.comm. properties������%JAVA_HOME%\jre\lib;

�ļ�win32comm.dll������%JAVA_HOME%\bin��

ע��%JAVA_HOME%��jdk��·��������jre��


 */



package serial;

import java.io.*;
import java.util.*;
import javax.comm.*;




public class SerialBean {
	 static String PortName;
     CommPortIdentifier portId;
     SerialPort serialPort;
     static OutputStream out;
     static InputStream  in;
     SerialBuffer SB;
     ReadSerial   RT;
         /**
          *
          * Constructor
          *
          * @param PortID the ID of the serial to be used. 1 for COM1,
          * 2 for COM2, etc.
          *
          */
         public SerialBean(int PortID)
         {
             PortName = "COM" + PortID;
             System.out.println(PortName);
         }
         /**
          *
          * This function initialize the serial port for communication. It startss a
          * thread which consistently monitors the serial port. Any signal capturred
          * from the serial port is stored into a buffer area.
          *
          */
         public int Initialize()
         {
             int InitSuccess = 1;
             int InitFail    = -1;
         try
         {
             portId = CommPortIdentifier.getPortIdentifier(PortName);
             try
             {
                 serialPort = (SerialPort)
                 portId.open("Serial_Communication", 2000);
             } catch (PortInUseException e)
             {
            	 System.out.println("1try");
                 return InitFail;
             }
             //Use InputStream in to read from the serial port, and OutputStream
             //out to write to the serial port.
             try
             {
                 in  = serialPort.getInputStream();
                 out = serialPort.getOutputStream();
             } catch (IOException e)
             {
            	 System.out.println("2try");
                 return InitFail;
             }
             //Initialize the communication parameters to 9600, 8, 1, none.
             try
             {
                  serialPort.setSerialPortParams(38400,
                             SerialPort.DATABITS_8,
                             SerialPort.STOPBITS_1,
                             SerialPort.PARITY_NONE);
             } catch (UnsupportedCommOperationException e)
             {
            	 System.out.println("3try");
                 return InitFail;
             }
         } catch (NoSuchPortException e)
         {
        	 System.out.println("4try");
             return InitFail;
         }
         // when successfully open the serial port,  create a new serial buffer,
         // then create a thread that consistently accepts incoming signals from
         // the serial port. Incoming signals are stored in the serial buffer.
         SB = new SerialBuffer();
         RT = new ReadSerial(SB, in);
         RT.start();
         // return success information
         return InitSuccess;
         }
         /**
          *
          * This function returns a string with a certain length from the incomin
          * messages.
          *
          * @param Length The length of the string to be returned.
          *
          */
         public String ReadPort(int Length)
         {
             String Msg;
             Msg = SB.GetMsg(Length);
             return Msg;
         }
         /**
          *
          * This function sends a message through the serial port.
          *
          * @param Msg The string to be sent.
          *
          */
         public void WritePort(String Msg)
         {
             int c;
             try
             {
                 for (int i = 0; i < Msg.length(); i++)
                     out.write(Msg.charAt(i));
             } catch (IOException e)  {}
         }
         /**
          *
          * This function closes the serial port in use.
          *
          */
         public void ClosePort()
         {
             RT.stop();
             serialPort.close();
         }


}
