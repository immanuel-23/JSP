<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Response</title>
</head>
<body>
	<c:set var="name" value="${param.uname}" />
	<c:set var="password" value="${param.pass}" />
	<c:choose>
		<c:when test="${name =='admin' && password=='admin'}">
			<h1>Welcome Admin</h1>
		</c:when>
		<c:otherwise>
			<h1>Wrong Credentials</h1>
			<a href="login.html">Back to Login Page</a>
		</c:otherwise>
	</c:choose>
	
	
	
	
		
	
</body>
</html>