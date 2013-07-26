package university;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Session {
	public static int SessionNo=25;
	int SessionID;
	Connection con;
	public Session(int SID)
	{
		
		SessionID=SID;
		
	}
	public static Session getSession(int SID)
	{
		Session s=new Session(SID);
		return s;
	}
	public void markAttendance()
	{
		String sql="update univ.attendance set presentflag=1 where sessionid=? and inentry=1 and outentry=1";
try
		
		{
		con=DriverManager.getConnection("jdbc:db2://localhost:50000/univdb","db2admin","aruna");
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1,new Integer(SessionID).toString());
		stmt.executeUpdate();
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
	}
	

