<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Customer</title>
<link rel='stylesheet' href='https://bootswatch.com/cyborg/bootstrap.min.css' />
<style>

h4{
	color: red;
}

</style>

</head>
<body>
<br>
<h4>${error}</h4>

	<form action="AddCustomer" method="post" style="color: green">
		First Name: <input type="text" name="firstName"/> <br /> <br />
		Last Name: <input type="text" name="lastName" /> <br /> <br />
		 <textarea name="message" style="border: 2"></textarea>
		<br /> <input type="submit" name="add" value="Add" />
	</form>
</body>
</html>