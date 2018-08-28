package win.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String URL="jdbc:sqlite:e:\\windowsdata.db&useSSL=true";
//	private static final String USER="root";
//	private static final String PASSWORD="123456";
	
	private static Connection conn=null;
	
	static {
		try {
			//1.������������
			Class.forName("org.sqlite.JDBC");
			//2.������ݿ������
			conn=DriverManager.getConnection(URL);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		return conn;
	}

}
