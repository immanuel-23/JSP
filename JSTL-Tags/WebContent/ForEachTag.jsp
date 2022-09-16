<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.aurionpro.model.Student ,java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>For Each TAG</title>
</head>
<body>
	<%
		List<Student> students = new ArrayList<>();
	students.add(new Student("Immanuel", 101, true));
	students.add(new Student("xyzl", 131, false));
	students.add(new Student("bcl", 1031, true));
	students.add(new Student("ipl", 1013, false));
	students.add(new Student("bc2l", 112, true));

	List<String> citys = new ArrayList<>();
	citys.add("Mumbai");
	citys.add("Chennai");
	citys.add("NewYork");
	citys.add("California");

	pageContext.setAttribute("StudentList", students);
	pageContext.setAttribute("CityList", citys);

	/*  students.forEach(n->out.println(n.getName()));*/
	%>

	<c:forEach var="student" items="${StudentList}">
		<%-- <c:if test="${student.merit }">
				<P> ${student.name} </P>
		
		</c:if> --%>
		<c:choose>
			<c:when test="${student.merit }">
				<P>${student.name} you got scholarship</P>

			</c:when>
			<c:otherwise>
				<P>${student.name} haven't got any kind of scholarship</P>

			</c:otherwise>
		</c:choose>

	</c:forEach>
	<hr>
	<c:forEach var="city" items="${CityList}">
		<P>${city}</P>

	</c:forEach>
	<hr>

	<c:set var="String" value="JAVA JSP STANDS FOR JAVA SERVER PAGE" />

	<c:if test="${fn:contains(String, 'SERVER')}">
		<p>Found SERVER string
		<p>
	</c:if>

	<p>Index: ${fn:indexOf(String, "JSP")}</p>  
	<P>${fn:toLowerCase(String)}  </P>
	<P>Length of the String is: ${fn:length(String)}<br>  </P>
	<p>${fn:replace(String, "JAVA", "java")}  </p>
	

</body>
</html>