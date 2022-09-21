<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Authenticate">
	firstName:<input type="text" name="fname">
	<BR><BR>
	lastName:<input type="text" name="lname">
		<BR><BR>

	country:<select name="country">
	<option>England</option>
		<option>India</option>
		<option>Denmark</option>
		<option>Newzeland</option>
	</select>
		<BR><BR>
	
	gender:<input type="radio" name="gender" val="male">male
		<BR><BR>
	
	gender:<input type="radio" name="gender" val="female">female
		<BR><BR>
	
	
	language:<input type="checkbox" name="language" value="java">JAVA
			<input type="checkbox" name="language" value="PHP">PHP
			<input type="checkbox" name="language" value="C++">C++
			<input type="checkbox" name="language" value="GO">GO
					<BR><BR>
			<button type="submit" value="Submit">Submit</button>
</form>

</body>
</html>