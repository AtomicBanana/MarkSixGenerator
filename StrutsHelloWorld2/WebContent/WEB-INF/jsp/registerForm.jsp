<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Form</title>
</head>
<body>
<html:form action="Register" name="registerForm" type="example.RegisterForm">
 	 	<table width="80%" border="0">
 	 	 	<tr>
 	 	 	 	<td>Password:</td>
 	 	 	 	<td><html:text property="password" /></td>
 	 	 	 	<td>Email:</td>
 	 	 	 	<td><html:text property="email" /></td>
 	 	 	</tr>
 	 	 	<tr>
 	 	 	 	<td><html:submit /></td>
 	 	 	</tr>
 	 	</table>
 	</html:form>
</body>
</html>