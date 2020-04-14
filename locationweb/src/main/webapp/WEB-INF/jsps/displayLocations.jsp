<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LocationsPage</title>
</head>
<body>

	<h2>Locations</h2>
	<table>
		<tr>
			<th>id</th>
			<th>code</th>
			<th>name</th>
			<th>type</th>
		</tr>

		<c:forEach items="${locations}" var="location">
			<!-- this locations would be same as the locations key used in modelMap attributes in controllers-->
			<tr>
				<td>${location.id}</td>
				<td>${location.code}</td>
				<td>${location.name}</td>
				<td>${location.type}</td>
				<td><a href="deleteLocation?id=${location.id}">delete</a></td>
				<td><a href="showUpdate?id=${location.id}">edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="showCreate">Add New Location</a>
</body>
</html>