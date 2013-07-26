package university;
import java.util.*;
import java.util.Date;
import java.sql.*;
import javax.swing.*;


public class Faculty {
		String RFID,FirstName,LastName,Contact1,Contact2,Email,Address,Qualification,Department,UserName,Password,DOB,DOJ;
		int salary;
		static Connection con;
		public Faculty(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,String s9,String s10,String s11,String d1,String s12,String s13)
		{
			RFID=s1;
			FirstName=s2;
			LastName=s3;
			Contact1=s4;
			Contact2=s5;
			Email=s6;
			Address=s7;
			Qualification=s8;
			Department=s9;
			UserName=s10;
			Password=s11;
			salary=Integer.parseInt(d1);
			DOB=s12;
			DOJ=s13;
			
		}
		public Faculty(ResultSet rs)
		{
			try
			{
				RFID=rs.getString(1);
				FirstName=rs.getString(2);
				LastName=rs.getString(3);
				Contact1=rs.getString(4);
				Contact2=rs.getString(5);
				Email=rs.getString(6);
				Address=rs.getString(7);
				Qualification=rs.getString(8);
				Department=rs.getString(9);
				UserName=rs.getString(10);
				Password=rs.getString(11);
				salary=Integer.parseInt(rs.getString(12));
				DOB=rs.getString(13);
				DOJ=rs.getString(14);
			}
			catch(Exception E)
			{
				E.printStackTrace();
			}
		}
		
		public void insertFaculty()
		{
			String sql="insert into univ.faculty values('"+RFID+"','"+FirstName+"','"+LastName+"',"+Contact1+","+Contact2+",'"+Email+"','"+Address+"','"+Qualification+"','"+Department+"','"+UserName+"','"+Password+"',"+salary+")";
			try
			{
                        String userName = "db2admin";
                        String password = "aruna";
                        String url = "jdbc:db2://127.0.0.1:50000/univdb";
                        Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
                        //JOptionPane.showMessageDialog(null, "Driver found!!");
                        con = DriverManager.getConnection(url, userName, password);
                        //JOptionPane.showMessageDialog(null, "Conn established!!");
			PreparedStatement stmt=con.prepareStatement(sql);
			/*stmt.setString(1,RFID);
			stmt.setString(2,FirstName);
			stmt.setString(3,LastName);
			stmt.setString(4,Contact1);
			stmt.setString(5,Contact2);
			stmt.setString(6,Email);
			stmt.setString(7,Address);
			stmt.setString(8,Qualification);
			stmt.setString(9,Department);
			stmt.setString(10,UserName);
			stmt.setString(11,Password);
			stmt.setString(12,Integer.toString(salary));*/
			stmt.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Insrtd!!");
			}
			catch(Exception E)
			{
				JOptionPane.showMessageDialog(null,E);
			}
			
			}
	public static boolean authenticate(String username,String pass)
	{
			String sql="select * from univ.faculty where UserName='"+username+"' and Password='"+pass+"'";
			try
			
			{
			String userName = "db2admin";
                        String password = "aruna";
                        String url = "jdbc:db2://127.0.0.1:50000/univdb";
                        Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
                        //JOptionPane.showMessageDialog(null, "Driver found!!");
                        con = DriverManager.getConnection(url, userName, password);
                        //JOptionPane.showMessageDialog(null, "Conn established!!");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next())
				return true;
			}
			catch(Exception E)
			{
				E.printStackTrace();
			}
			return false;
	}
	public static String retFacultyID(String username)
        {
            ResultSet rs=null;String ret=null;;
		String sql="select * from univ.faculty where UserName='"+username+"'";
			try
			{
			String userName = "db2admin";
                        String password = "aruna";
                        String url = "jdbc:db2://127.0.0.1:50000/univdb";
                        Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
                        JOptionPane.showMessageDialog(null, "Driver found!!");
                        con = DriverManager.getConnection(url, userName, password);
                        JOptionPane.showMessageDialog(null, "Conn established!!");
			PreparedStatement stmt=con.prepareStatement(sql);
			rs=stmt.executeQuery();
			if(rs.next())
                            ret=rs.getString("rfid");
                        else
                            ret=null;
			}
			catch(Exception e)
			{
			e.printStackTrace();
			}
                        return ret;
	}
        public static Faculty retFaculty(String FacID)
	{
		String sql="select * from univ.faculty where RFID=?";
		Faculty f=null;
		try
		
		{
		con=DriverManager.getConnection("jdbc:db2://localhost:50000/univ","db2admin","aruna");
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1,FacID);
		ResultSet rs=stmt.executeQuery();
		rs.first();
		f=new Faculty(rs);
		}
		catch(Exception E)
		{
			E.printStackTrace();
			
		}
		return f;
		
	}
	public int startSession(String CourseID,String Coursename,String Date,String Period,String Batch)
	{
		Session s=new Session(Session.SessionNo++);
		String sql="insert into univ.sessiondetails values(?,?,?,?,?,?)";
		try
		{
		String status="started";
		con=DriverManager.getConnection("jdbc:db2://localhost:50000/univ","db2admin","aruna");
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1,new Integer(Session.SessionNo).toString());
		stmt.setString(2,CourseID);
		stmt.setString(3,Coursename);
		stmt.setString(4,Date);
		stmt.setString(5,Period);
		stmt.setString(6,status);
		stmt.executeUpdate();
		String sql2="select RFID from univ.enrol where courseid=? and batch=?";
		PreparedStatement stmt2=con.prepareStatement(sql2);
		ResultSet rs=stmt2.executeQuery();
		rs.first();
		String sql3="insert into univ.attendance values(?,?,?,?,?)";
		PreparedStatement stmt3=con.prepareStatement(sql3);
		stmt.setString(1,new Integer(Session.SessionNo).toString());
		stmt.setString(2,rs.getString(1));
		stmt.setString(3,"0");
		stmt.setString(4,"0");
		stmt.setString(5,"0");
		stmt.executeUpdate();
		while(rs.next())
		{
			stmt.setString(2,rs.getString(1));
			stmt.executeUpdate();
		}
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
		return Session.SessionNo ;
	}
	public void returnFacultyID(String username)
	{
		String sql="update univ.sessiondetails set status=?";
	
		try
		{
		String status="inentrystarted";
		con=DriverManager.getConnection("jdbc:db2://localhost:50000/univ","db2admin","aruna");
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1,status);
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
	public void start_Inentry(int SID)
	{
		String sql="update univ.sessiondetails set status=?";
	
		try
		{
		String status="inentrystarted";
		con=DriverManager.getConnection("jdbc:db2://localhost:50000/univ","db2admin","aruna");
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1,status);
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
	public void start_outentry(int SID)
	{
		String sql="update univ.sessiondetails set status=?";
		
		try
		{
		String status="outentrystarted";
		con=DriverManager.getConnection("jdbc:db2://localhost:50000/univ","db2admin","aruna");
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1,status);
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
	public void stop_inentry(int SID)
	{
		String sql="update univ.sessiondetails set status=?";
		
		try
		{
		String status="inentrystopped";
		con=DriverManager.getConnection("jdbc:db2://localhost:50000/univ","db2admin","aruna");
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1,status);
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
		Session.getSession(SID).markAttendance();
	}
	
	}	

	
		



