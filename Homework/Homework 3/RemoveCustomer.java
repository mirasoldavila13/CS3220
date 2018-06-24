package Homework3;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Homework3/RemoveCustomer")
public class RemoveCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CustomerBean removeEntry( Integer id )
    {
        List<CustomerBean> entries = (List<CustomerBean>) getServletContext().getAttribute("entries" );

        for(CustomerBean entry : entries)
            if(entry.getId() ==id) {
            	entries.remove(entry);
            	break;
            }
        return null;
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// send the user back to the customer page
		removeEntry(Integer.valueOf(request.getParameter("id")));
        response.sendRedirect("Main");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 
	}

}
