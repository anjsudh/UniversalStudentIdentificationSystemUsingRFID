package university;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.*;
import javax.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
/**Student class --represents the student object
 * 
 */

/**
 * @author Aruna
 *
 */

public class Student {

	/**
	 * @param args
	 */
	private String RFID;
	private String FirstName,LastName,Address,Contact1,Contact2,Email;
	private String DOB;
	private String Batch,Department;
	private String Username;
	private String Pwd;
	public static Connection con;
	
	public Student(String s1,String s2,String sd1,String d1,String s3,String s4,String s5,String s6,String sd2,String s7,String sd3,String s8)
	{
			this.RFID=s1;
			this.FirstName=s2;
			this.LastName=sd1;
			this.DOB=d1; 
			
			this.Batch=s4;
			this.Department=s3;
			this.Address=s5;
			this.Contact1=s6;
			this.Contact2=sd2;
			this.Email=s7;
			this.Username=sd3;
			this.Pwd=s8;
	}
	@SuppressWarnings("deprecation")
	public Student(ResultSet rs)
	{
		try
		{
		this.RFID=rs.getString(1);
		this.FirstName=rs.getString(2);
		this.LastName=rs.getString(3);
		this.DOB=rs.getString(4);
		this.Batch=rs.getString(6);
		this.Department=rs.getString(5);
		this.Address=rs.getString(7);
		this.Contact1=rs.getString(8);
		this.Contact2=rs.getString(9);
		this.Email=rs.getString(10);
		this.Username=rs.getString(11);
		this.Pwd=rs.getString(12);
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
	public static void enrolCourse(String s1,String s2,String s3)
	{
		try
		{
		String sql="insert into univ.enrol values(?,?,?)";
		
                String userName = "db2admin";
                String password = "aruna";
                String url = "jdbc:db2://127.0.0.1:50000/univdb";
                Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
                JOptionPane.showMessageDialog(null, "Driver found!!");
                con = DriverManager.getConnection(url, userName, password);
                JOptionPane.showMessageDialog(null, "Conn established!!");
                PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1,s1);
		stmt.setString(2,s2);
		stmt.setString(3,s3);
		stmt.executeUpdate();
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
	public void insertStudent()
	{
		
		try
		{
			String sql="insert into univ.student values(?,?,?,?,?,?,?,?,?,?,?,?)";
			String userName = "db2admin";
                        String password = "aruna";
                        String url = "jdbc:db2://127.0.0.1:50000/univdb";
                        Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
                        JOptionPane.showMessageDialog(null, "Driver found!!");
                        con = DriverManager.getConnection(url, userName, password);
                        JOptionPane.showMessageDialog(null, "Conn established!!");
			PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1,RFID);
		stmt.setString(2,FirstName);
		stmt.setString(3,LastName);
                JOptionPane.showMessageDialog(null,DOB);
                
		stmt.setString(4,DOB);
                stmt.setString(5,Department);
		stmt.setString(6,Batch);
		stmt.setString(7,Address);
		stmt.setString(8,Contact1);
		stmt.setString(9,Contact2);
		stmt.setString(10,Email);
		stmt.setString(11,Username);
		stmt.setString(12,Pwd);
		stmt.executeUpdate();
                JOptionPane.showMessageDialog(null,"Student Inserted");
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
		
	}
	
	public void setInentry(int SessionId)
	{
			String sql="update univ.attendance set inentry=1 where SessionId=? and RFID=?";
			try
			{
			con=DriverManager.getConnection("jdbc:db2://localhost:50000/univ","db2admin","aruna");
			PreparedStatement stmt=con.prepareStatement(sql);
			stmt.setString(1,new Integer(SessionId).toString());
			stmt.setString(2,RFID);
			stmt.executeUpdate();
			}
			catch(Exception E)
			{
				E.printStackTrace();
			}
	}
	public void setOutentry(int SessionId)
	{
		String sql="update univ.attendance set outentry=1 where SessionId=? and RFID=?";
		try
		
		{
		con=DriverManager.getConnection("jdbc:db2://localhost:50000/univ","db2admin","aruna");
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1,new Integer(SessionId).toString());
		stmt.setString(2,RFID);
		stmt.executeUpdate();
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
		
	}
	public void markAttendance(int SessionId)
	{
	
		String sql="update univ.attendance set presentflag=1 where SessionId=? and RFID=? and inentry=1 and outentry=1";
		try
		
		{
		con=DriverManager.getConnection("jdbc:db2://localhost:50000/univ","db2admin","aruna");
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1,new Integer(SessionId).toString());
		stmt.setString(2,RFID);
		stmt.executeUpdate();
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
	public static Student returnStudent(String RFID1)
	{
		String sql="select * from univ.student where RFID=?";
		Student s = null;
		try
		
		{
		con=DriverManager.getConnection("jdbc:db2://localhost:50000/univ","db2admin","aruna");
		PreparedStatement stmt=con.prepareStatement(sql);
		stmt.setString(1,RFID1);
		ResultSet rs=stmt.executeQuery();
		rs.first();
		s=new Student(rs);
		
		
		}
		catch(Exception E)
		{
			E.printStackTrace();
			
		}
	return s;
	}
}

