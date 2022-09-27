<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
	<script src="validation.js"></script>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome</h1>
	<h2>Add Student</h2>
	<form action="StudentController" id="aform">
	
		First Name:<input type="text" name="fname" > <br> <br>
		Last Name:<input type="text" name="lname" > <br> <br>
		Email id:<input type="email" name="email"><br><br>
		<input type="hidden" name="command" value="add">
		
		<input type="submit" value="Add Student">
		
	</form>
	<script src=   
    "https://ajax.googleapis.com/ajax/libs/   
    jquery/3.3.1/jquery.min.js">   
    </script>   
</body>
</html>