<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Student Form</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<form action="StudentController" method="GET">
		First Name : <input type="text" name="fname"
			placeholder="Enter first name" value="${studentRecord.firstName}"> 
		<br><br> 
		Last Name : <input type="text" name="lname"
			placeholder="Enter last name" value="${studentRecord.lastName}"> 
		<br><br> 
		Email : <input type="email" name="email"
			placeholder="Enter email" value="${studentRecord.email}"> 
		<br><br> 
		<input type="hidden" name="command" value="update">
		<input type="hidden" name="id" value="${studentRecord.id}">
		<input type="submit" class="btn btn-primary" value="Edit">
		
		
	</form>
</body>
</html>