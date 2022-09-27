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
<!-- 
<link rel="stylesheet" href="userDashboard.css"> -->

</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="UserDashboardController?command=displayDashboard">User Dashboard</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="UserDashboardController?command=Editprofile">Edit
							Profile</a></li>
					<li class="nav-item"><a class="nav-link" href="SessionLogout">Logout</a>



					</li>


				</ul>
			</div>
		</div>
	</nav>
	<div class="container-xl ">

		<div class=" d-flex justify-content-evenly flex-row">


			<form action="UserDashboardController">



<!-- 				<input type="submit" class="btn  btn-outline-dark" name="command"
					value="Transaction"> <input type="submit"
					class="btn  btn-outline-dark" name="command" value="Passbook">
				<input type="submit" class="btn  btn-outline-dark" name="command"
					value="Editprofile"> -->
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
      
					
					
					<div class="row row-cols-1 row-cols-md-3 g-4 text-center mx-auto mt-5 ">
  <div class="col">
    <div class="card h-100">
      <!-- <img src="img1.jpg" class="card-img-top" alt=" transaction image"> -->
      <div class="card-body">
        <h5 class="card-title">Online Transaction</h5>
        <p class="card-text">You can easily credit or debit from your account from
         anywhere using online transaction </p>
      </div>
      <div class="card-footer">
        <small class="text-muted">
				<input type="submit" class="mx-auto btn w-100 btn  btn-outline-dark" name="command"
					value="Transaction"></small>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card h-100">
   <!--    <img src="..." class="card-img-top" alt="..."> -->
      <div class="card-body">
        <h5 class="card-title">Print Passbook</h5>
        <p class="card-text">View your  bank statements online in the passbook and print your statements.</p>
      </div>
      <div class="card-footer">
        <small class="text-muted"><input type="submit"
					class="mx-auto btn w-100  btn-outline-dark" name="command" value="Passbook"></small>
      </div>
    </div>
  </div>
  <div class="col">
    <div class="card h-100">
     <!--  <img src="..." class="card-img-top" alt="..."> -->
      <div class="card-body">
        <h5 class="card-title">User Profile</h5>
        <p class="card-text"> Easily update your details here</p>
      </div>
      <div class="card-footer">
        <small class="text-muted"><input type="submit" class=" mx-auto btn w-100  btn  btn-outline-dark" name="command"
					value="Editprofile">
					</small>
      </div>
    </div>
  </div>
</div>
					
					
					
					
					
					
					
					
	
					
					
					
					
					
					
					
					
					
					
					
					
					
					

			</form>

		</div>

	</div>


























	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>