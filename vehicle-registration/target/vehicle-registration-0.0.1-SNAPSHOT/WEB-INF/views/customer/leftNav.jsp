<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer left navigation</title>
<style type="text/css">
	.leftNavButtons { 
	  width: 100%;
	  text-align: left;
	  table-layout: fixed;
	  border-collapse: collapse;
	  background-color: green; 
	}
	.leftNavButtons:active{background-color:yellow;}
</style>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
</head>
<body>
	<table width="100%" height="100%">
		<tr align="right">
			<td valign="top">
				<input type="submit" name="" value="Home" onclick="location.href='${pageContext.request.contextPath}/login/'" class="leftNavButtons"></br>
				<input type="submit" name="" value="My Requests" onclick="location.href='${pageContext.request.contextPath}/login/'" class="leftNavButtons"></br>
				<input type="submit" name="" value="Logout" onclick="location.href='${pageContext.request.contextPath}/login/'" class="leftNavButtons">
			</td>
		</tr>												
	</table>
</body>
</html>