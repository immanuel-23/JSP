<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Set Cookies</h1>
	<%
		Cookie cookies[] = request.getCookies();
	boolean isColorSet = false;
	
	if (cookies != null) {
		for (Cookie c : cookies) {
			if(c.getName().equals("color")){
				String bgcolor=c.getValue();
				out.println("<body style=background-color:"+bgcolor+";></body>");
			}
			
		}

	}
	if(!isColorSet){
		Cookie thisCookie= new Cookie("color","red");
		thisCookie.setMaxAge(7*24*60*60);
		response.addCookie(thisCookie);
		isColorSet=true;

	}
	%>

</body>
</html>