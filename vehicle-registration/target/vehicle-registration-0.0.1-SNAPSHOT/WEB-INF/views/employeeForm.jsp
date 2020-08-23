<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>BORAJI.COM</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/aaa.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/bbb.js"></script>
</head>
<body>
	<h1>Employee Input Form</h1>
	<hr />

	<form action="saveEmployee" method="post" name="employeeForm">
		<table>
			<tr>
				<td>First Name</td>
				<td><input name="firstName" type="text" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input name="lastName" type="text" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input name="email" type="text" /></td>
			</tr>
			<tr>
				<td>Designation</td>
				<td><input name="designation" type="text" /></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit">Submit</button></td>
			</tr>
		</table>
	</form>

	<!-- Result Container  -->
	<div id="resultContainer" style="display: none;">
		<hr />
		<h4 style="color: green;">JSON Response From Server</h4>
		<pre style="color: green;">
    		<code></code>
   		</pre>
	</div>
</body>
</html>
