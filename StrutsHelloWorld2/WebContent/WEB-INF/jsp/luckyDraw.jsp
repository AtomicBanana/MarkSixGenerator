<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lucky Draw</title>
</head>
<body>
<html:form action="LuckyDraw" name="luckyDrawForm" type="example.LuckyDrawForm">
 	 	<table width="80%" border="0">
 	 	 	<tr>
 	 	 	 	<td>Please Choose 6 numbers ranged from 1 to 49: </td>
 	 	 	 	<td><html:text property="numbers"/></td>
 	 	 	</tr>
 	 	 	<tr>
 	 	 	 	<td><html:submit /></td>
 	 	 	</tr>
 	 	 	<tr>
 	 	 		<td> Below are the validation rules:</td>
 	 	 	</tr>
 	 	 	<tr>
 	 	 		<td> 1. It must contain 6 numbers seperated with "," (e.g. 1,2,3,4,5,6)</td>
 	 	 	</tr>
 	 	 	<tr>
 	 	 		<td> 2. The numbers must be within range 1 ~ 49</td>
 	 	 	</tr>
 	 	 	<tr>
 	 	 		<td> 3. The numbers cannot duplicate</td>
 	 	 	</tr>
 	 	</table>
</html:form>
</body>
</html>