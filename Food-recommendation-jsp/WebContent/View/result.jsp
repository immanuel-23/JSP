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
	<h1>List of food based on your taste </h1>
	
	<c:forEach var="taste" items="${FoodList}">
		<P>${taste}</P>

	</c:forEach>
	<a href="./form.html"><Button>Go back to form</Button></a>
	

</body>
</html>