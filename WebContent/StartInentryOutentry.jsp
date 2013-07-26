<%@page import="javax.swing.JOptionPane"%>
<!DOCTYPE HTML>
<%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 
<%@ page import="university.*"%> 
<html xmlns="http://www.w3.org/1999/xhtml">
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
<script>
    function inentryval()
    {
        document.getElementById("inentrytd").innerHTML="Please ensure that you start the hyperterminal with default settings and capture input values to empty file CAPTURE1.txt";
    }
    function outentryval()
    {
        document.getElementById("outentrytd").innerHTML="Please ensure that you start the hyperterminal with default settings and capture input values to empty file CAPTURE2.txt";
    }
</script>
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
			<li><a href="#">Parents</a></li>
			<li><a href="AdminLogin.jsp">Admin</a></li>
			<li><a href="Help.jsp">Help</a></li>
			<li class="last"><a href="AboutUs.jsp">About us</a></li>
		</ul>
	</div>
	<div id="one-column" >
	<h2>InEntry Session</h2>
			<div style="margin-left:auto;margin-right:auto; width:50%;">
				
				<table>
					<tr>
					<form action="StartInentryOutentry.jsp">
						<td style="width:30%">	
                                                    <input type="hidden" name="cid" value="<%=request.getParameter("cid")%>"/>
                                            <input type="hidden" name="adate" value="<%=request.getParameter("adate")%>"/>
                                            <input type="hidden" name="per" value="<%=request.getParameter("per")%>"/>
                                            <input type="hidden" name="batch" value="<%=request.getParameter("batch")%>"/>
							<input type="button" class="button-style" onclick="inentryval()"style="width:100%;padding:15px;" id="startin" name="but1" value="Start InEntry" />
							<br/>
							<br/>
							<br/>
							<input id="stopin" class="button-style" style="width:100%;padding:15px;" type="submit" name="but1" value="Stop InEntry" />
						</td>
						<td id="inentrytd">
						</td>
					</tr>
				</table>
			</div>
			<hr>
			<h2>OutEntry Session</h2>
			<div style="margin-left:auto;margin-right:auto; width:50%;">
				
					<table>
						<tr>
							<td style="width:30%">	
								<input type="button" class="button-style" onclick="outentryval()" style="width:100%;padding:15px;" id="startout" value="Start OutEntry" name="but1"/>
								<br>
								<br>
								<br>
								<input id="stopout" class="button-style" style="width:100%;padding:15px;" type="submit" name="but1" value="Stop OutEntry" />
							</td>
							<td id="outentrytd">
                                                            
							</td>
						</tr>
				</table>
				</form>
			</div>
                        <table border="0" style="width:100%;text-align: center;"><tr><td><a href="Facultyindex.jsp?fid=<%=request.getParameter("fid")%>" class="link-style" style="padding:15px;width:20%;text-align:center" >Go Back</a></td></tr></table>
		</div>
<%
String s1=request.getParameter("but1");
String s2=request.getParameter("cid");
String s3=request.getParameter("adate");
String marked1=" ";
String s4=request.getParameter("per");
//JOptionPane.showMessageDialog(null,s4);
if(s1!=null)
{
if(s1.equals("Stop InEntry")==true)
{
  //  JOptionPane.showMessageDialog(null,"Hello2");
FileInputStream fstream = new FileInputStream("C:/downloads/hypertrm/hypertrm/CAPTURE1.txt");
  // Get the object of DataInputStream
  DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
  String strLine;
  //Read File Line By Line
  while ((strLine = br.readLine())!= null)   {
  // Print the content on the console
            if(strLine != null)
            {
                strLine=strLine.substring(1);
                marked1+=strLine+"\n";
    //  JOptionPane.showMessageDialog(null,strLine);
      Connection con;
    String userName = "db2admin";
String password = "aruna";
String url = "jdbc:db2://127.0.0.1:50000/univdb";
Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
////JOptionPane.showMessageDialog(null, "Driver found!!");
con = DriverManager.getConnection(url, userName, password);
////JOptionPane.showMessageDialog(null, "Conn established!!");
//strLine="1";       
//JOptionPane.showMessageDialog(null,strLine+" "+s2+" "+s3+" "+s4);
		  String sql="update univ.attendance set inentry=1 where RFID='"+strLine+"' and courseid='"+s2+"' and attendancedate='"+s3+"' and session="+s4+"";
              PreparedStatement pstmt=con.prepareStatement(sql);
  //JOptionPane.showMessageDialog(null, "Updated");   
                  pstmt.executeUpdate(); 
  System.out.println (strLine);
}
  }
  
  JOptionPane.showMessageDialog(null, "INENTRY SESSION ATTENDANCE MARKED"); 
}

else if(s1.equals("Stop OutEntry")==true)
{
     //JOptionPane.showMessageDialog(null, "Inside outentry");
FileInputStream fstream = new FileInputStream("C:/downloads/hypertrm/hypertrm/CAPTURE2.txt");
  // Get the object of DataInputStream
  DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
  String strLine;
  //Read File Line By Line
  while ((strLine = br.readLine()) != null)   {
  // Print the content on the console
      //JOptionPane.showMessageDialog(null, "strLine");
      Connection con;
    String userName = "db2admin";
String password = "aruna";
String url = "jdbc:db2://127.0.0.1:50000/univdb";
Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
////JOptionPane.showMessageDialog(null, "Driver found!!");
con = DriverManager.getConnection(url, userName, password);
////JOptionPane.showMessageDialog(null, "Conn established!!");
strLine=strLine.substring(1);
 //JOptionPane.showMessageDialog(null,strLine+" "+s2+" "+s3+" "+s4);

		   String sql="update univ.attendance set presentflag=1,outentry=1 where inentry=1 and RFID='"+strLine+"' and courseid='"+s2+"' and attendancedate='"+s3+"' and session="+s4+"";
              PreparedStatement pstmt=con.prepareStatement(sql);
  //JOptionPane.showMessageDialog(null, "Updated");   
                 
                  pstmt.executeUpdate(); 
  System.out.println (strLine);

}
  JOptionPane.showMessageDialog(null, "OUTENTRY SESSION ATTENDANCE MARKED!"); 
}
}
%>
	<div id="footer">
		<p>Copyright (c) 2013 Universal Student Identification using RFID. All rights reserved. Design by Prolific Coderz.</a></p>
	</div>
	
</div>
</body>
</html>
