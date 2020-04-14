<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Location</title>
</head>
<body>
	<form action="updateLoc" method="post">
		<pre>
Id:<input type="text" name="id" value="${location.id}" readonly/> <!--we use readonly because we dont want our end users to change id. -->
Code:<input type="text" name="code" value="${location.code}" /><!-- this location will be the key that is passed in controller -->
Name:<input type="text" name="name" value="${location.name}" />
Type: Urban<input type="radio" name="type" value="URBAN"
				${location.type=='URBAN'?'checked':''} />
      Rural<input type="radio" name="type" value="RURAL"
				${location.type=='RURAL'?'checked':'' } />
<input type="submit" value="save" />
 </pre>
	</form>

</body>
</html>