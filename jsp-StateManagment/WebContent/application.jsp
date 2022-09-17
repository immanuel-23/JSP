<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome to session</h1>
<%
		if (application.getAttribute("counter") == null) {
			application.setAttribute("counter", 0);
	}
	int count=(Integer)application.getAttribute("counter");
	
	%>
	old application. Value :<%=application.getAttribute("counter") %>
		<% application.setAttribute("counter", ++count);%>

	new Value:<%=application.getAttribute("counter")%>
	
	<% %>
</body>
</html>