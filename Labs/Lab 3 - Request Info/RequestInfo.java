package Lab3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
	/*Your servlet should output two sections: Request Parameters and Header
	  Information
	  The Request Parameters section should consist of a table with two columns,
	  Parameter Name and Parameter Value.
	  The Header Information section should consist of a table with two columns,
      Header Field and Header Value.
     */

@WebServlet("/Lab3/RequestInfo")
public class RequestInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestInfo() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//create get, enumeration(header values), arraylist(retrieve data from header value), enumerations(parameter value), arraylist(retreive data from parameter value) variables
		String get = request.getMethod();
		Enumeration<String>headerValue = request.getHeaderNames();//header value
		ArrayList<String>arraylistHeader = new ArrayList<String>();//retrieve head value
		
		Enumeration<String>parameterValue = request.getParameterNames();//Parameter values
		ArrayList<String>arraylistParameter = new ArrayList<String>();//Retrieve Parameter value
		
		//while loop for header value
		while(headerValue.hasMoreElements() == true){//runs through until there's no more elements
			arraylistHeader.add(headerValue.nextElement());
		}
		
		//while loop for parameter value
		while(parameterValue.hasMoreElements() == true){
			arraylistParameter.add(parameterValue.nextElement());
		}
		
		
		response.setContentType("text.html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("    <head>");
		out.println("         <title>Request Info</title>");
		out.println("         <meta charset='ut-8'>");
		out.println("         <link rel='stylesheet' href='https://bootswatch.com/cyborg/bootstrap.min.css' />");
		out.println("    </head>");
		out.println("    <body>");
		out.print("        <div class='jumbtron'>");
		out.println("        <h1>Request Parameters Lab3</h1>");
		out.println("<p>" + "The following <b>" + get +"</b> request was submitted on " + new Date() + "</p>");
		out.println("      </div>");
		
		/*request parameters consist of a table with two columns,
	  	Parameter Name and Parameter Value.*/
		
		out.println("<h3>Request Parameters</h3>");
		//create Parameter table
		out.println("<table class='table table-striped table-hover'>");
		
		out.println("<thead>");
		out.println("	<tr>"); 
		out.println("     <th>Parameter Name</th>");
		out.println("     <th>Parameter Value</th>");
		out.println("	</tr>");
		out.println("<thead>");
		out.println("<tbody>");
		
		//for each loop
		for(String arr: arraylistParameter){
			out.println(" 	<tr>");
			out.println("     <td>"+ arr + "</td>");
			out.println(" 	<td>" + request.getParameter(arr) + " </td>");
			out.println(" 	</tr>");
		}

		out.println("</tbody>");
		out.println("</table>");
		
		/* Header information consist of a table with two columns,  Header Field and Header Value.*/
		out.println("<h3>Header Information</h3>");
		//create Header information table
		out.println("<table class='table table-striped table-hover'>");
		
		out.println("<thead>");
		out.println("	<tr>"); 
		out.println("     <th>Header Field</th>");
		out.println("     <th>Header Value</th>");
		out.println("	</tr>");
		out.println("<thead>");
		out.println("<tbody>");
		
		
		//for each loop
		for(String arr: arraylistHeader){
			out.println(" 	<tr>");
			out.println("     <td>"+ arr + "</td>");
			out.println(" 	<td>" + request.getHeader(arr) + " </td>");
			out.println(" 	</tr>");
		}
		
		out.println(" 	</tr>");
		out.println("</tbody>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
