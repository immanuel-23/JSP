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
		</tr>
		<c:forEach var="student" items="${studentList}">
			<tr>
				<td>${student.id}</td>
				<td>${student.firstName}</td>
				<td>${student.lastName}</td>
				<td>${student.email}</td>
			</tr>

		</c:forEach>
</body>
</html>