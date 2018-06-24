<%@ page import= "Lab4.*" %>
<%@ page import= "java.util.ArrayList"%>
<%@ page import= "java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
	<!--get name,username, password1, password2 register form --> 
	<% String name = request.getParameter("name");%>
	<%String userName = request.getParameter("username"); %>
	<%String password1 = request.getParameter("password1");%>
	<%String password2 = request.getParameter("password2");%>
	 
	 <form class='form-signin' action='Register.jsp' method='post'>
	 
	<%if(name == null){ %>
	<input type='text' class='form-control' placeholder='name' Name='name' required autofocus>
	<% } %>
	
	<%if(request.getParameterMap().containsKey("name") && name.equals("") ){ %>
	<font  align='center' style='color:red;'>Please enter your full name. </font>
	<input type='text' class='form-control' placeholder='name' Name='name' required autofocus>
	<% } %>
	<%if(name != null && (name.isEmpty() == false)){ %>
	<input type='text' class='form-control' value='<%=name%>' placeholder='name' Name='name' required autofocus>
	<% } %>
	
	
	
	<%if(userName == null){ %>
	<input type='text' class='form-control' placeholder='username' Name='username' required autofocus>
	<% } %>
	<%if(request.getParameterMap().containsKey("username") && userName.equals("")){ %>
	<font  align='center' style='color:red;'>Please enter your username. </font>
	<input type='text' class='form-control' placeholder='username' Name='username' required autofocus>
	<% } %>
	<%if(userName != null && (userName.isEmpty() == false)){ %>
	<input type='text' class='form-control' value='<%=userName%>' placeholder='username' Name='username' required autofocus>
	<% } %>
	
	
	
	<%if( request.getParameterMap().containsKey("password1") && request.getParameterMap().containsKey("password2") &&  (request.getParameter("password1").equals(request.getParameter("password2")))  != true){ %>
	<font  align='center' style='color:red;'>PASSWORDS DO NOT MATCH! </font>
	<% } %>
	<%if(password1 == null){ %>
	<input type='password' class='form-control' placeholder='password1' Name='password1'  required>
	<% } %>
	<%if(request.getParameterMap().containsKey("password1") && password1.equals("")){ %>
	<font  align='center' style='color:red;'>Please enter a password. </font>
	<input type='text' class='form-control' placeholder='password1' Name='password1' required autofocus>
	<% } %>
	<%if(password1 != null && (password1.isEmpty() == false)){ %>
	<input type='text' class='form-control' value='<%=password1%>' placeholder='password1' Name='password1' required autofocus>
	<% } %>
	
	
	<%if(password2 == null){ %>
	<input type='password' class='form-control' placeholder='password2' Name='password2'  required>
	<% } %>
	<%if(request.getParameterMap().containsKey("password2") && password2.equals("")){ %>
	<font  align='center' style='color:red;'>Please enter a password. </font>
	<input type='text' class='form-control' placeholder='password2' Name='password2' required autofocus>
	<% } %>
	<%if(password2 != null && (password2.isEmpty() == false)){ %>
	<input type='text' class='form-control' value='<%=password2%>' placeholder='password2' Name='password2' required autofocus>
	<% } %>
	
	
	<%if(request.getParameter("name") != null && request.getParameter("username") != null && request.getParameter("password1").equals(request.getParameter("password2")) 
		&& request.getParameter("name").trim() != "" && request.getParameter("username").trim() != "" && request.getParameter("password1").trim() != "" && request.getParameter("password2").trim() != ""
		&& request.getParameter("password1").trim() != null && request.getParameter("password2") != null && request.getParameterMap().containsKey("password1") && request.getParameterMap().containsKey("password2")){ 
		
		ArrayList<Lab4User> list = (ArrayList<Lab4User>) getServletContext().getAttribute("registeredUsers"); 
		list.add(new Lab4User(request.getParameter("name"), request.getParameter("username"), request.getParameter("password1")));
		response.sendRedirect("../Lab4/Login");
		
	} %>
	
	
	<input type='submit' class='btn btn-lg btn-default btn-block' value='Register' />
	</form>
	
	
	
	
</body>
</html>