<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Hello you have submited your form</h1>
<!-- to fetch data we have do methods <%=request.getParameter("fname") %> and  ${param.fname}
 -->
user name:<%=request.getParameter("fname") %><br>
last name:${param.lname }
<br>
country:${param.country }
<br>
gender:${param.gender }
<br>
languages:

<%-- <%
	String[]languages=request.getParameterValues("language");
	for(String s:languages){
		out.println(s);
	}
%> --%>

<%
		String[] language = request.getParameterValues("language");
		pageContext.setAttribute("lang", language);
	%>
	<c:forEach var="language" items="${lang}">
			<p>${language}</p>
	</c:forEach>
</body>
</html>