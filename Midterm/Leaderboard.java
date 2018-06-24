package Midterm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Midterm/Leaderboard")
public class Leaderboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//if the student didn't provide their name redirect to name controller
		HttpSession session = request.getSession(true);
		String name = (String) session.getAttribute("studentsName");
		
		if(name == null || name.equals("")){
			response.sendRedirect("Main");
			return;
		}
		//forward a collection of all students and their scores to leaderboard.jsp
		ArrayList<Score> entries = new ArrayList<Score>();
		HashMap<String, Score> score = (HashMap<String, Score> )getServletContext().getAttribute("score");
		if(score != null){
			for (String studentNames : score.keySet()){
				//pass an empty map
				entries.add(score.get(studentNames));
				
			}
			
		}
		request.setAttribute("entries", entries);
		request.getRequestDispatcher("/WEB-INF/Midterm/Leaderboard.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
