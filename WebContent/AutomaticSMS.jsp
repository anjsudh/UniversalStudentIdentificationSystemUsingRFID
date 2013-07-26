<%@page import="javax.swing.JOptionPane"%>
<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="university.*"%> 
<%@ page import="mail.*"%> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>SSN College Of Engineering</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<style>
	input,select
	{width:100%;padding:10px;}
	textarea
	{width:100%;padding:2px;}
	</style>
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
<div id="wrapper">
	<div id="header">
		<div id="logo">
			<h1><a href="home.html">SSN Intranet</a></h1>
		</div>
	</div>
	<!-- end #header -->
	<div id="menu">
		<ul>
			<li><a href="home.html">Home</a></li>
			<li><a href="StudentLogin.jsp">Student</a></li>
			<li><a href="facultylogin.jsp">Faculty</a></li>
			<li><a href="ParentLogin.jsp">Parents</a></li>
			<li class="current_page_item"><a href="AdminLogin.jsp">Admin</a></li>
			<li><a href="Help.jsp">Help</a></li>
			<li class="last"><a href="AboutUs.jsp">About us</a></li>
		</ul>
	</div>
	<div id="one-column" >

	<form action="AutomaticSMS.jsp">
	<h2>Send Automatic SMS</h2>
	<div style="margin-left:auto;margin-right:auto; width:50%;">
	<center>
	<table>
	<tr>
	<td style="width:40%; padding: 20px;">Enter message to send</td>
	<td><textarea	rows="3" name="message"></textarea></td>
	</tr>
	<tr>
	<td style="width:40%; padding: 20px;">Enter message recipients</td>
	<td><select id="rec" name="recipients" size="0"><option value="Student">student</option>
				<option value="Faculty">faculty</option>
		</select>
            <div id="divrecipt" style="width:100%"></div>
	</td>
	</tr>
		
	<tr><td style="width: 40%; padding:20px;text-align: center;" colspan="2"><center><table border="0" style="width:100%"><tr><td style="width:50%"><input type="submit" style="width:100%;padding:15px;" class="button-style"  name="send" value="Send SMS"></td><td><a href="Adminindex.jsp" class="link-style" style="padding:15px;width:90%;text-align:center" >Go Back</a></td></tr></table></td></tr>
	</table>
	</form>
  <% 
     
  String action=request.getParameter("send");
if(action!=null)
{  
String msg=request.getParameter("message");
String rc=request.getParameter("recipients");
//JOptionPane.showMessageDialog(null, msg);
//JOptionPane.showMessageDialog(null,rc);
                        

 /*                       
if(rc.equals("Add Recipient.."))
{
    //JOptionPane.showMessageDialog(null, "inside other");
                        
String no=request.getParameter("other");
SMTPSend.msgsend("+91"+no+"@sms.ipipi.com",msg);
}
else
*/

		try
	{
	String sql="select * from faculty";
	Class.forName("com.ibm.db2.jcc.DB2Driver");
  System.out.println("driver loaded sucesssssssssssssssssss"); 
  
  
     //                   //JOptionPane.showMessageDialog(null, "Driver found!!");
                        
			String userName = "db2admin";
                        String password = "aruna";
                        String url = "jdbc:db2://127.0.0.1:50000/univdb";
                        Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
                        Connection con = DriverManager.getConnection(url, userName, password);
       //                 //JOptionPane.showMessageDialog(null, "Conn established!!");
	
	if(rc.equals("Student"))
		sql="select contact1 from univ.student";
	else if(rc.equals("Faculty"))
		sql="select contact1 from univ.faculty";
	
	PreparedStatement pstmt=con.prepareStatement(sql);
	ResultSet rs=pstmt.executeQuery();
	while(rs.next())
		SMTPSend.msgsend("+91"+rs.getString(1)+"@sms.ipipi.com",msg);
	}
catch(Exception E)
{
    JOptionPane.showMessageDialog(null,"Error:"+E+"Kindly mail helpdesk with this error code for help!");
out.print(E.toString());
}
}
%>
</body>
</html>