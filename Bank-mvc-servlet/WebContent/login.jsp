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


<div class="p-3 mb-2 bg-dark text-white">
	<div class="container-sm d-flex justify-content-center">
	<div class="d-flex flex-xl-column">
	<div class="mb-3">
		<h1 class="display-5">Bank login</h1></div>

		<form action="BankController">
			<div class="mb-3">
				<label for="adminRadio" class="form-check-label">Admin
					Login</label> <input type="radio" name="command" id="adminRadio"
					value="adminLogin" class="form-check-input"> <br> <label
					for="userRadio" class="form-check-label">User Login</label> <input
					type="radio" id="userRadio" name="command" value="userLogin"
					class="form-check-input"> <br>
			</div>

			<div class="mb-3">
				<input type="text" name="username" placeholder="username" class="form-control"> <br>
			</div>

			<div class="mb-3">
				<input type="password" name="password" placeholder="password" class="form-control">
				<br>
			</div>
			<div class="mb-3">

				<input type="submit" value="login" class="btn btn-outline-light" class="form-control"><br>
			</div>
		</form>
		</div>

	</div>
	
	
	</div>

<!-- <div class="p-3 mb-2 bg-success text-white"></div>
<div class="p-3 mb-2 bg-secondary text-white"></div>

<div class="p-3 mb-2 bg-transparent text-dark"></div> -->


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>

</body>
</html>