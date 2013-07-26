package university;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class Parent {

	String RFID;
	String FirstName,LastName,EMail,Contact,UserName,Pwd;
	public static void insertParent(String s1,String s2,String s3,String s4,String s5,String s6,String s7)
	{
            Connection con;
		try
		{
			String sql="insert into univ.parent values(?,?,?,?,?,?,?)";
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
		stmt.setString(4,s4);
		stmt.setString(5,s5);
		stmt.setString(6,s6);
		stmt.setString(7,s7);
		
		stmt.executeUpdate();
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
}
