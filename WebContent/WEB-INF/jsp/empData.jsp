<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<p>The time on the server is ${serverTime}.</p>

	<h2>Update Employee</h2>
	<form action="updateEmp" method="post">
		<input type="text" name="id" value="${employee.id}" readonly="readonly"/><br>
		<input type="text" name="name" value="${employee.name}"/><br>
		<input type="submit" value="Update" />
	</form>

	<c:if test="${!empty listEmployees}">
		<h2>Employee List</h2>

		<table>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>
			<c:forEach items="${listEmployees}" var="employee">
				<tr>
					<td>${employee.id}</td>
					<td>${employee.name}</td>
					<td><a href="<c:url value='/edit/${employee.id}'/>">Edit</a></td>
					<td><a href="<c:url value='/delete/${employee.id}'/>">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>