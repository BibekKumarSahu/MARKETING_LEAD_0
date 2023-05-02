<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All List</title>
</head>
<body>
	<h1>All List Here...</h1>
	<table border="1">
		<tr>
			<th>Name</th>
			<th>City</th>
			<th>Mobile</th>
			<th>Email</th>
			<th>Action</th>
		</tr>
		<c:forEach var="lead" items="${leads}">
			<tr>
				<td>${lead.name}</td>
				<td>${lead.city}</td>
				<td>${lead.mobile}</td>
				<td>${lead.email}</td>
				<td>
				<a href="delete?id=${lead.id}">delete</a>
				<a href="update?id=${lead.id}">update</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>