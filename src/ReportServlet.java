/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.*;
import javax.servlet.ServletContext;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Nithya
 */

@WebServlet(urlPatterns = {"/ReportServlet"})
public class ReportServlet extends HttpServlet {

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
    protected void ViewReport(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Connection con=null;
        try
        {
                Class.forName("com.ibm.db2.jcc.DB2Driver"); 
        }
        catch (ClassNotFoundException e) 
        {
                out.println("Where is your DB2 JDBC Driver?");
                out.println(e.getMessage());
        }
        try
        {
                con = DriverManager.getConnection("jdbc:db2://localhost:50000/univdb","db2admin","aruna"); 
        }
        catch (SQLException ex) 
        {
                out.println("Connection Failed!");
                out.println(ex.getMessage());
        }
        if(con != null)
        {
            Statement stmt; String sem=null;
            ResultSet rs1,rs2,rs3,rs4,rs5,rs6;
            String rfid=request.getParameter("rfid");
          //  out.println("rfid : "+rfid);
            Calendar cal=Calendar.getInstance();
            int year=cal.get(Calendar.YEAR);
            //out.println("year : "+year);
            try
            {
                stmt=con.createStatement();
                rs1=stmt.executeQuery("select testid from univ.writetest where studentid='"+rfid+"'");
                if(rs1.next())
                {
                    rs2=stmt.executeQuery("select courseid from univ.test where id='"+rs1.getString(1)+"'");
                    if(rs2.next())
                    {
                       rs3=stmt.executeQuery("select semester from univ.course where id='"+rs2.getString(1)+"'");
                       if(rs3.next())
                       {
                        sem=rs3.getString(1);
                       }
                    }
                }
            }
            catch(SQLException e1)
            {
                out.println("SQL EXCEPTION sem: \n"+e1.getMessage());
            }
            String sql="select rfid,fname,lname,department,batch from univ.student where rfid='"+rfid+"'";
            try
            {
                stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
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
                out.println("<h2>Performance Report</h2>");
                while(rs.next())
                {
                    out.println("<table border=\"0\" style=\"margin-left:auto;margin-right:auto;font-size:20px;\">");
                    out.println("<tr><td style=\"font-weight:bold\">RFID Number : </td><td>"+ rs.getString(1)+"</td></tr>");
                    out.println("<tr><td style=\"font-weight:bold\">Student Name : </td><td>"+ rs.getString(2)+" "+ rs.getString(3)+"</td>");
                    out.println("<td>&emsp;</td>");
                    out.println("<td style=\"font-weight:bold\">Semester : </td><td>"+ sem +"</td></tr>" );
                    out.println("<tr><td style=\"font-weight:bold\">Department : </td><td>" + rs.getString(4) + "</td>");
                    out.println("<td>&emsp;</td>");
                    out.println("<td style=\"font-weight:bold\">Batch : </td><td>" + rs.getString(5) + "</td></tr></table>");
                }   
                String month=request.getParameter("month");
                
                PreparedStatement pstmt;
                try
                {
                    pstmt=con.prepareStatement("select id,courseid from univ.test where month(testdate)="+month+" and year(testdate)="+year+"");
                    rs4=pstmt.executeQuery();
                    out.println("<center><table style=\"width:40%; border:1px solid black\" colspan=0 rowspan=0 >"+
"           <tr><th style=\"width:50%; padding:10px\">Course Name</th><th style=\"width:50%; padding:10px\">Marks Obtained</th></tr>");
                    while(rs4.next())
                    {
                        rs5=stmt.executeQuery("select name from univ.course where id='"+rs4.getString(2)+"'");
                        if(rs5.next())
                            out.println("<tr><td>"+rs5.getString(1)+"</td>");
                        rs6=stmt.executeQuery("select marksobtained from univ.writetest where studentid='"+rfid+"' and testid='"+rs4.getString(1)+"'");
                        if(rs6.next())
                            out.println("<td>"+rs6.getString(1)+"</td></tr>");
                    }
                    out.println("</table>");
                    out.println("<a class=\"link-style\" style=\"width:20%;padding:15px;\" shref=\"ViewReport.jsp\">Click here to go Back</a>");
                    out.println("	</div>\n" +
"       <div id=\"footer\">"+
"		<p>Copyright (c) 2013 Universal Student Identification using RFID. All rights reserved. Design by Prolific Coderz.</a></p>"+
"	</div>"+
" \n"+
"	</body>\n" +
"</html>");
                }
                catch(SQLException ed)
                {
                    out.println("SQL EXCEPTION mark: \n"+ed.getMessage());
                }
            }
            catch(SQLException se)
            {
                out.println("SQL EXCEPTION cr: \n"+se.getMessage());
            }
            
        }
    }
    protected void ExportReport(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        Connection con=null;
        response.setContentType("text/html;charset=UTF-8");
        String month=null;
        PrintWriter out = response.getWriter();
        try
        {
                Class.forName("com.ibm.db2.jcc.DB2Driver"); 
        }
        catch (ClassNotFoundException e) 
        {
               out.println("Where is your DB2 JDBC Driver?");
               out.println(e.getMessage());
        }
        try
        {
                con = DriverManager.getConnection("jdbc:db2://localhost:50000/univdb","db2admin","aruna"); 
        }
        catch (SQLException ex) 
        {
               out.println("Connection Failed!");
               out.println(ex.getMessage());
        }
        if(con != null)
        {
         //   out.println("in .. ");
            Statement stmt; String sem=null;
            ResultSet rs1,rs2,rs3,rs4,rs5,rs6;
            String rfid=request.getParameter("rfid");
          //  out.println("rfid:"+rfid);
            Calendar cal=Calendar.getInstance();
            int year=cal.get(Calendar.YEAR);
            try
            {
                stmt=con.createStatement();
                rs1=stmt.executeQuery("select testid from univ.writetest where studentid='"+rfid+"'");
                if(rs1.next())
                {
                    rs2=stmt.executeQuery("select courseid from univ.test where id='"+rs1.getString(1)+"'");
                    if(rs2.next())
                    {
                       rs3=stmt.executeQuery("select semester from univ.course where id='"+rs2.getString(1)+"'");
                       if(rs3.next())
                       {
                        sem=rs3.getString(1);
                       }
                    }
                }
            }
            catch(SQLException e1)
            {
                out.println("SQL EXCEPTION rsem: \n"+e1.getMessage());
            }
            Map parameters= new HashMap();
            parameters.put("rfid",rfid);
            String sql="select rfid,fname,lname,department,batch from univ.student where rfid='"+rfid+"'";
            try
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>View Your Report</title>");            
                out.println("</head>");
                out.println("<body>");
                stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery(sql);
                while(rs.next())
                {
                    parameters.put("name",rs.getString(2)+" "+ rs.getString(3)+"");
                    parameters.put("sem",sem);
                    parameters.put("dept",rs.getString(4));
                    parameters.put("batch",rs.getString(5));
                }   
                month=request.getParameter("month");
                //out.println("month : "+month);
                PreparedStatement pstmt;
                try
                {
                    beans.Marks[] array=new beans.Marks[20];
                    int i=-1;
                    pstmt=con.prepareStatement("select id,courseid from univ.test where month(testdate)="+month+" and year(testdate)="+year+"");
                    rs4=pstmt.executeQuery();
                    while(rs4.next())
                    {
                        beans.Marks markobj=new beans.Marks();
                        rs5=stmt.executeQuery("select name from univ.course where id='"+rs4.getString(2)+"'");
                        if(rs5.next())
                        {
                            markobj.setCourse(rs5.getString(1));
                        }
                        rs6=stmt.executeQuery("select marksobtained from univ.writetest where studentid='"+rfid+"' and testid='"+rs4.getString(1)+"'");
                        if(rs6.next())
                        {
                            markobj.setMark(rs6.getString(1));
                        }
                        array[++i]=markobj;
                    }
                    beans.MarkBeanFactory ob=new beans.MarkBeanFactory();
                    ob.setData(array,i);
                    out.println("<p style=\"font-size:24px; font-weight:bold;\">Report Exported Successfully!<a href=\"ViewReport.html\"> Click here to go back </a></p>");
                    out.println("</body>");
                    out.println("</html>");
                    
                }
                catch(SQLException ed)
                {
                    out.println("SQL EXCEPTION rmark: \n"+ed.getMessage());
                }
            }
            catch(SQLException se)
            {
                out.println("SQL EXCEPTION rcon: \n"+se.getMessage());
            }
            try {
                InputStream input;
                ServletContext servletContext = getServletContext();
             //   out.println(servletContext.getContextPath());
              //  out.println(servletContext.getRealPath(""));
                input = new FileInputStream(new File(servletContext.getRealPath("studentreport1.jrxml")));
                JasperDesign design = JRXmlLoader.load(input);
                JasperReport report = JasperCompileManager.compileReport(design);
                JasperPrint print = JasperFillManager.fillReport(report,parameters, new JRBeanArrayDataSource(beans.MarkBeanFactory.getBeanArray()));
                //OutputStream output=new FileOutputStream(servletContext.getRealPath("")+"\\ExportedReports\\stud_"+rfid+"_"+month+".pdf");
                //JasperExportManager.exportReportToPdfStream(print, output);
                JasperViewer.viewReport(print);
                out.println("Report Exported Successfully !");
            } 
            catch (Exception e) 
            {
                out.println("EXCEPTION rep: \n"+e.getMessage());
            } 
        }    
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String act=request.getParameter("submit");
        if("View Report".equals(act))
            ViewReport(request,response);
        else if("View As PDF".equals(act))
            ExportReport(request,response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
