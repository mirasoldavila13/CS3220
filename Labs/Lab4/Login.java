package Lab4;

import java.io.IOException; 
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("Lab4/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
        
    }
    /* http://bootsnipp.com/snippets/featured/google-style-login-extended  Use this link from bootsnipp.com to create the login*/
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
//		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("    <head>");
		out.println("         <title>Request Info</title>");
		out.println("         <meta charset='ut-8'>");
		out.println("         <link rel='stylesheet' href='https://bootswatch.com/cyborg/bootstrap.min.css' />");
		out.println("    </head>");
		out.println("    <body>");
							
		out.print("        	<div class='container'>");
		out.println("        	 <div class='row'>");
		out.println("		 	 <div class='col-sm-6 col-md-4 col-md-offset-4'>");
		out.println("      		 <div class='account-wall'>");
		out.println("     		 <div id='my-tab-content' class='tab-content'>");
		out.println("      	   	 <div class='tab-pane active' id='login'>");
		out.println("			 <img class='profile-img' src='https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120'"
				+	            "alt=''>");
								//action login, method post
		out.println("       	<form class='form-signin' action='Login' method='post'>");
		out.println("        	<input type='text' class='form-control' placeholder='Username' Name='Username' required autofocus>");//Username
		out.println("        	<input type='password' class='form-control' placeholder='Password' Name='Password'  required>");//Password
								//create a checkbox
		out.println("		   <input type='checkbox' value='Remember Me' required/>Remember Me");
		
		out.println("          <input type='submit' class='btn btn-lg btn-default btn-block' value='Sign In' />");
		out.println("          </form>");
		out.println("        <div id='tabs' data-tabs='tabs'>");
		out.println("       <p class='text-center'><a href='#register' data-toggle='tab'>Need an Account?</a></p>");
		out.println("      </div>");
		out.println("    </div>");
		out.println("	</body>");
		out.println("</html>");
		
		
		
		
		
	}
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		List<Lab4User> registeredUsers = new ArrayList<Lab4User>();
		registeredUsers.add(new Lab4User("John Doe", "john","abcd"));
		registeredUsers.add(new Lab4User("Mary Jane", "mary","abcd"));
		registeredUsers.add(new Lab4User("Joe Boxer", "joe","abcd"));
		getServletContext().setAttribute("registeredUsers",registeredUsers);
	}
	
	//cookies
	private String getName(HttpServletRequest request){
		Cookie[] cookie = request.getCookies();
		if(cookie != null){//if the cookie isn't null return thse username
			for(Cookie c: cookie){
				if(cookie.equals("username")){
					return c.getValue();
				}
			}
		}
		//if the cookie is null return null
		return null;
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text.html");
		PrintWriter out = response.getWriter();
		//retrieve the user and password from user
		String name = request.getParameter("Username");
		String password = request.getParameter("Password");
		String validation = request.getParameter("Check");
		
		//create an arraylist
		ArrayList<Lab4User> list = (ArrayList<Lab4User>) getServletContext().getAttribute("registeredUsers"); 
		
		if(validation != null){
			
			Cookie username = new Cookie("Username",name);
			response.addCookie(username);
			
		}
		
		//populate the list
//		for(Lab4User user: list){
//			if(name.equals(user.getName()) && password.equals(user.getPassword())){
//				//create session variable and 
//				HttpSession currentUser = request.getSession();
//				currentUser.setAttribute("UserList", user); 
//				//redirect the user to the welcome page
//				response.sendRedirect("Welcome");
//				return;
//			}
//		}
		
	
	
	}

}
