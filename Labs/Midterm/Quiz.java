package Midterm;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Remove;

import PracticeMidterm.Todo;

@WebServlet("/Midterm/Quiz")
public class Quiz extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String name = (String) session.getAttribute("studentsName");
		if(name == null || name.equals("")){
			response.sendRedirect("Main");
			return;
		}
		Object questions = session.getAttribute("question list");
		if(questions == null){
			session.setAttribute("question list", new ArrayList<ArithmeticQuestionBean>());
			session.setAttribute("answer list", new ArrayList<Integer>());
			session.setAttribute("question index", 0);
		}
		
		ArrayList<ArithmeticQuestionBean> questionList= (ArrayList<ArithmeticQuestionBean>) session.getAttribute("question list");
		int questionIndex= (int) session.getAttribute("question index");
		ArithmeticQuestionBean questionBean = null;
		if(questionList.isEmpty()){
			questionBean = new ArithmeticQuestionBean();
			questionList.add(questionBean);
		}
		//if the index equals to the size of questionlist
		if(questionIndex == questionList.size()){
			questionBean = new ArithmeticQuestionBean();
			//add a new question to the list
			questionList.add(questionBean);
		}
		
	
	
		//forward the question bean to the quiz.jsp
		request.setAttribute("question", questionList.get(questionIndex));//attached it to the request and session
		session.setAttribute("question list", questionList);//updating the list of questions in the session
		
		request.getRequestDispatcher("/WEB-INF/Midterm/Quiz.jsp").forward(request, response);
			
		
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String answer = request.getParameter("answer");
		HttpSession session = request.getSession(true);
		
		String name = (String) session.getAttribute("studentsName");
		
		if(name == null || name.equals("")){
			response.sendRedirect("Main");
			return;
		}
		

		if(answer != ""){
			
			ArrayList<ArithmeticQuestionBean> questionList = (ArrayList<ArithmeticQuestionBean>) session.getAttribute("question list");//taking it out of the ession
			int index = (int) session.getAttribute("question index");//taking it out of the ession
			ArithmeticQuestionBean questionBean = questionList.get(index);
			int user_answer = Integer.parseInt(answer);
			request.setAttribute("Current", questionBean.toString());
			request.setAttribute("Correct", (questionBean.answer));
			request.setAttribute("userAnswer", answer);
			index++;
			session.setAttribute("question index",index);
			ArrayList<Integer> answers = (ArrayList<Integer>)session.getAttribute("answer list");
			
			answers.add(user_answer);//everything we are adding users answer into the array list
			
			session.setAttribute("answer list", answers); //track how many answers we are getting 
			
			HashMap<String, Score> map = (HashMap<String, Score>) getServletContext().getAttribute("score");
			
			if(map == null){
				map = new HashMap<String, Score>();//create a new one
			}
			
			Score  scor = map.get(name); //get current score from user
			if(scor == null){//if student score is null put a new score into the score object
				map.put(name, new Score(questionBean, user_answer, name));
			}
			
			else{
				Score sco = map.get(name);
				sco.add(questionBean, user_answer);//if he does have a score then add it into the score

			}
			
			//get servlet context
			getServletContext().setAttribute("score", map);
			
			
			
			
			
			//forward ArithmeticQuestionBean to results.jsp
			request.getRequestDispatcher("/WEB-INF/Midterm/Results.jsp").forward(request, response);
		}
		else{
			

			doGet(request, response);
		}
		
		
		
	}

}
