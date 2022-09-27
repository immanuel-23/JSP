
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transaction list</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	
	
	
	<style>
/* Chrome, Safari, Edge, Opera */
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

/* Firefox */
input[type=number] {
  -moz-appearance: textfield;
}
</style>

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
	
		


		<h1 class="display-5">ALL Transactions</h1>
		
		<br> <br>

		<form action="AdminDashboardController">

			
			
			
			<div class="row g-3">
<div class="col-sm-8">
<input type="text" class="form-control "placeholder="Search here" name="q"></div>
<div class ="col-sm">
<input type="hidden" class="form-control" name="command" value="searchTransaction">
</div>
<div class ="col-sm">
<button type="submit" class="btn btn-dark ">Search</button></div>
</div>
			
			
			
			
			
			
		</form>
		
		
<hr>

		<table class="table table-hover mt-5">
			<tr>
				<th>Transaction ID</th>
				<th>User ID</th>
				<th>Transaction Type</th>
				<th>Date</th>
				<th>Amount</th>
				<th>Balance</th>

			</tr>
			<c:if test="${transactionList == null}">
				<p class="display-6">No records found</p>
			</c:if>

			<c:forEach var="transaction" items="${transactionList}">



				<tr>
					<td>${transaction.transactionId}</td>
					<td>${transaction.userId}</td>
					<td>${transaction.transactionType}</td>
					<td>${transaction.transactionDate}</td>
					<td>${transaction.transactionAmount}</td>
					<td>${transaction.balance}</td>




				</tr>


			</c:forEach>

		</table>
		
		<input type="button" class="btn btn-dark" value="print" onClick="window.print()"/> 

	</div>









	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>












</body>
</html>