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



<h1 class="display-5">
Admin Page 
Update User Record</h1>
	 
   <form action="AdminDashboardController" > 
	       
    
          <div>
                <label for="id">User ID  : </label>
                <br>
                <input type="text" name="id" class="form-control" value="${updateUser.userId}" disabled="disabled">
            </div>
    
            <div>
                <label for="username">Update User Name  : </label>
                <br>
                <input type="text" name="username" class="form-control" value="${updateUser.userName}" >
            </div>
            <div>
                <label for="password">  Update Password: </label>
                <br>
                <input type="text" name="password" class="form-control" value="${updateUser.userPass}">
            </div>
            <div>
                <label for="balance">Update Balance : </label>
                <br>
                <input type="number" name="balance" class="form-control" value="${updateUser.balance}" >
            </div>
            <div>
            <input type="hidden" name="command" value="update">
              <input type="hidden" name="id" value="${updateUser.userId}">
              <br><br>
                <button type="submit" class="btn btn-lg btn-dark">Edit</button>
      
            </div>
      
 
</form>

</div>




	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

	

</body>
</html>