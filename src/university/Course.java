package university;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Course {
	private String CourseID;
	private String CourseName;
	private int Semester;
	private int Credits;
	public Course(String s1,String s2,int s3,int s4)
	{
		this.CourseID=s1;
		this.CourseName=s2;
		this.Semester=s3;
		this.Credits=s4;
		
	}
	public Course(ResultSet rs)
	{
		try
		{
		this.CourseID=rs.getString(1);
		this.CourseName=rs.getString(2);
		this.Semester=new Integer(rs.getString(3));
		this.Credits=new Integer(rs.getString(4));
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
		
	}
	public static void addCourse(String s1,String s2,String s3,String s4)
	{
            Connection con;
		try
		{
			String sql="insert into univ.course values(?,?,?,?)";
			String userName = "db2admin";
                        String password = "aruna";
                        String url = "jdbc:db2://127.0.0.1:50000/univdb";
                        Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
                       // JOptionPane.showMessageDialog(null, "Driver found!!");
                        con = DriverManager.getConnection(url, userName, password);
                        //JOptionPane.showMessageDialog(null, "Conn established!!");
			PreparedStatement pstmt=con.prepareStatement(sql);;
			pstmt.setString(1,s1);
			pstmt.setString(2,s2);
			pstmt.setString(3,s3);
			pstmt.setString(4,s4);
			pstmt.executeUpdate();
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
		
	}
	public static String retFacultyByCourse(String s1,String s2)
	{
		try
		{
			String sql="select * from univ.teaches where courseid=? and batch=?";
			Connection con=DriverManager.getConnection("jdbc:db2://localhost:50000/univdb","db2admin","aruna");
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1,s1);
			pstmt.setString(2,s2);
			ResultSet rs=pstmt.executeQuery();
			rs.first();
			return rs.getString(2);
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
		return null;
	}
		

	public static void handleCourse(String s1,String s2,String s3)
	{
		try
		{
		String sql="insert into univ.teaches values(?,?,?)";
		Connection con=DriverManager.getConnection("jdbc:db2://localhost:50000/univdb","db2admin","aruna");
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,s1);
		pstmt.setString(2,s2);
		pstmt.setString(3,s3);
		pstmt.executeUpdate();
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
		
	}
	
}

