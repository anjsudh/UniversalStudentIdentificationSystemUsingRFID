package university;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;

/**
 * Servlet implementation class addstudentservlet
 */
public class addstudentservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addstudentservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processrequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processrequest(request,response);
		
	}
	public void processrequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
			String s1=request.getParameter("rfid");
			String s2=request.getParameter("fname");
			String s3=request.getParameter("lname");
			String s4=request.getParameter("dob");
			String s5=request.getParameter("dept");
			String s6=request.getParameter("batch");
			String s7=request.getParameter("address");
			String s8=request.getParameter("contact1");
			String s9=request.getParameter("contact2");
			String s10=request.getParameter("email");
			String s11=request.getParameter("username");
			String s12=request.getParameter("pwd");
			Student s=new Student(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12);
			String s13=request.getParameter("pfname");
			String s14=request.getParameter("plname");
			String s15=request.getParameter("pemail");
			String s16=request.getParameter("pusername");
			String s17=request.getParameter("ppwd");
			String s18=request.getParameter("pcontact");
			
			s.insertStudent();
			Parent.insertParent(s13, s14, s15, s16, s17, s18, s1);
			JOptionPane.showMessageDialog(null,"Insertion Successfull");
			response.sendRedirect("AddStudent.jsp");
		}
	}

}
