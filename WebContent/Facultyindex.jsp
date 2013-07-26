<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="university.*"%> 
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
		<h2>Faculty Home</h2>
		<div class="content" >
			<div id="column" >
				<center>
					<table style="width:30%; padding:10px;">
                                                <tr><td style="width:100%; padding: 20px;"><a href='StartSession.jsp?fid=<%= request.getParameter("fid")%>' class="link-style" style="padding:15px;width:100%;text-align:center" >Start a classroom session</a></td></tr>
						<tr><td style="width:100%; padding: 20px;"><a href='TestServlet?markaction=Login&fid=<%= request.getParameter("fid")%>' class="link-style" style="padding:15px;width:100%;text-align:center" >Create exam/Update Scores/Calculate Internals</a></td></tr>
                    </table>
            </center>
			</div>
			
		</div>
	</div>
	<div id="footer">
		<p>Copyright (c) 2013 Universal Student Identification using RFID. All rights reserved. Design by Prolific Coderz.</p>
	</div>
	
</div>
</body>
</html>