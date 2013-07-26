import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class db2connection_test 
{
    
     public static void main(String  rgs[]) throws Exception 
     { 
        //get the connetion
        Connection  connection = getConnection (); 
		if (connection != null)
			System.out.println("You made it, take control of your database now!");
		else 
			System.out.println("Failed to make connection!");
	}
      
     private static Connection  getConnection()
     { 
		Connection  connection=null;
		try
		{
			Class. forName ( "com.ibm.db2.jcc.DB2Driver"  ); 
		}
		catch (ClassNotFoundException e) 
		{
			System.out.println("Where is your DB2 JDBC Driver?");
			e.printStackTrace();
			return null;
		}
		try
		{
			connection = DriverManager.getConnection("jdbc:db2://localhost:50000/univdb","db2admin","aruna"); 
                        
                         try
            {
               // System.out.println("in ..");
                
                //String getsem="select semester from univ.course where id in (select courseid from univ.test where testdate like '%2013' and id in (select testid from univ.writetest where studentid='1' ))";
                Statement stmt=connection.createStatement();
                //System.out.println("in ..1");
                ResultSet semrs,rs1,rs2,rs3,rs4,rs5;
                String sem;
                semrs = stmt.executeQuery("select testid from univ.writetest where studentid='1'");
                if(semrs.next())
                {
                  //  System.out.println("in ..2 testid:"+semrs.getString(1));
                    rs1=stmt.executeQuery("select courseid from univ.test where id='"+semrs.getString(1)+"'");
                    if(rs1.next())
                    {
                       // System.out.println("in ..3 course :" +rs1.getString(1));
                       rs2=stmt.executeQuery("select semester from univ.course where id='"+rs1.getString(1)+"'");
                       if(rs2.next())
                       {
                        sem=rs2.getString(1);
                        System.out.println("Sem : "+ sem);               
                       }
                    }
                }
                System.out.println("in ..4");
                PreparedStatement pstmt;
                pstmt=connection.prepareStatement("select id,courseid from univ.test where month(testdate)=2 and year(testdate)=2013");
                rs3=pstmt.executeQuery();
                System.out.println("in ..5");
                while(rs3.next())
                {
                    System.out.println("testid :"+rs3.getString(1));
                    rs5=stmt.executeQuery("select name from univ.course where id='"+rs3.getString(2)+"'");
                    if(rs5.next())
                        System.out.println("course :"+rs5.getString(1));
                    rs4=stmt.executeQuery("select marksobtained from univ.writetest where studentid='1' and testid='"+rs3.getString(1)+"'");
                    if(rs4.next())
                        System.out.println("mark :"+rs4.getString(1));
                }
                
               
                
            }
            catch(SQLException e1)
            {
                System.out.println("SQL EXCEPTION sem: \n"+e1.getMessage());
            }
		}
		catch (SQLException ex) 
		{
			System.out.println("Connection Failed! Check output console");
			ex.printStackTrace();
			return null;
		}
        return connection;
     } 
}