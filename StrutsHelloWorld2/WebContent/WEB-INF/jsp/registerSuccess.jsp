<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Success</title>
</head>
<body>
<table width="80%" border="0">
	<tr>
		<td>Name(using Session): <%= session.getAttribute("NAME") %> </td>
	</tr>
	<tr>
	 	<td>Password: <%= request.getAttribute("PASSWORD") %> </td>
	</tr>
	<tr>
	 	<td>Email: <%= request.getAttribute("EMAIL") %> </td>
	</tr>
</table>
</body>
</html>