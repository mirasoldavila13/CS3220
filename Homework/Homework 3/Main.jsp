<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer Relationship Management</title>

<link rel='stylesheet'href='https://bootswatch.com/cyborg/bootstrap.min.css' />
<style>
.table-hover {
	color: green;
	background: transparent;
}

.table-condensed {
	padding: 2px;
}

background {
	background-image: url("https://bootswatch.com/cyborg/bootstrap.min.css");
}
</style>

</head>
<body>
	<h5 align="center">Welcome to The Customer Relationship Management Application</h5>

	<form action="Main" method="post">
		<input type="text" name="searchQuery"
			placeholder="Enter a search query" value="${param.searchQuery}"><input
			type="submit" name="search" value="Search">
	</form>
	<table class="table table-hover">
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Message</th>
			<th>Operations</th>
		</tr>
		<c:forEach items="${entries}" var="entry">
			<tr>
				<td>${entry.id}</td>
				<td>${entry.firstName}</td>
				<td>${entry.lastName}</td>
				<td><c:out value="${entry.message}" escapeXml="true" /></td>
				<td><a href="EditCustomer?id=${entry.id}" style="color: green">Edit</a><br>
				<a href="RemoveCustomer?id=${entry.id}" style="color: green">Remove</a></td>
			</tr>
		</c:forEach>
	</table>
	<p align="Center">
		<a href="AddCustomer" style="color: green">Add Customer</a>
	</p>
</body>
</html>