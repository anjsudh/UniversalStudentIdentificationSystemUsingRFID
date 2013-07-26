<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="university.*"%> 
<html>
<head>
<title>SSN College Of Engineering</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script> 
    <script src="http://malsup.github.com/jquery.form.js"></script> 
 
    <script> 
        // wait for the DOM to be loaded 
        $(document).ready(function() { 
            // bind 'myForm' and provide a simple callback function 
            $('#myForm').ajaxForm(function() { 
                alert("Thank you for your comment!"); 
            }); 
        }); 
    </script> 
	<style>
	input
	{width:100%;padding:10px;}
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
	<form action="AddCourse.jsp" method="post">
	<h2>Insert Course Details</h2>
	<div style="margin-left:auto;margin-right:auto; width:50%;">
	<center><table>
	<tr>
	<td style="width: 40%; padding: 20px;">Course ID</td>
	<td> <input type="text" pattern="^[A-Z][A-Z][0-9]{4}$" name="cid" title="Enter course id in AADDDD format(2 characters followed by 4 digits!)">
				</td>
	</tr>
	<tr>
	<td style="width: 40%; padding: 20px;">Course Name</td>
	<td> <input type="text" name="cname">
				</td>
	</tr>
	<tr>
	<td style="width: 40%; padding: 20px;">Semester</td>
	<td> <input type="text" name="sem">
				</td>
	</tr>
	<tr>
	<td style="width: 40%; padding: 20px;">Credits</td>
	<td> <input type="text" pattern="^(3-6)$" title="Credits should be between 3-6" name="credits">
				</td>
	</tr>
	<tr > <td style="width: 40%; padding:20px;text-align: center;" colspan="2"><center><table border="0" style="width:100%"><tr><td style="width:50%"><input type="submit" class="button-style" style="width:100%;padding:15px;" name="submit" value="Insert Course"></td><td><a href="Adminindex.jsp" class="link-style" style="padding:15px;width:90%;text-align:center" >Go Back</a></td></tr></table></center></td>
	</tr>
	</table>
	</div>
	</form>
	<%
String s1=request.getParameter("cid");
if(s1!=null)
{
String s2=request.getParameter("cname");
String s3=request.getParameter("credits");
 String s4=request.getParameter("sem");
 Course.addCourse(s1,s2,s3,s4);
}
 %>
</div>
	<div id="footer">
		<p>Copyright (c) 2013 Universal Student Identification using RFID. All rights reserved. Design by Prolific Coderz.</a></p>
	</div>
	
</div>
</body>
</html>

