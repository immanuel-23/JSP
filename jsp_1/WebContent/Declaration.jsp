<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Declaration is used to declare the functions  -->
<jsp:include page="Header.html"></jsp:include>
<%!
	String showGreeting(String name){
	
	return "Hello "+name;
}
%>
<%= showGreeting("Immanuel") %>
<jsp:include page="Footer.html"></jsp:include>

</body>
</html>