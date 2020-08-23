<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css">
<style type="text/css">
	.tableRowSpace{
	  padding-bottom: 1em;
	}
</style>
</head>
<body>
	<div align="center">
		<h1>Login</h1></br>
		${ErrMsg}
		<%
			String showErr = "display:none";
			if (null!=request.getParameter("isErr")) {
				showErr = "";
			}
		%>
		<div id="errors" style=<%=showErr%>>
			<font color="red"><b>Invalid Input</b></font>
		</div>

		<form action="${pageContext.request.contextPath}/userLogin" method="post">
			<table style="with: 100%">
				<tr>
					<td>User ID</td>
					<td><input type="text" id="userID" name="userID" maxlength="16" /></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>				
				<tr>
					<td>Password</td>
					<td><input type="password" id="password" name="password" maxlength="16" /></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>				
				<tr>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" id="login" value="Login" class="formButtons"/></td>
				</tr>
			</table>
			
		</form>
	</div>
</body>
</html>