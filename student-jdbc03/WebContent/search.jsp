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

	<h1>Search query</h1>
	<table border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>E -mail</th>
		</tr>
		<c:forEach var="students" items="${student}">
			<tr>
				<td>${students.firstName}</td>
				<td>${students.lastName}</td>
				<td>${students.email}</td>


			</tr>

		</c:forEach>

	</table>
</body>
</html>