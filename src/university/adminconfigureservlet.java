package university;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adm
 * inconfigure
 */

public class adminconfigureservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminconfigureservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			processRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request,response);
	}
	public void processRequest(HttpServletRequest request, HttpServletResponse response)
	{
		Integer n1=Integer.parseInt(request.getParameter("intime"));
		Integer n2=Integer.parseInt(request.getParameter("outtime"));
		Integer n3=Integer.parseInt(request.getParameter("nooftests"));
		Integer n4=Integer.parseInt(request.getParameter("workinghrs"));
		Integer n5=Integer.parseInt(request.getParameter("workingdays"));
		String n6=request.getParameter("passcode");
		AdminDefaults.setDetails(n1, n2, n3, n4,n5,n6);
	}


}
