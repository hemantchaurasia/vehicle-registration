<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/loginForm.js"></script>
	<title>Login page</title>
	<style type="text/css">
		.tableRowSpace{
		  padding-bottom: 1em;
		}
	</style>
</head>
<body>
	<div align="center">
		<h1>Login</h1></br>
		<% if(request.getParameter("ErrMsg")!=null){ %>
			<div id="errors">
				<font color="red"><b><%= request.getParameter("ErrMsg") %></b></font>
			</div>
		<%} %>
		<form action="${pageContext.request.contextPath}/login" method="post" name="loginForm">
			<table style="with: 100%">
				<tr>
					<td>
						<label>User ID</label>
					</td>
					<td><input type="text" id="userID" name="userID" maxlength="16" /></td>
				</tr>
				<tr>
					<td></td>
					<td></td>
				</tr>				
				<tr>
					<td>
						<label>Password</label>
					</td>
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