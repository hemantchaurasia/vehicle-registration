<%@page import="com.vr.model.ViewRequest"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<title>Registration admin approval page</title>
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
					<table style="background-color: #0000FF">
						<tr align="center">
							<td align="center">
								<label class="label"><h3>Registration Form</h3></label>
							</td>
						</tr>
						<%
							ViewRequest requestBean = (ViewRequest)session.getAttribute("requestToShow");
						%>
						<!-- Form row of main table-->
						<form action="<%=request.getContextPath()%>/requestdecision" method="post">
						<tr>
							<td>
								<table>
									<tr>
										<td>
											<!-- Table for cloumn-1 fields-->
											<table>
												<tr>
													<td>
														<label class="label">Name: </label>
													</td>
													<td>
														<input type="text" name="name" id="name" value=<%= requestBean.getName() %> readonly />
													</td>
												</tr>
												<tr>
													<td>
														<label class="label">Address: </label>
													</td>
													<td>
														<input type="text" name="address" id="address" value=<%= requestBean.getAddress() %> readonly />
													</td>
												</tr>
												<tr>																								<tr>
													<td>
														<label class="label">Gender: </label>
													</td>
													<td>
														<input type="text" name="gender" id="gender" value=<%= requestBean.getGender() %> readonly />
													</td>
												</tr>
												<tr>																								<tr>
													<td>
														<label class="label">Age: </label>
													</td>
													<td>
														<input type="text" name="age" id="age" value=<%= requestBean.getAge() %> readonly />
													</td>
												</tr>
												<tr>																						<tr>																								<tr>
													<td>
														<label class="label">RTO office: </label>
													</td>
													<td>
														<input type="text" name="RTOOffice" id="RTOOffice" value=<%= requestBean.getRTOOffice() %> readonly />
													</td>
												</tr>
												<tr>																								<tr>
													<td>
														<label class="label">Insurance Number: </label>
													</td>
													<td>
														<input type="text" name="insuranceNumber" id="insuranceNumber" value=<%= requestBean.getInsuranceNumber() %> readonly />
													</td>
												</tr>												
											</table>
										</td>
										<td>
											<!-- Table for cloumn-1 fields-->
											<table>
												<tr>																																														<tr>
													<td>
														<label class="label">Vehicle Type: </label>
													</td>
													<td>
														<input type="text" name="vehicleType" id="vehicleType" value=<%= requestBean.getVehicleType() %> readonly />
													</td>
												</tr>
												<tr>
													<td>
														<label class="label">Engine No: </label>
													</td>
													<td>
														<input type="text" name="engineNo" id="engineNo" value=<%= requestBean.getEngineNo() %> readonly />
													</td>
												</tr>
												<tr>
													<td>
														<label class="label">Model: </label>
													</td>
													<td>
														<input type="text" name="model" id="model" value=<%= requestBean.getModel() %> readonly />
													</td>
												</tr>
												<tr>
													<td>
														<label class="label">Make: </label>
													</td>
													<td>
														<input type="text" name="make" id="make" value=<%= requestBean.getMake() %> readonly />
													</td>
												</tr>
												<tr>
													<td>
														<label class="label">DL Number: </label>
													</td>
													<td>
														<input type="text" name="DLNumber" id="DLNumber" value=<%= requestBean.getDLNumber() %> readonly />
													</td>
												</tr>																																																
												<tr>
													<td>
														<label class="label">Plate No: </label>
													</td>
													<td>
														<input type="text" name="plateNo" id="plateNo" value=<%= requestBean.getPlateNumber() %> readonly />
													</td>
												</tr>																																																

											</table>										
										</td>
									</tr>
									<tr align="center">
										<td align="center">
											<input type="submit" name="approve" id="approve" value="Approve" class="buttons" <%= requestBean.getButtonStatus() %>>
										</td>
										<td align="center">
											<input type="submit" name="reject" id="reject" value="Reject" class="buttons" <%= requestBean.getButtonStatus() %>>
										</td>
									</tr>
								</form>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>