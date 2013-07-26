<html>
<head>
<title>SSN College Of Engineering</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css" />
<style>
        .tdtext
        { text-align:center;}
	input
	{width:90%;padding:10px;}
        select
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
			<li><a href="facultylogin.jsp">Faculty</a></li>
			<li><a href="ParentLogin.jsp">Parents</a></li>
			<li><a href="AdminLogin.jsp">Admin</a></li>
			<li><a href="Help.jsp">Help</a></li>
			<li class="last"><a href="AboutUs.jsp">About us</a></li>
		</ul>
	</div>
	<div id="one-column" >
        <h2>View Performance Report</h2>
        <form action="ReportServlet">
            <div class="content" >
			<div id="column" >
				<center>
					<table style="width:35%; padding:10px;">
                                            <tr><td style="padding: 20px">Enter RFID Number</td><td class="tdtext" style=" padding: 10px"><input type="text" id="rfid" name="rfid" value="<%=request.getParameter("sid")%>"/></td></tr>
                                            <tr><td style="padding: 20px">Choose the month</td>
                                                    <td class="tdtext"><select name="month" id="month">
                                                            <option value="1">January</option>
                                                            <option value="2">February</option>
                                                            <option value="3">March</option>
                                                            <option value="4">April</option>
                                                            <option value="5">May</option>
                                                            <option value="6">June</option>
                                                            <option value="7">July</option>
                                                            <option value="8">August</option>
                                                            <option value="9">September</option>
                                                            <option value="10">October</option>
                                                            <option value="11">November</option>
                                                            <option value="12">December</option>
                                                        </select></td>
                                                </tr>
                <tr><td style="width: 50%; padding: 20px"><input type="submit" class="button-style" style="width: 100%; padding: 15px" name="submit" value="View Report"/></td>
                    <td style="width: 50%; padding: 20px"><input type="submit" class="button-style" style="width: 100%; padding: 15px" name="submit" value="View As PDF"/></td>
                </tr>
            </table>
        </form>
</div>
            </div>
        </div>
	<div id="footer">
		<p>Copyright (c) 2013 Universal Student Identification using RFID. All rights reserved. Design by Prolific Coderz.</a></p>
	</div>
	
</div>
</body>
</html>