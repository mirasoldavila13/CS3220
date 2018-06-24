package Homework3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Homework3/EditCustomer")
public class EditCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	 @SuppressWarnings("unchecked")
	    private CustomerBean getEntry( Integer id )
	    {
	        List<CustomerBean> entries = (List<CustomerBean>) getServletContext().getAttribute("entries" );

	        for(CustomerBean entry : entries)
	            if( entry.getId() ==id) {
	            	return entry;
	            }
	        return null;
	    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the entry to be edited
        Integer id = Integer.valueOf( request.getParameter("id"));
        CustomerBean entry = getEntry(id);

        // pass the entry to jsp using request scope
        request.setAttribute( "entry", entry );
        request.getRequestDispatcher( "/WEB-INF/Homework3/EditCustomer.jsp" ).forward(request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get the entry to be edited
        Integer id = Integer.valueOf( request.getParameter("id"));
        CustomerBean entry = getEntry(id);

        // change the entry based on user input
        entry.setFirstName( request.getParameter("firstName"));
        entry.setLastName(request.getParameter("lastName"));
        entry.setMessage( request.getParameter("message"));

        // send the user back to the Main page
        response.sendRedirect("Main");
	}

}
