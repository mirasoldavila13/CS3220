<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Customer</title>
<link rel='stylesheet' href='https://bootswatch.com/cyborg/bootstrap.min.css' />
</head>
<body>
<form action="EditCustomer" method="post" style="color: green">
First Name: <input type="text" name="firstName" value="${entry.firstName}"/> <br />
Last Name: <input type="text" name="lastName" value="${entry.lastName}"/> <br />
<textarea name="message">${entry.message}</textarea> <br />
<input type="hidden" name="id" value="${entry.id}" />
<input type="submit" name="save" value="Save" />
</form>
</body>
</html>