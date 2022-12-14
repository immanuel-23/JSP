<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Data</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<style>
body {
	background-color: #fdf4ff;
}

</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css" integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<h1 style="text-align: center">Employee List</h1>

	<div class="container" style="padding-top: 20px">
	<div style="padding-left: 400px">
	<form action="EmployeeController">
			<label>Name :</label>
			 <input type="text" placeholder="Username" name="ename" style="height: 40px; border-radius:30px ;border-color: #0d6efd"> 
				 <input type="hidden" name="command" value="search"> <input
				type="submit" value="Search" class="btn btn-outline-primary">
		</form>
	</div>
	



		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Email-id</th>
					<th scope="col">Department</th>
					<th scope="col">Salary per month</th>
					<th scope="col">Salary per anum</th>
					<th scope="col">Update</th>
					<th scope="col">Delete</th>


				</tr>
			</thead>
			<tbody>




				</tr>
				<c:forEach var="employee" items="${employeeList}">
					<c:url var="updateLink" value="EmployeeController">
						<c:param name="command" value="load"></c:param>
						<c:param name="employeeId" value="${employee.id}"></c:param>
					</c:url>
					<c:url var="deleteLink" value="EmployeeController">
						<c:param name="command" value="delete"></c:param>
						<c:param name="employeeId" value="${employee.id}"></c:param>
					</c:url>
					<tr>
						<td>${employee.firstName}</td>
						<td>${employee.lastName}</td>
						<td>${employee.email}</td>
						<td>${employee.department}</td>
						<td>${employee.salary}</td>
						<td>${(employee.salary)*12}</td>
						<td><a href="${updateLink}"><input type="button"
								class="btn btn-outline-secondary" value="update"></a></td>
						<td><a href="${deleteLink}"><input type="button"
								class="btn btn-outline-danger" value="delete"></a></td>

					</tr>

				</c:forEach>
		</table>
		<br> <br> <input type="button" value="add student"
			class="btn btn-outline-success"
			onclick="window.location.href='add-employee-form.jsp'";> <br>
			
		
		


	</div>

	</div>


</body>

</html>