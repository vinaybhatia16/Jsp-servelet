<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
	List<User1Bean> list = (List) request.getAttribute("list");
	Iterator<User1Bean> it = list.iterator();
	%>

	<%@ include file="Header.jsp"%>
	<div align="center">

		<h1><u>User List</u></h1>

		<form action="UserListCtl" method="post">

			<table width="90%" border="1px">
				<tr style="background-color: skyblue">
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Login</th>
					<th>Password</th>
					<th>Dob</th>
				</tr>

				<%
				while (it.hasNext()) {
					User1Bean bean = it.next();
				%>

				<tr align="center" style="background-color: lightgrey">
			
					<td><%=bean.getId()%></td>
					<td><%=bean.getFirstName()%></td>
					<td><%=bean.getLastName()%></td>
					<td><%=bean.getLogin()%></td>
					<td><%=bean.getPassword()%></td>
					<td><%=bean.getDob()%></td>
				</tr>
				<%
				}
				%>
			</table>

		</form>
	</div>
	<%@ include file="Footer.jsp"%>
</body>
</html>