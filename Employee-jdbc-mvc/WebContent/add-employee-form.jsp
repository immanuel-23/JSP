<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
		<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body{
background-color: #fdf4ff;
}
</style>
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align: center; padding-top: 30px">Add new Employee</h1>
	<div class="container" style="padding-left: 500px; ">
		<form action="EmployeeController">
			<label>First Name</label><br>
			 <input type="text" name="fname"> <br> <label>Last
				Name</label>
			<br> <input type="text" name="lname"> <br> <label>Email-id:</label>
			<br> <input type="text" name="email"> <br> <label>Department:</label>
			<br> <input type="text" name="dept"> <br> <label>Salary:</label>
			<br> <input type="number" name="sal"> <br> <input
				type="hidden" name="command" value="add"> <br> <input
				type="submit" value="Add Student" class="btn btn-outline-primary">
		</form>

	</div>

</body>
</html>