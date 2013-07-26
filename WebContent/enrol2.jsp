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
<form action="enrol2.jsp" method="post">
<h2>Enrol batch to course</h2>
	<div style="margin-left:auto;margin-right:auto; width:50%;">
	<center>
	<table>
	<tr>
	<td style="width: 40%; padding: 20px;">Batch</td>
	<td> <input type="text" name="bid"/>
        </td>
	</tr>
	<tr>
	<td style="width: 40%; padding: 20px;">Course ID</td>
	<td> <input type="text" pattern="^[A-Z]{2}[0-9]{4}$" name="cid" title="Enter course id in AADDDD format(2 characters followed by 4 digits!)">
				</td>
	</tr>
            <tr><td style="width: 40%; padding:20px;text-align: center;" colspan="2"><table border="0" style="width:100%"><tr><td style="width:50%"><input type="submit" class="button-style" style="width:100%;padding:15px;" name="submit" value="Enrol"/></td><td><a href="Adminindex.jsp" class="link-style" style="padding:15px;width:90%;text-align:center" >Go Back</a></td></tr></table></td></tr>
        </table>
        </center>
        </div>
            </form>

<%
String s1=request.getParameter("bid");
String s2=request.getParameter("cid");
String s3=new String("0");
Connection con;
if(s1!=null)
{
try
{
String sql="select * from univ.student where batch="+s1+"";
String userName = "db2admin";
String password = "aruna";
String url = "jdbc:db2://127.0.0.1:50000/univdb";
Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
////JOptionPane.showMessageDialog(null, "Driver found!!");
con = DriverManager.getConnection(url, userName, password);
////JOptionPane.showMessageDialog(null, "Conn established!!");
PreparedStatement stmt=con.prepareStatement(sql);
ResultSet rs=stmt.executeQuery();
rs.next();
Student.enrolCourse(rs.getString("rfid"),s2,s3);
while(rs.next())
{
	Student.enrolCourse(rs.getString(1),s2,s3);
}
JOptionPane.showMessageDialog(null, "Batch Enrolled to Course!!");
}
catch(Exception E)
{
    System.out.println("haha");
JOptionPane.showMessageDialog(null,"Error:"+E+"Kindly mail helpdesk with this error code for help!");
}
}
%>
</div>
	<div id="footer">
		<p>Copyright (c) 2013 Universal Student Identification using RFID. All rights reserved. Design by Prolific Coderz.</p>
	</div>
	
</div>
</body>
</html>

