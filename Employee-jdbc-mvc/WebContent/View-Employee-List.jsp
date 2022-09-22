<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table border="1">
		<tr>
			<th>id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>E -mail</th>
			<th>Department</th>
			<th>Salary per month</th>
			<th>Salary Per Anum</th>
			
			
		</tr>
		<c:forEach var="employee" items="${employeeList}">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.firstName}</td>
				<td>${employee.lastName}</td>
				<td>${employee.email}</td>
				<td>${employee.department}</td>
				<td>${employee.salary}</td>
				<td>${(employee.salary)*12}</td>
				
				
				
			</tr>

		</c:forEach>
</body>
</html>