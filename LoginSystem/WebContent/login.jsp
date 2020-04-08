<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="registration" method = "post">
		<table style="background-color: skyBlue; margin-left: 20px;">
		<tr>
		<td>
		<h1 style= "color:red;">${message}</h1>
		<h1 style= "color:green;">${successMessage}</h1>
		</td>
		</tr>
			<tr>
				<td><h3 style="color: red">Login Page</h3></td>
				<td></td>
			</tr>
			<tr>
				<td>User Name :</td>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Sign In"></td>
				<td><a href="register.jsp">Sign Up</a></td>
			</tr>

		</table>
	</form>
</body>
</html>