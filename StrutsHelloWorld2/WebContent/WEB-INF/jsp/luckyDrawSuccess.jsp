<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lucky Drawing...</title>
</head>
<body>
	<table width="30%" border="0">
 	 	<tr>
 	 		<td>Lucky Draw Begins!!!!!</td>
 	 	</tr>
 	 	<tr>
 	 		<td>
 	 			<p id="demo"></p>
 	 		</td>
 	 	</tr>
 	 </table>
 	 
 	 <table width="80%" border="0">
 	 	<tr>
 	 		<td id="number1" width="80"><%= request.getAttribute("numbers1") %></td>
 	 		<td id="number2" width="80"><%= request.getAttribute("numbers2") %></td>
 	 		<td id="number3" width="80"><%= request.getAttribute("numbers3") %></td>
 	 		<td id="number4" width="80"><%= request.getAttribute("numbers4") %></td>
 	 		<td id="number5" width="80"><%= request.getAttribute("numbers5") %></td>
 	 		<td id="number6" width="80"><%= request.getAttribute("numbers6") %></td>
 	 	</tr>
 	 </table>
 	 <html:hidden property="drawCount" value="1" />
 	 
 	 <table>
 	 <tr>
 	 	 <td>Here are your chosen numbers: <%= request.getAttribute("numbers") %></td>
 	 </tr>
 	 <tr>
 	 	<td>Here are the system's choices: </td>
 	 	<td style="font-size: 24px; color: red;">Hit Avg: <%= request.getAttribute("hitAvg") %></td>
 	 	<td style="font-size: 24px; color: blue;"> Max Hit: <%= request.getAttribute("maxHit") %></td>
 	 	<td style="font-size: 24px; color: green;"> Max Count: <%= request.getAttribute("maxCount") %></td>
 	 </tr>
 	 <%int[][] sysDraws =  (int[][]) request.getAttribute("drawsTable"); %>
 	 <tr>
 	 <% for(int i = 0; i < sysDraws.length ; i++){%>
 		<td>
 		<%for(int k = 0; k < sysDraws[i].length; k++){%>
 			<%= sysDraws[i][k] %>
 		<%}%>
 		</td>
 		<td>Hit Count: </td>
 		<% int[] hitCount = (int[]) request.getAttribute("hits"); %>
 		<td style="font-size: 24px; color: red;"> <%= hitCount[i] %></td>
 	 </tr>
 	 <%} %>
 	 </table>
</body>
</html>
<script>
var myClock = setInterval(myTimer, 1000);
var myJumpingNum1 = setInterval(numberJump1, 1 +  Math.floor(Math.random() * ((100 - 1) + 1)));
var myJumpingNum2 = setInterval(numberJump2, 1 +  Math.floor(Math.random() * ((100 - 1) + 1)));
var myJumpingNum3 = setInterval(numberJump3, 1 +  Math.floor(Math.random() * ((100 - 1) + 1)));
var myJumpingNum4 = setInterval(numberJump4, 1 +  Math.floor(Math.random() * ((100 - 1) + 1)));
var myJumpingNum5 = setInterval(numberJump5, 1 +  Math.floor(Math.random() * ((100 - 1) + 1)));
var myJumpingNum6 = setInterval(numberJump6, 1 +  Math.floor(Math.random() * ((100 - 1) + 1)));
var stopCount = 1;
var autoStopJumping = setInterval(numberStop, 1000);
function myTimer() {
    var d = new Date();
    document.getElementById("demo").innerHTML = d.toLocaleTimeString();
}
function numberJump1() {
	var num = 1 +  Math.floor(Math.random() * ((49 - 1) + 1))
    document.getElementById("number1").innerHTML = num;
}
function numberJump2() {
	var num = 1 +  Math.floor(Math.random() * ((49 - 1) + 1))
    document.getElementById("number2").innerHTML = num;
}
function numberJump3() {
	var num = 1 +  Math.floor(Math.random() * ((49 - 1) + 1))
    document.getElementById("number3").innerHTML = num;
}
function numberJump4() {
	var num = 1 +  Math.floor(Math.random() * ((49 - 1) + 1))
    document.getElementById("number4").innerHTML = num;
}
function numberJump5() {
	var num = 1 +  Math.floor(Math.random() * ((49 - 1) + 1))
    document.getElementById("number5").innerHTML = num;
}
function numberJump6() {
	var num = 1 +  Math.floor(Math.random() * ((49 - 1) + 1))
    document.getElementById("number6").innerHTML = num;
}
function numberStop() {
	switch(stopCount) {
	case 1:
		clearInterval(myJumpingNum1);
		document.getElementById("number1").innerHTML = <%= request.getAttribute("numbers1") %>;
		break;
	case 2:
		clearInterval(myJumpingNum2);
		document.getElementById("number2").innerHTML = <%= request.getAttribute("numbers2") %>;
		break;
	case 3:
		clearInterval(myJumpingNum3);
		document.getElementById("number3").innerHTML = <%= request.getAttribute("numbers3") %>;
		break;
	case 4:
		clearInterval(myJumpingNum4);
		document.getElementById("number4").innerHTML = <%= request.getAttribute("numbers4") %>;
		break;
	case 5:
		clearInterval(myJumpingNum5);
		document.getElementById("number5").innerHTML = <%= request.getAttribute("numbers5") %>;
		break;
	case 6:
		clearInterval(myJumpingNum6);
		document.getElementById("number6").innerHTML = <%= request.getAttribute("numbers6") %>;
		break;
	default:
		clearInterval(autoStopJumping);
	}
	stopCount = stopCount + 1;
}
</script>