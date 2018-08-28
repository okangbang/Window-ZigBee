package win.db;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import win.data.WindowsData;



public class DuAndXue {

	public static void add(WindowsData t) throws Exception{
		Connection conn=DBUtil.getConnection();
		String sql="" +
				"insert into test " +
				"values(" +
				"?,?,?,?,?)";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		
		ptmt.setInt(1, t.getNumber());
		ptmt.setInt(2, t.getState());
		ptmt.setDate(3, new Date(t.getTime().getTime()));
		ptmt.setFloat(4, t.getTemperature());
		ptmt.setFloat(5, t.getHumidity());
		//System.out.println("¡¥Ω” ß∞‹");
		ptmt.execute();
				
	}
	public List<WindowsData> query() throws Exception{
		List<WindowsData> result=new ArrayList<WindowsData>();		
		Connection conn=DBUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select number,state,time,temperature,humidity from test  ");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		ResultSet rs=ptmt.executeQuery();
		
		WindowsData g=null;
		while(rs.next()){
			g=new WindowsData();
			g.setNumber(rs.getInt("number"));
			g.setState(rs.getInt("state"));
			//g.setTime(new Date(g.getTime().getTime()));
			g.setTime(rs.getDate("time"));
			g.setTemperature(rs.getFloat("temperature"));
			g.setHumidity(rs.getFloat("humidity"));
			result.add(g);
		}
		return result;
	}

}
