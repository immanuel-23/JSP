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
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">First</th>
      <th scope="col">Last</th>
      <th scope="col">Handle</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>
      <td>@twitter</td>
    </tr>
  </tbody>
</table>

<table class="table">
  <thead class="thead-light">
  
</table>
	<table border="1">
		<tr>
			<th>id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>E -mail</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<c:forEach var="student" items="${studentList}">
			<c:url var="updateLink" value="StudentController">
				<c:param name="command" value="load"></c:param>
				<c:param name="studentId" value="${student.id}"></c:param>
			</c:url>
			<c:url var="deleteLink" value="StudentController">
				<c:param name="command" value="delete"></c:param>
				<c:param name="studentId" value="${student.id}"></c:param>
			</c:url>
			<tr>
				<td>${student.id}</td>
				<td>${student.firstName}</td>
				<td>${student.lastName}</td>
				<td>${student.email}</td>
				<td><a href="${updateLink}"><input type="button" value="Update" ></a></td>
				<td><a href="${deleteLink}"><input type="button" value="Delete" ></a></td>
				


			</tr>

		</c:forEach>

	</table>
	<br>
	<input type="button" value="add student"
		onclick="window.location.href='add-student-form.jsp'";>
</body>
</html>