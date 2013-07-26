
<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="university.*"%> 
<%@ page import="javax.swing.*"%> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>SSN College Of Engineering</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css" />
<link href="default.css" rel="stylesheet" type="text/css" media="all" />
<style>
	input
	{width:100%;padding:10px;}
	</style>
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
			<h2>Create Classroom Session</h2>
			<form action="StartSession.jsp">
			<div style="margin-left:auto;margin-right:auto; width:50%;">
			<center>
			<table>
				<tr>
				<td style="width:40%; padding: 20px;"><label for="cid"> Course ID </label></td>
					<td> <input type="text" pattern="^[A-Z]{2}[0-9]{4}$" name="cid" title="Enter course id in AADDDD format(2 characters followed by 4 digits!)"></td>
				</tr>
				<tr>
					<td style="width:40%; padding: 20px;"><label for="cname">Course Name</label></td>
					<td class="textfield"><input type="text" id="cname" class="text" name="cname"/></td>
				</tr>
				<tr>
					<td style="width:40%; padding: 20px;"><label for="date"> Date</label></td>
					<td class="textfield"><input type="text" id="date" pattern="^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}$" title="Enter in MM/DD/YYYY format!" class="text" name="sdate"/></td>
				</tr>
				<tr>
					<td style="width:40%; padding: 20px;"><label for="sno"> Session No.</label></td>
					<td class="textfield"><input type="text" id="sno" pattern="^[0-9]$" class="text" title="Session should be between 0-9" name="period"/></td>
		
		
				</tr>
				<tr>
					<td style="width: 40%; padding: 20px;"><label for="sno">Batch.</label></td>
					<td class="textfield"><input type="text" id="batch" class="text" name="batch"/></td>
				</tr>
				<tr >
                                    <td style="width: 40%; padding:20px;text-align: center;" colspan="2"><table border="0" style="width:100%"><tr><td style="width:50%"><input type="submit" class="button-style" style="width:100%;padding:15px;" value="Start Session!"/></td><td><a href="Facultyindex.jsp?fid=<%=request.getParameter("fid")%>" class="link-style" style="padding:15px;width:90%;text-align:center" >Go Back</a></td></tr></table></td>
				</tr>
			</table>
		</div>
	</div>
	<div id="footer">
		<p>Copyright (c) 2013 Universal Student Identification using RFID. All rights reserved. Design by Prolific Coderz.</a></p>
	</div>
<%
String s1=request.getParameter("fid");
String s2=request.getParameter("cid");
//JOptionPane.showMessageDialog(null,s2);
if(s2!=null)
       {
String s3=request.getParameter("cname");
String s4=request.getParameter("sdate");
String s6=request.getParameter("period");
String s5=request.getParameter("batch");
try
               {
    Connection con;
String sql="select * from univ.enrol where courseid=?";
String userName = "db2admin";
String password = "aruna";
String url = "jdbc:db2://127.0.0.1:50000/univdb";
Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
////JOptionPane.showMessageDialog(null, "Driver found!!");
con = DriverManager.getConnection(url, userName, password);
////JOptionPane.showMessageDialog(null, "Conn established!!");
PreparedStatement stmt=con.prepareStatement(sql);
stmt.setString(1,s2);
ResultSet rs=stmt.executeQuery();
while(rs.next())
{
String sql2="insert into univ.attendance values(?,?,?,?,?,?,?,?)";
PreparedStatement stmt1=con.prepareStatement(sql2);
stmt1.setString(1,"101");
stmt1.setString(2,rs.getString("studentid"));
stmt1.setString(3,s4);
stmt1.setString(4,s2);
stmt1.setString(5,s6);
stmt1.setString(6,"0");
stmt1.setString(7,"0");
stmt1.setString(8,"0");
stmt1.executeUpdate();
}
 response.sendRedirect("StartInentryOutentry.jsp?cid="+s2+"&per="+s6+"&adate="+s4+"&batch="+s5+"");
}
catch(Exception E)
               {
                    JOptionPane.showMessageDialog(null,E);
                                       }
}

%>
</div>
</body>
</html>