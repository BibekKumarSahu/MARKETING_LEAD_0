<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Lead</title>
</head>
<body>
	<h1>Create Marketing Lead</h1>
	<form action="edit">
	<input type="hidden" name="id" value="${lead.id}"/>
	<pre>
	Name<input type="text" name="name" value="${lead.name}"/>
	City<input type="text" name="city" value="${lead.city}"/>
	Mobile<input type="text" name="mobile" value="${lead.mobile}"/>
	Email<input type="text" name="email" value="${lead.email}"/>
	<input type="submit" value="update"/>
	</pre>
	</form>
	${msg}
</body>
</html>