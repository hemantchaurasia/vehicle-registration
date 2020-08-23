<%@page import="com.vr.model.Registration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<title>Vehicle Registration Form</title>
</head>
<body>
	<div align="center">
		<!-- Main table -->
		<table border = "1" width = "100%" height = "100%">
			<tr>
				<td width="20%" height="100%" valign="top">
					<!-- Navigation table -->
					<div>
					    <%@ include file="leftNav.jsp" %>
					</div> 
				</td>
				<td width="80%" height="100%">
					<!-- Registration form table-->
					<table>
						<tr align="center">
							<td align="center">
								<label class="label"><h3>My Requests</h3></label>
							</td>
						</tr>
					</table>	
						<!-- Error Column-->
						<%
							java.util.List<Registration> regList2 = (java.util.ArrayList<Registration>)session.getAttribute("registrationList"); 
						%>
						<%
							if(regList2==null){
						%>
						<div id="error">
							<table>
								<tr align="center">
									<td align="center">
										<font color="red">No vehicles registered yet.</font>
									</td>
								</tr>
							</table>
						</div>
						<%
						}
						else {%>
						<div>
						    <%@ include file="myRequestData.jsp" %>
						</div> 
						<% } %>
					</td>
			</tr>
		</table>
	</div>
</body>
</html>