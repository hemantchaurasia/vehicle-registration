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
	<title>Search Page - Vehicle Request</title>
<style type="text/css">
	.TFtable{
		width:100%; 
		border-collapse:collapse; 
	}
	.TFtable td{ 
		padding:7px; border:#4e95f4 1px solid;
	}
	.TFtable tr{
		background: #b8d1f3;
	}
	.TFtable tr:nth-child(odd){ 
		background: #b8d1f3;
	}
	.TFtable tr:nth-child(even){
		background: #dae5f4;
	}
</style>
</head>
<body>
	<div align="center">
	<!-- Page header-->
		<table>
			<tr align="center">
				<td align="center">
					<%@ include file="header.jsp" %>
				</td>
			</tr>
		</table>	
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
					<!-- Search table-->
					<table>
						<tr align="center">
							<td>
								<label><h3>Search Requests</h3></label>
							</td>
						</tr>
						<!-- Search Form-->
						<form action="${pageContext.request.contextPath}/adminHome" method="post" name="searchRegForm">
									<tr>																						<tr>																								<tr>
										<td>
											<label>Status: </label>
										</td>
										<td>
											<select name="status" id="status" >
												  <option value="pending">Pending</option>
												  <option value="approved">Approved</option>
												  <option value="rejected">Rejected</option>
											</select>
										</td>
									</tr>									
									<tr>																						<tr>																								<tr>
										<td>
											<label>RTO office: </label>
										</td>
										<td>
											<select name="RTOOffice" id="RTOOffice" >
												  <option value="chennai">Chennai</option>
												  <option value="hyderabad">Hyderabad</option>
												  <option value="delhi">Delhi</option>
												  <option value="pune">Pune</option>
												  <option value="bangalore">Bangalore</option>
											</select>
										</td>
									</tr>
									<tr>
										<td></td>
										<td></td>
									</tr>									
									<tr align="right">
										<td>
											<input type="submit" name="search" id="search" value="Search" class="formButtons">
										</td>
										<td></td>
									</tr>									
								</form>
									<!-- Error Column-->
									<% 
										java.util.List<Registration> searchRelList = (java.util.ArrayList<Registration>)session.getAttribute("searchResultList");
										if((searchRelList!=null) && (searchRelList.size()>0)) {
									%>
										<table border = "1" class="TFtable" >
											<tr class="tableHeader">
												<th>Request ID</th>
												<th>Name</th>
												<th>Make</th>
												<th>Model</th>
												<th>RTO Office</th>
												<th>Status</th>
											</tr>
											 
									    <%
									    for(int i=0; i<searchRelList.size() ;i++){%>
									        <tr>
									        	<td>
									        		<a href="${pageContext.request.contextPath}/reqValidate?requestId=<%= ((Registration)searchRelList.get(i)).getRequestId() %>"><%= ((Registration)searchRelList.get(i)).getRequestId() %></a>
									        	</td>
									        	<td><%= ((Registration)searchRelList.get(i)).getName() %></td>
									        	<td><%= ((Registration)searchRelList.get(i)).getMake() %></td>
									        	<td><%= ((Registration)searchRelList.get(i)).getModel() %></td>
									        	<td><%= ((Registration)searchRelList.get(i)).getRTOOffice() %></td>
									        	<td><%= ((Registration)searchRelList.get(i)).getStatus() %></td>
									        </tr>
								      <%
								      		}
										}
								      %>
								      <table>
								      <tr align="center">
										<td align="center">
											<div id="errors" >
												<font color="red"><b>${isRecord}</b></font>
											</div>
										</td>
									</tr>
									</table>
							</table>									
					</table>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>