<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Add User </title>


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





		<h1 class="display-5">Admin Page Add User</h1>

		<form action="AdminDashboardController" method="POST" id="#Form">


			<label for="username"> User Name: </label> <input type="text"
				class="form-control" name="username" placeholder="Enter User Name">



			<label for="password"> User Password: </label> <input type="text"
				class="form-control" name="password" placeholder="Enter Password">


			<label for="balance"> User Balance: </label> <input type="number"
				class="form-control" name="balance"  value = "1000" placeholder="Add Balance">
			
			
			<input type="hidden" name="command" value="add"> <br> 
			<input type="submit" class="btn btn-dark" value="Add User">




		</form>
	</div>

<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>




		</body>
		</html>
	