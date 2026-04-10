<%@page import="com.rays.bean.User1Bean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	User1Bean user1Bean = (User1Bean) session.getAttribute("user");
	%>

	<%
	if (user1Bean != null) {
	%>
	<h1><%="Hii, " + user1Bean.getFirstName()%></h1>
	<a href="UserCtl.do">Add User</a> |
	<a href="UserListCtl.do">User List</a> |
	<a href="LoginCtl?operation=logout">Logout</a> |
	<a href="">Marksheet</a> |
	<%
	} else {
	%>

	<h3>Hii, Guest</h3>
	<a href="LoginCtl">Login</a> |
	<a href="UserRegistrationCtl">Sign Up</a> |
	<a href="">Marksheet</a> |
	<%
	}
	%>
	<a href="WelcomeCtl">Welcome</a>
	<hr>

</body>
</html>