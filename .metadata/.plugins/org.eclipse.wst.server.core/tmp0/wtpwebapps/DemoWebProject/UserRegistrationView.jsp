<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="Header.jsp"%>
	<%
	String succesMsg = (String) request.getAttribute("successMsg");
	String errorMsg = (String) request.getAttribute("erorrMsg");
	%>
	<div align="center">
		<h1>User Registration</h1>
		<h3 style="color: green"><%=succesMsg != null ? succesMsg : ""%></h3>
		<h3 style="color: red"><%=errorMsg != null ? errorMsg : ""%></h3>
		<form action="UserRegistrationCtl" method="post">

			<table>

				<tr>
					<th>First Name :</th>
					<td><input type="text" name="firstName" value=""
						placeholder="enter first name"></td>
				</tr>

				<tr>
					<th>Last Name :</th>
					<td><input type="text" name="lastName" value=""
						placeholder="enter last name"></td>
				</tr>

				<tr>
					<th>Login :</th>
					<td><input type="email" name="login" value=""
						placeholder="enter your login"></td>
				</tr>

				<tr>
					<th>Password :</th>
					<td><input type="password" name="password" value=""
						placeholder="enter your login"></td>
				</tr>

				<tr>
					<th>DOB :</th>
					<td><input type="date" name="dob" value=""></td>
				</tr>

				<tr>
					<th></th>
					<td><input type="submit" name="operation" value="signUp"></td>
				</tr>

			</table>

		</form>

	</div>






</body>
</html>