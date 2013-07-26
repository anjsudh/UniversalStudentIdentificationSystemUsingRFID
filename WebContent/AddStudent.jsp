<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
	<form action="addstudentservlet">
<h2>Insert Student Details</h2>
	<div style="margin-left:auto;margin-right:auto; width:50%;">
	<center>
	<table>
	<tr>
	<td style="width:40%; padding: 20px;">Rfid</td>
	<td> <input type="text" name="rfid">
				</td>
	</tr>
	<tr>
	<td style="width:40%; padding: 20px;">First Name</td>
	<td> <input type="text" name="fname">
				</td>
	</tr>
	<tr>
	<td style="width:40%; padding: 20px;">Last Name</td>
	<td> <input type="text" name="lname">
				</td>
	</tr>
	<tr>
	<td style="width:40%; padding: 20px;">Date of Birth</td>
	<td> <input type="text" pattern="^[0-9]{1,2}/[0-9]{1,2}/[0-9]{4}$" title="Enter in MM/DD/YYYY format!" name="dob">
	</td>
	</tr>
	<tr>
	<td style="width:40%; padding: 20px;">Department</td>
	<td> <input type="text" name="dept">
				</td>
	</tr>
	<tr><td style="width:40%; padding: 20px;">Batch</td>
	<td> <input type="text" name="batch">
				</td>
	</tr>
	<tr>
	<td style="width:40%; padding: 20px;">Address</td>
	<td> <input type="textarea" name="address"></td>
	</tr>
	<tr><td style="width:40%; padding: 20px;">Contact1</td>
	<td> <input type="text" name="contact1">
				</td>
	</tr>
	<tr>
	<td style="width:40%; padding: 20px;">Contact2</td>
	<td> <input type="text" name="contact2">
				</td>
	</tr>
	<tr>
	<td style="width:40%; padding: 20px;">E-Mail</td>
	<td> <input type="text" name="email">
				</td>
	</tr>
	<tr><td style="width:40%; padding: 20px;">Username</td>
	<td> <input type="text" name="username">
				</td>
	</tr>
	<tr><td style="width:40%; padding: 20px;">Password</td>
	<td> <input type="password" name="pwd">
				</td>
	</tr>
	<tr>
	<th colspan="2" style="padding: 20px;">Parent Details</th>
	</tr>
	<td style="width:40%; padding: 20px;">First Name</td>
	<td> <input type="text" name="pfname">
				</td>
	</tr>
	<tr>
	<td style="width:40%; padding: 20px;">Last Name</td>
	<td> <input type="text" name="plname">
				</td>
	</tr>
	<tr><td style="width:40%; padding: 20px;">Username</td>
	<td> <input type="text" name="pusername">
				</td>
	</tr>
	<tr><td style="width:40%; padding: 20px;">Password</td>
	<td> <input type="password" name="ppwd">
				</td>
	</tr>
	<tr><td style="width:40%; padding: 20px;">Contact</td>
	<td> <input type="text" name="pcontact">
				</td>
	</tr>
	
	
	<tr><td style="width: 40%; padding:20px;text-align: center;" colspan="2"><center><table border="0" style="width:100%"><tr><td style="width:50%"><input type="submit" name="submit" style="width:100%;padding:15px;" class="button-style" value="Insert Student"></td><td><a href="Adminindex.jsp" class="link-style" style="padding:15px;width:90%;text-align:center" >Go Back</a></td></tr></table></center>
	</table>
	
	</form>
</div>
</div>
	<div id="footer">
		<p>Copyright (c) 2013 Universal Student Identification using RFID. All rights reserved. Design by Prolific Coderz.</a></p>
	</div>
	
</div>
</body>
</html>