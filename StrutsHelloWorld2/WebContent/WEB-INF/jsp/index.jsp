<%@ page language="java" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html>
<head>
<title>Sample Struts Application</title>
</head>
<body>
 	<html:form action="Name" name="nameForm" type="example.NameForm">
 	 	<table width="80%" border="0">
 	 	 	<tr>
 	 	 	 	<td>Name:</td>
 	 	 	 	<td><html:text property="name" /></td>
 	 	 	</tr>
 	 	 	<tr>
 	 	 	 	<td><html:submit /></td>
 	 	 	</tr>
 	 	</table>
 	</html:form>
</body>
</html>