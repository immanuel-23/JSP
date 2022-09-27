<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>userList List</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
     <a class="navbar-brand" href="AdminDashboardController?command=displayDashboard">Admin Dashboard</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">

        <li class="nav-item">
          <a class="nav-link" href="AdminDashboardController?command=Users">View Users</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="AdminDashboardController?command=Transactions">Transactions</a>
        </li>
        <li class="nav-item">
        
         <a class="nav-link" href="SessionLogout">Logout</a>
          
	
        </li>
        
      </ul>
    </div>
  </div>
</nav>
	<div class="container-sm">
	


		<h1 class="display-5"> Admin Page User List</h1>
		<br> 
		
		
	<form action="AdminDashboardController">
		<button type="submit" class="btn btn-lg btn-light">Add User</button>
		<input type="hidden" class="form-control" name="command" value="displayAddForm">
		<br></form>

<br>
<form action="AdminDashboardController">
<div class="row g-3">
<div class="col-sm-8">
<input type="text" class="form-control "placeholder="Search here" name="q"></div>
<div class ="col-sm">
<input type="hidden" class="form-control" name="command" value="search">
</div>
<div class ="col-sm">
<button type="submit" class="btn btn-dark ">Search</button></div>
</div>
</form>
<br>
<br>




		<table class="table table-hover">
			<tr>
				<th>ID</th>
				<th>User Name</th>
				<th>User Password</th>
				<th>Balance</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		<c:if test="${userList == null}">
			<p class="display-6">No records found</p>
		</c:if>

			<c:forEach var="users" items="${userList}">
			

				<c:url var="updateLink" value="AdminDashboardController">
					<c:param name="command" value="load"></c:param>
					<c:param name="userId" value="${users.userId}"></c:param>
					<c:param name="userName" value="${users.userName}"></c:param>
					<c:param name="userPassword" value="${users.userPass}"></c:param>
					<c:param name="userBalance" value="${users.balance}"></c:param>
				</c:url>


		<c:url var="deleteLink" value="AdminDashboardController">
					<c:param name="command" value="delete"></c:param>
					<c:param name="userId" value="${users.userId}"></c:param>
				</c:url>

				<tr>
					<td>${users.userId}</td>
					<td>${users.userName}</td>
					<td>${users.userPass}</td>
					<td>${users.balance}</td>

					<td><a href="${updateLink}"> <input type="button"
							class="btn btn-outline-dark" value="Update"></a></td>

					<td><a href="${deleteLink}"> <input type="button"
							class="btn btn-dark" value="Delete"></a></td> 


				</tr>


			</c:forEach>

		</table>

	</div>
	
	
	

	

	

	
	
	

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>