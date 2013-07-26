<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>

<title>AdminConfigure</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<h1>						 
<pre>		WELCOME ADMIN										
</pre>
</h1>
	<form action="adminconfigureservlet">
	<th><b><u>Attendance Defaults</b></u>
	</th>
	<table>
	<tr>
	<td><label>Inentry Timeout </label></td>  <td><input type="text" name="intime"> </td>
	</tr>
	<tr>
	<td>OutEntry Timeout</td>  <td><input type="text" name="outtime"> </td>
	</tr>
	<tr> 
	
	<th><b><u>Internals and Unit Tests Regulation </b></u></th></tr>
	<tr>
	<td>No.of tests to be conducted</td>  <td><input type="text" name="nooftests"></td>
	</tr>
	<tr>
	<td><label>Internals Formula Choice of Option </label></td> <td><select>
					<option >Average of unit tests conducted </option>
					<option>Maximum of n UTs considered </option>
					</select>
			</td>
	</tr>
<tr>

<th><b> <u> Organizational Defaults</b></u>
	</th>
	</tr>
<tr>
	<td><label>No.of working hours </label></td>  <td><input type="text" name="workinghrs"></td>
	</tr>
	<td><label>No.of working days </label></td>  <td><input type="text" name="workingdays"></td>
	</tr>
	<td><label>Passcode </label></td>  <td><input type="text" name="passcode"></td>
	</tr>

</body>
</body>
</html>