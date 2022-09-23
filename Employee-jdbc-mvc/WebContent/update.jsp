<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
	<style>
	body{
	background-color: #fdf4ff;
	}
	
	</style>
</head>
<body>
	<h1 style="text-align: center">Update Student Record </h1>
	<div class="container" style="justify-content: center">
	<div style="padding-left:450px">
	<form action="EmployeeController" method="GET">
		First Name :<br> <input type="text" name="fname"
			placeholder="Enter first name" value="${employeeRecord.firstName}"> 
		<br><br> 
		Last Name :<br> <input type="text" name="lname"
			placeholder="Enter last name" value="${employeeRecord.lastName}"> 
		<br><br> 
		Email : <br><input type="email" name="email" style=""
			placeholder="Enter email" value="${employeeRecord.email}"> 
		<br><br> 
		Department: <br><input type="text" name="dept"
			placeholder="Enter email" value="${employeeRecord.department}"> 
		<br><br> 
		Salary :<br> <input type="number" name="sal"
			placeholder="Enter email" value="${employeeRecord.salary}"> 
		<br><br> 
		<input type="hidden" name="command" value="update">
		<input type="hidden" name="id" value="${employeeRecord.id}">
		<input type="submit" class="btn btn-primary" value="Edit Data">
		
		
	</form>
	</div>
	<div>
	
</body>
</html>