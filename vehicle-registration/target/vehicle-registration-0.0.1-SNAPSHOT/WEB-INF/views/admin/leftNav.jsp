<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer left navigation</title>
<link href="../css/common.css" rel="stylesheet" type="text/css">
</head>
<body>
	<table width="100%" height="100%">
		<tr align="right">
			<td valign="top">
				<input type="submit" name="" value="Home" onclick="location.href='<%=request.getContextPath()%>/admin/searchRequest.jsp'" class="leftNavButtons"></br>
				<input type="submit" name="" value="Logout" onclick="location.href='<%=request.getContextPath()%>/login.jsp'" class="leftNavButtons">
			</td>
		</tr>												
	</table>
</body>
</html>