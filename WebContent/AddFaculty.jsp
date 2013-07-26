<!DOCTYPE HTML><%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="university.*"%> 
<%@ page import="javax.swing.*"%> 
<html>
<head>
<title>SSN College Of Engineering</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
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
	<form action="AddFaculty.jsp" method="post">
	<h2>Insert Faculty Details</h2>
	<div style="margin-left:auto;margin-right:auto; width:50%;">
	<center>
	<table>
	<tr>
	<td style="width:40%; padding: 20px;">Rfid</td>
	<td> <input type="text" name="rfid">
	</td>
	</tr>
	<tr>
	<td style="width: 40%; padding: 20px;">First Name</td>
	<td> <input type="text" name="fname">
	</td>
	</tr>
	<tr>
	<td style="width: 40%; padding: 20px;">Last Name</td>
	<td> <input type="text" name="lname">
				</td>
	</tr>
	<tr>
	<td style="width: 40%; padding: 20px;">Contact 1</td>
	<td> <input type="text" name="contact1">
				</td>
	</tr>
	<tr>
	<td style="width: 40%; padding: 20px;">Contact 2</td>
			<td><input type="text" name="contact2"></td>
		</tr>
         <tr><td style="width: 40%; padding: 20px;">E-Mail</td>
	<td height="35"> <input type="text"  name="email">
			</td>
	</tr>
	<tr><td style="width: 40%; padding: 20px;">Address</td>
	<td height="35"> <input type="text"  name="address">
			</td>
	</tr>
	<tr>
	<td style="width: 40%; padding: 20px;">Qualification</td>
	<td> <input type="text" name="qualification"></td>
	</tr>
	<tr><td style="width: 40%; padding: 20px;">Department</td>
	<td> <input type="text" name="department">
				</td>
	</tr>
	<tr>
	<td style="width: 40%; padding: 20px;">Username</td>
	<td> <input type="text" name="username">
				</td>
	</tr>
	<tr>
	<td style="width: 40%; padding: 20px;">Password</td>
	<td> <input type="password" name="password">
				</td>
	</tr>
	<td style="width: 40%; padding: 20px;">Salary</td>
	<td> <input type="text" name="salary">
				</td>
	</tr>
	
	<tr><td style="width: 40%; padding: 20px;">Date of Birth</td>
	<td> <input type="text" pattern="^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}$" title="Enter in MM/DD/YYYY format!" name="dob">
				</td>
	</tr>
	<tr>
	<td style="width: 40%; padding: 20px;">Date of Joining</td>
	<td> <input type="text" pattern="^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}$" title="Enter in MM/DD/YYYY format!" name="doj">
				</td>
	</tr>
	
	<tr > <td style="width: 40%; padding:20px;text-align: center;" colspan="2"><table border="0" style="width:100%"><tr><td style="width:50%"><input type="submit" class="button-style" style="width:100%;padding:15px;" name="submit" value="Insert Faculty"></td><td><a href="Adminindex.jsp" class="link-style" style="padding:15px;width:90%;text-align:center" >Go Back</a></td></tr></table></td></tr>
	</table>
	
	</form>
<%
String s1=request.getParameter("rfid");
if(s1!=null)
{
String s2=request.getParameter("fname");
String s3=request.getParameter("lname");
 String s4=request.getParameter("contact1");
 String s5=request.getParameter("contact2");
 String s6=request.getParameter("email");
 String s7=request.getParameter("address");
 String s8=request.getParameter("qualification");
 String s9=request.getParameter("department");
String s10=request.getParameter("username");
String s11=request.getParameter("password");
String ss1=request.getParameter("salary");
String s12=request.getParameter("dob");
String s13=request.getParameter("doj");
Faculty f=new Faculty(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,ss1,s12,s13);
f.insertFaculty();
JOptionPane.showMessageDialog(null,"Inserted!!");
}
 %>
</div>
</div>
	<div id="footer">
		<p>Copyright (c) 2013 Universal Student Identification using RFID. All rights reserved. Design by Prolific Coderz.</a></p>
	</div>
	
</div>
</body>
</html>
