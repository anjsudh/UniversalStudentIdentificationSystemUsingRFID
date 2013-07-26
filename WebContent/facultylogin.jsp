<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="university.*"%>
<%@ page import="javax.swing.*"%> 
<head>
<title>SSN College Of Engineering</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css" />
<style>
	input
	{width:100%;padding:10px;}
	</style>
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
			<li class="current_page_item"><a href="facultylogin.jsp">Faculty</a></li>
			<li><a href="ParentLogin.jsp">Parents</a></li>
			<li><a href="AdminLogin.jsp">Admin</a></li>
			<li><a href="Help.jsp">Help</a></li>
			<li class="last"><a href="AboutUs.jsp">About us</a></li>
		</ul>
	</div>
	<div id="one-column" >
		<h2>Faculty Login</h2>
		<div class="content" >
			<div id="column" >
				<center>
                <p> Enter your login details here:</p>

	<form action="facultylogin.jsp">
	<table style="width:30%; padding:10px;">
                        <tr>
                            <td style="width: 40%; padding: 20px">Username </td>
                            <td style=" padding: 10px"><input type="text" name="user" style="width: 100%"/></td>
                        </tr>
                        <tr>
                            <td style="width: 40%; padding: 20px;">Password</td>
                            <td style="padding: 10px"><input type="password" name="pwd" style="width: 100%"/></td>
                        </tr>
<tr>
<td style="width: 40%; padding:0px;text-align: center;" colspan="2">

<input type="submit" name="Login" value="Login" class="button-style" style="width:40%; padding:10px 15px;"/></td>
	</tr>
                    </table>
                </form>
            </center>
			</div>
			
		</div>
	</div>
	<div id="footer">
		<p>Copyright (c) 2013 Universal Student Identification using RFID. All rights reserved. Design by Prolific Coderz.</p>
	</div>
	
</div>
<%
String user=request.getParameter("user");
String pass=request.getParameter("pwd");
if(user!=null)
{
    if(Faculty.authenticate(user,pass)==true)
    {
        String fid=Faculty.retFacultyID(user);
        response.sendRedirect("Facultyindex.jsp?fid="+fid+"");
    }
    else
    {
        JOptionPane.showMessageDialog(null,"Invalid Login Credentials!!Try Again");
        response.sendRedirect("facultylogin.jsp");
    }
}
%>
</body>
</html>