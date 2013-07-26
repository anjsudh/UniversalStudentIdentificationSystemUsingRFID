<%@page import="javax.swing.JOptionPane"%>

<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<%@page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1" %>
	<%@page import="java.util.*" language="java" contentType="text/html; charset=ISO-8859-1" %>
	<%@page import="javax.mail.*" language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@page import="javax.mail.internet.MimeMultipart"%>
<%@page import="java.util.Date.*"%>
<%@page import="javax.mail.internet.MimeBodyPart"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>SSN College Of Engineering</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
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
	<h2>E-Mail Report</h2>
You are about to mail the email reports to all students and parent ids ..To continue click send button
<form action="EMailReport.jsp">
    <table border="0" style="width:40%"><tr><td style="width:50%"><input type="submit" class="button-style" style="width:100%;padding:15px;" name="but1" value="Send Emails"></td><td><a href="Adminindex.jsp" class="link-style" style="padding:15px;width:90%;text-align:center" >Go Back</a></td></tr></table>

</form>

<%
    String action=request.getParameter("but1");
if(action!=null)
try
{
			Class.forName("com.ibm.db2.jcc.DB2Driver");
 			 System.out.println("driver loaded sucesssssssssssssssssss"); 
			String sql="select * from univ.parent";
			Connection con=DriverManager.getConnection("jdbc:db2://localhost:50000/univdb","db2admin","aruna");
			PreparedStatement pstmt=con.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
		{
		
			 Properties properties = new Properties();
		String host = "smtp.gmail.com";
        String port = "587";
        final String userName = "labs.ssn@gmail.com";
        final String password = "timcookjobs";
        String subject = "University Result Reports";
        String message = "The monthly consolidated performance report of your ward is now available at our site..Plz do check out";
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.userName", userName);
        properties.put("mail.password", password);
 		String toAddress=rs.getString(3);
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
        Session session1 = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session1);
 
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
      //  msg.setSentDate(new Date());
 
        // creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(message, "text/html");
 
        // creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
 
        // adds attachments
        /*if (attachFiles != null && attachFiles.length > 0) {
            for (String filePath : attachFiles) {
                MimeBodyPart attachPart = new MimeBodyPart();
 
                try {
                    attachPart.attachFile(filePath);
                } catch (IOException Ex) {
                    ex.printStackTrace();
                }
 
                multipart.addBodyPart(attachPart);
            }
        }*/
 
        // sets the multi-part as e-mail's content
        msg.setContent(multipart);
 
        // sends the e-mail
        Transport.send(msg);
        
    }
JOptionPane.showMessageDialog(null,"EMAILS SENT");
}

catch(Exception E)
{
    JOptionPane.showMessageDialog(null,E);
System.out.println(E);
}

%>
</div>
	<div id="footer">
		<p>Copyright (c) 2013 Universal Student Identification using RFID. All rights reserved. Design by Prolific Coderz.</a></p>
	</div>
	
</div>
</body>
</html>