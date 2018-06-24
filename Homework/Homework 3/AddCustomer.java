package Homework3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Homework3/AddCustomer")
public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 int id = 3;
 
  	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher( "/WEB-INF/Homework3/AddCustomer.jsp" ).forward( request, response );
		
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the user input
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String message = request.getParameter( "message" );
        
        //validation to make sure user isn't giving us empty fields
        if((firstName != null) && (firstName.length() > 0) && (lastName != null) && (lastName.length() > 0) && (message != null) && (message.length() > 0)){
        
        	 // create a new customer bean entry
            CustomerBean entry = new CustomerBean( id++, firstName, lastName, message);

            // add the new entry to the customer bean
            List<CustomerBean> entries = (List<CustomerBean>) getServletContext().getAttribute("entries" );
            entries.add(entry);

            // send the user back to the main page
            response.sendRedirect("Main");
        }
        else{//if the firstname, lastname or the message is null, give the user an error
        	if(firstName.equals(null) || firstName == "" || lastName.equals(null) || lastName == ""|| message.equals(null) || message == ""){
        		request.setAttribute("error", "All Fields are Mandatory");
        		getServletContext().getRequestDispatcher("/WEB-INF/Homework3/AddCustomer.jsp").forward(request, response);
        	}
        	
        	//doGet(request, response);
        }
       
	}

}
