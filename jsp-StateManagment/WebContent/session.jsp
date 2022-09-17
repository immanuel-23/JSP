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
		if (session.getAttribute("counter") == null) {
		session.setAttribute("counter", 0);
	}
	int count=(Integer)session.getAttribute("counter");
	
	%>
	old Session Value :<%=session.getAttribute("counter") %>
		<% session.setAttribute("counter", ++count);%>

	new Value:<%=session.getAttribute("counter")%>
	<% %>
</body>
</html>