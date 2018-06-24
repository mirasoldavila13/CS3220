package Midterm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Midterm/Main")
public class Name extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Midterm/Name.jsp").forward(request, response);
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//create a string with a  parameter named studentsName
		String studentName = request.getParameter("studentsName");
		
		// validate if the studentsName parameter is empty or null, re-display name.jsp
		if(studentName == null || studentName == ""){

			request.getRequestDispatcher("/WEB-INF/Midterm/Name.jsp").forward(request, response);
			//return 
			return;
		}

		/*if studentsName parameter is 1 or greater, add the students name to a session attribute name studentNames 
		  and redirect to quiz*/
		if(studentName.trim().length() >= 1){
			//create a session attribute and redirect to the user to the quiz controller
			HttpSession session = request.getSession();
			session.setAttribute("studentsName", studentName);
			
			response.sendRedirect("Quiz");

		}
		else{
			doGet(request, response);
		}
		
		
	}

}
