<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html>
<head>
<title>Sample Struts Display Name</title>
</head>
<body>
 	 	<table width="80%" border="0">
 	 	 	<tr>
 	 	 	 	<td>Hello <%= session.getAttribute("NAME") %> !!</td>
 	 	 	</tr>
 	 	</table>
<html:button property="Click" value="Click to Register" onclick="doSubmit();"/>
</body>
</html>

<script language="javascript" type="text/javascript">
 function doSubmit()
{
	location.href="Register.do";
}
</script>