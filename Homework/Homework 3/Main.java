package Homework3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import PracticeMidterm.Todo;

@WebServlet("/Homework3/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
 
    
    public void init(ServletConfig config)throws ServletException{
    	super.init(config);
    	// create an arraylist of test values
    	List<CustomerBean> entries = new ArrayList<CustomerBean>();
    	entries.add( new CustomerBean (1,"Denise", "Molina", "Hi"));
    	entries.add(new CustomerBean (2,"Kathrine", "Parge", "How are you doing?"));

    	getServletContext().setAttribute( "entries", entries );
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Homework3/Main.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<CustomerBean> entries = (ArrayList<CustomerBean>) getServletContext().getAttribute("entries");


		// this list contains customer entries that match search query
		ArrayList<CustomerBean> filterEntries = new ArrayList<CustomerBean>();

		//get the search query
		String searchQuery = request.getParameter("searchQuery");
		System.out.println("You searched for: " + searchQuery);
		//iterate over entries
		for(CustomerBean entry: entries){
			if(entry.getFirstName().toLowerCase().contains(searchQuery.toLowerCase()) || entry.getLastName().toLowerCase().contains(searchQuery.toLowerCase())){//does this string contain this tring
				//if the description contiains the search query , add it to the filtered list
				filterEntries.add(entry);
			}
		}

		request.setAttribute("entries", filterEntries );

		doGet(request, response);
	}

}
