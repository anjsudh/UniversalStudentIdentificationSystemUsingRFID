/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author anj
 */
public class TestServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String fid;
    Connection conn = null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
             TODO output your page here. You may use following sample code. */
            /*out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TestServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TestServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }*/
    }

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String markaction=request.getParameter("markaction");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        {
            String userName = "db2admin";
            String password = "aruna";
            String url = "jdbc:db2://127.0.0.1:50000/univdb";
            Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
            JOptionPane.showMessageDialog(null, "Driver found!!");
            conn = DriverManager.getConnection(url, userName, password);
            JOptionPane.showMessageDialog(null, "Conn established!!");
            if(markaction.equals("Login") || markaction.equals("Go Back"))
            {
                fid=request.getParameter("fid");
                    facultypage(out,fid);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String markaction=request.getParameter("markaction");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try 
        {
            String userName = "db2admin";
            String password = "aruna";
            String url = "jdbc:db2://127.0.0.1:50000/univdb";
            Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
            JOptionPane.showMessageDialog(null, "Driver found!!");
            conn = DriverManager.getConnection(url, userName, password);
            JOptionPane.showMessageDialog(null, "Conn established!!");
            if(markaction.equals("Login"))
            {
                fid=request.getParameter("fid");
                    facultypage(out,fid);
            }
            if(markaction.equals("Create"))
            {
                    fid=request.getParameter("facultyid");
                    String sid = request.getParameter("studentid");
                    String testid=request.getParameter("testid");
                    String courseid=request.getParameter("courseid");
                    String maximummarks=request.getParameter("maximummarks");
                    String testdate=request.getParameter("date");
                    JOptionPane.showMessageDialog(null,testdate);
                    String qpapercode=request.getParameter("qpapercode");
                    String sql = ("INSERT INTO univ.test VALUES('"+testid+"','"+courseid+"',"+maximummarks+",'"+qpapercode+"','"+testdate+"')");
                    PreparedStatement psmt = conn.prepareStatement(sql);
                    psmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Test created successfully!!Do come back after evaluating the answer scripts!");
                    facultypage(out,fid);
            }
            if(markaction.equals("Update"))
            {
                String tid=request.getParameter("testid");
                fid=request.getParameter("facultyid");
                Statement s = conn.createStatement();
                s.executeQuery("SELECT univ.student.rfid,univ.student.fname,univ.student.lname FROM univ.test,univ.faculty,univ.teaches,univ.course,univ.enrol,univ.student WHERE (univ.faculty.rfid=univ.teaches.facultyid) and (univ.enrol.courseid=univ.course.id)and (univ.teaches.courseid=univ.course.id) and (univ.student.rfid=univ.enrol.studentid) and (univ.test.courseid=univ.course.id) and univ.faculty.rfid="+fid+" and univ.test.id='"+tid+"'");
                ResultSet rs = s.getResultSet();
                out.println("\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
"   <head>"+
"       <title>SSN College Of Engineering</title>" +
"       <meta name=\"keywords\" content=\"\" />" +
"       <meta name=\"description\" content=\"\" />" +
"       <link href=\"http://fonts.googleapis.com/css?family=Open+Sans:400,300,600\" rel=\"stylesheet\" type=\"text/css\" />"+
"       <link href=\"default.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />"+ 
"		<script type=\"text/javascript\" src=\"./test.js\">\n" +
"		</script>\n" +
"   </head>"+
"   <body>"+
"       <div id=\"wrapper\">"+
"           <div id=\"header\">"+
"		<div id=\"logo\">"+
"			<h1><a href=\"index.html\">SSN Intranet</a></h1>"+
"		</div>"+
"	</div>"+
"	<div id=\"menu\">"+
"           <ul>"+
"                <li class=\"current_page_item\"><a href=\"#\">Home</a></li>"+
"		<li><a href=\"#\">Student</a></li>"+
"		<li><a href=\"#\">Faculty</a></li>"+
"		<li><a href=\"#\">Parents</a></li>"+
"		<li><a href=\"#\">Alumni</a></li>"+
"		<li class=\"last\"><a href=\"#\">Admin</a></li>"+
"		</ul>"+
"	</div>"+
"	<div id=\"one-column\" >"+
"           <form method=\"post\" action=\"TestServlet\">"+
"           <input type=\"hidden\" name=\"testid\" value=\""+tid+"\"/><br> "+
"           <input type=\"hidden\" name=\"facultyid\" value=\""+fid+"\"/><br> "+
"           <center><table style=\"width:40%;\" colspan=0 rowspan=0 >"+
"           <tr><th style=\"width:10%; padding:10px\">Student Name </th><th style=\"width:0%; padding:10px\">Marks Obtained</th></tr>");
                while (rs.next()) 
                {
                    out.println("<tr><td style=\"width:10%;  padding:10px\">"+rs.getString("fname") +" "+rs.getString("lname") +"</td><td style=\"width:10%; padding:10px\"><input name="+rs.getString("rfid") +" type=\"text\" style=\"width:100%; padding:10px\"></input></td></tr>");
                }
                out.println("</table>"+
"             <input type=\"submit\" name=\"markaction\" class=\"button-style\" style=\"padding:15px; width:10%;\" value=\"Save\" style=\" width:10%;padding:10px\"></input>"+
"           </center>"+
"           </form>\n"+
"	</div>\n" +
"       <div id=\"footer\">"+
"		<p>Copyright (c) 2013 Universal Student Identification using RFID. All rights reserved. Design by Prolific Coderz.</a></p>"+
"	</div>"+
" \n"+
"	</body>\n" +
"</html>");
                
                
            }
            if(markaction.equals("Save"))
            {
                    String tid=request.getParameter("testid");
                    fid=request.getParameter("facultyid");
                    Statement s = conn.createStatement();
                    s.executeQuery("SELECT univ.student.rfid,univ.student.fname,univ.student.lname FROM univ.test,univ.faculty,univ.teaches,univ.course,univ.enrol,univ.student WHERE (univ.faculty.rfid=univ.teaches.facultyid) and (univ.enrol.courseid=univ.course.id)and (univ.teaches.courseid=univ.course.id) and (univ.student.rfid=univ.enrol.studentid) and (univ.test.courseid=univ.course.id) and univ.faculty.rfid="+fid+" and univ.test.id='"+tid+"'");
                    ResultSet rs = s.getResultSet();
                    JOptionPane.showMessageDialog(null, "lala");
                    while(rs.next())
                    {
                        String rfid=rs.getString("rfid");JOptionPane.showMessageDialog(null, rfid);
                        String mark=request.getParameter(rfid);
                        try
                        {
                            String sql = ("insert into univ.writetest values("+rfid+",'"+tid+"',"+mark+")");
                            PreparedStatement psmt = conn.prepareStatement(sql);
                            psmt.executeUpdate();
                        }

                        catch(Exception e)
                        {
                            //res.getWriter().write("not found");
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    
                    JOptionPane.showMessageDialog(null, "Marks Updated successfully!!Do come back later to calculate internals!");
                    facultypage(out,fid);
            }
            if(markaction.equals("Calculate"))
            {
                    fid=request.getParameter("facultyid");
                    String cid=request.getParameter("courseid");
                    String start=request.getParameter("startdate");
                    String end=request.getParameter("enddate");
out.println("\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
"   <head>"+
"       <title>SSN College Of Engineering</title>" +
"       <meta name=\"keywords\" content=\"\" />" +
"       <meta name=\"description\" content=\"\" />" +
"       <link href=\"http://fonts.googleapis.com/css?family=Open+Sans:400,300,600\" rel=\"stylesheet\" type=\"text/css\" />"+
"       <link href=\"default.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />"+ 
"		<script type=\"text/javascript\" src=\"./test.js\">\n" +
"		</script>\n" +
"               <style>\n" +
"               button,input{width:100%; padding:10px 15px;}\n" +
"               td,th{text-align:center;}"+
"		</style>\n" +
"   </head>"+
"   <body>"+
"       <div id=\"wrapper\">"+
"           <div id=\"header\">"+
"		<div id=\"logo\">"+
"			<h1><a href=\"index.html\">SSN Intranet</a></h1>"+
"		</div>"+
"	</div>"+
"	<div id=\"menu\">"+
"           <ul>"+
"                <li class=\"current_page_item\"><li><a href=\"home.html\">Home</a></li>"+
"		<li><a href=\"StudentLogin.jsp\">Student</a></li>"+
"		<li class=\"current_page_item\"><a href=\"facultylogin.jsp\">Faculty</a></li>"+
"		<li><a href=\"#\">Parents</a></li>"+
"		<li><a href=\"AdminLogin.jsp\">Admin</a></li>"+
"		<li><a href=\"Help.jsp\">Help</a></li>"+
"               <li class=\"last\"><a href=\"AboutUs.jsp\">About us</a></li>"+
"		</ul>"+
"	</div>"+
"	<div id=\"one-column\" >");
                    out.println("<center><table style=\"width:40%;\" colspan=0 rowspan=0 >"+
"           <tr><th style=\"width:30%; padding:10px\">RFID </th><th style=\"width:40%; padding:10px\">Student Name </th><th style=\" padding:10px\">Marks Obtained</th></tr>");
                    Statement s = conn.createStatement();
                    s.executeQuery("SELECT distinct univ.student.rfid,univ.student.fname,univ.student.lname FROM univ.test,univ.faculty,univ.teaches,univ.course,univ.enrol,univ.student WHERE (univ.faculty.rfid=univ.teaches.facultyid) and (univ.enrol.courseid=univ.course.id)and (univ.teaches.courseid=univ.course.id) and (univ.student.rfid=univ.enrol.studentid) and (univ.test.courseid=univ.course.id) and univ.faculty.rfid="+fid+"");
                    ResultSet rs = s.getResultSet();
                    while(rs.next())
                    {
                        String rfid=rs.getString("rfid");String fname=rs.getString("fname");String lname=rs.getString("lname");JOptionPane.showMessageDialog(null, rfid);
                        try
                        {
                            Statement ss1 = conn.createStatement();
                            ResultSet rss1=ss1.executeQuery("SELECT count(*) from univ.attendance where rfid="+rfid+" and attendancedate between '"+start+"' and '"+end+"'");
                            rss1.next();
                            int total=rss1.getInt(1);
                            JOptionPane.showMessageDialog(null,"Total days:"+total+"");
                            Statement ss2 = conn.createStatement();
                            ResultSet rss2=ss2.executeQuery("SELECT count(*) from univ.attendance where rfid="+rfid+" and presentflag=1 and attendancedate between '"+start+"' and '"+end+"'");
                            rss2.next();
                            int present=rss2.getInt(1);
                            //JOptionPane.showMessageDialog(null,"No. of days present:"+present+"");
                            float attper=(present*100)/total;
                            //JOptionPane.showMessageDialog(null,"Attendance Percent:"+attper+"");
                            float markonfive=attper*5/100;
                            //JOptionPane.showMessageDialog(null,"On 5:"+markonfive+"");
                            //JOptionPane.showMessageDialog(null,"rfid:"+rfid+"");
                            //JOptionPane.showMessageDialog(null,"cid:"+cid+"");
                            Statement ss3 = conn.createStatement();
                            ResultSet rss3 = ss3.executeQuery("select avg(marksobtained) from univ.writetest,univ.test where univ.writetest.testid=univ.test.id and univ.writetest.studentid="+rfid+" and univ.test.courseid='"+cid+"'");
                            rss3.next();
                            float markper=rss3.getFloat(1);
                            //JOptionPane.showMessageDialog(null,"Markper:"+markper+"");
                            float markonfifteen=markper*15/100;
                            //JOptionPane.showMessageDialog(null,"On 15:"+markonfifteen+"");
                            float internal=markonfive+markonfifteen;
                            JOptionPane.showMessageDialog(null,"Internal:"+internal+"");
                            String sql = ("update univ.enrol set internal="+internal+" where studentid="+rfid+"");
                            PreparedStatement psmt = conn.prepareStatement(sql);
                            psmt.executeUpdate();
                            out.println("<tr><td>"+rfid+"</td><td>"+fname+" "+lname+"</td><td>"+internal+"</td></tr>");
                        }

                        catch(Exception e)
                        {
                            //res.getWriter().write("not found");
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Internals Updated successfully!!");
                    out.println("</table></center>"+
"                    <form action=\"TestServlet\" method=\"get\">"+
"                    <input type=\"hidden\" name=\"fid\" value=\""+fid+"\"/>"+
"                       <center><input type=\"submit\" class=\"button-style\" style=\"padding:15px; width:15%\" name=\"markaction\" value=\"Go Back\"/></center>"+
"                       </form>"+
"	</div>\n" +
"       <div id=\"footer\">"+
"		<p>Copyright (c) 2013 Universal Student Identification using RFID. All rights reserved. Design by Prolific Coderz.</a></p>"+
"	</div>"+
" \n"+
"	</body>\n" +
"</html>");
      //              facultypage(out,fid);
            }
        }
        catch(Exception e){out.println(e);}

        finally 
        {            
            out.close();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
    public void facultypage(PrintWriter out,String fid)
    {
                    out.println("\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
"   <head>"+
"       <title>SSN College Of Engineering</title>" +
"       <meta name=\"keywords\" content=\"\" />" +
"       <meta name=\"description\" content=\"\" />" +
"       <link href=\"http://fonts.googleapis.com/css?family=Open+Sans:400,300,600\" rel=\"stylesheet\" type=\"text/css\" />"+
"       <link href=\"default.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" />"+ 
"		<script type=\"text/javascript\" src=\"./test.js\">\n" +
"		</script>\n" +
"               <style>\n" +
"               button,input{width:100%; padding:10px 15px;}\n" +
"		</style>\n" +
"   </head>"+
"   <body>"+
"       <div id=\"wrapper\">"+
"           <div id=\"header\">"+
"		<div id=\"logo\">"+
"			<h1><a href=\"index.html\">SSN Intranet</a></h1>"+
"		</div>"+
"	</div>"+
"	<div id=\"menu\">"+
"           <ul>"+
"                <li class=\"current_page_item\"><li><a href=\"home.html\">Home</a></li>"+
"		<li><a href=\"StudentLogin.jsp\">Student</a></li>"+
"		<li class=\"current_page_item\"><a href=\"facultylogin.jsp\">Faculty</a></li>"+
"		<li><a href=\"#\">Parents</a></li>"+
"		<li><a href=\"AdminLogin.jsp\">Admin</a></li>"+
"		<li><a href=\"Help.jsp\">Help</a></li>"+
"               <li class=\"last\"><a href=\"AboutUs.jsp\">About us</a></li>"+
"		</ul>"+
"	</div>"+
"	<div id=\"one-column\" >"+
"       <div style=\"width:70%; margin-left:auto;margin-right:auto;\""+                            
"		<br><br>\n" +
"		<center><h1>What do you want to do ?</h1></center>\n" +
"           <form method=\"post\" action=\"TestServlet\">\n" +
"           <input type=\"hidden\" name=\"facultyid\" value=\""+fid+"\">" +
"		<table style=\"width:100%;\">\n" +
"		<tr><td style=\"padding:20px 0px;\"><center><button class=\"button-style\" type=\"button\" onclick=\"getdetails()\" style=\"padding:20px;\">Create a test</button><div id=\"content1\"  ></div></center></td></tr>\n" +
"		<tr><td style=\"padding:20px 0px;\"><center><button class=\"button-style\" type=\"button\" onclick=\"getmarkdetails()\" style=\"padding:20px;\">Update Test Scores</button><div id=\"content2\" ></div></center></td></tr>\n" +
"           <tr><td style=\"padding:20px 0px;\"><center><button class=\"button-style\" type=\"button\" onclick=\"getcoursedetails()\" style=\"padding:20px;\">Calculate Internals</button><div id=\"content3\" ></div></center></td></tr>\n" +
"		</table>\n" +
"           </form>\n"  +
"       <br>\n" +
"	</div>\n" +
"	</div>\n" +
"       <div id=\"footer\">"+
"		<p>Copyright (c) 2013 Universal Student Identification using RFID. All rights reserved. Design by Prolific Coderz.</a></p>"+
"	</div>"+
" \n"+
"	</body>\n" +
"</html>");
    }
}
