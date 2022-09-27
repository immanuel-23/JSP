<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
<a class="navbar-brand" href="UserDashboardController?command=displayDashboard">User Dashboard</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="UserDashboardController?command=Editprofile">Edit Profile</a>
        </li>
        <li class="nav-item">
        
         <a class="nav-link" href="SessionLogout">Logout</a>
         	

        </li>
        
        
      </ul>
    </div>
  </div>
</nav>
	<div class="container-sm">

		


		<h1 class="display-5">Transaction Page</h1>

		<form action="TransactionController">
				<div class="mb-3">
			<label for="withdraw">Withdraw Cash</label> 
			<input type="radio"id="withdraw" name="command" value="withdraw" required="required">
			<br> <label for="deposit">Deposit Cash</label> 
			
			
			
			<input type="radio" id="deposit" name="command" value="deposit"
				required="required"> <br> 
				</div>
				<div class="mb-3">
				<label for="amount">
				Enter Ammount</label> <input type="number" name="amount"
				placeholder="Enter amount" required="required" class="form-control"> 
				</div>
				<div class="mb-3">
				
				<br> 
				<input type="submit" value="SUBMIT">
				</div>

		</form>

	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>



</body>
</html>