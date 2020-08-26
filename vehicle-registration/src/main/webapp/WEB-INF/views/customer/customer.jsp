<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/common.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<title>Registration Form</title>
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
						<tr align="center">
							<td align="center">
							<div id="errors">
								<font color=${resMsgColor}><b>${resMsg}</b></font>
							</div>	
							</td>
						</tr>						
						<!-- Form row of main table-->
						<form action="${pageContext.request.contextPath}/newRegistration" method="post" name="registrationForm">
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
														<input type="text" name="name" id="name" maxlength="25"/>
													</td>
												</tr>
												<tr>
													<td>
														<label class="label">Address: </label>
													</td>
													<td>
														<input type="text" name="address" id="address" maxlength="100" />
													</td>
												</tr>
												<tr>																								<tr>
													<td>
														<label class="label">Gender: </label>
													</td>
													<td>
														<input type="text" name="gender" id="gender" maxlength="8" />
													</td>
												</tr>
												<tr>																								<tr>
													<td>
														<label class="label">Age: </label>
													</td>
													<td>
														<input type="text" name="age" id="age" />
													</td>
												</tr>
												<tr>																						<tr>																								<tr>
													<td>
														<label class="label">RTO office: </label>
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
												<tr>																								<tr>
													<td>
														<label class="label">Insurance Number: </label>
													</td>
													<td>
														<input type="text" name="insuranceNumber" id="insuranceNumber" maxlength="10" />
													</td>
												</tr>												
											</table>
										</td>
										<td>
											<!-- Table for cloumn-1 fields-->
											<table>
												<tr>																						<tr>																								<tr>
													<td>
														<label class="label">Vehicle Type: </label>
													</td>
													<td>
														<select name="vehicleType" id="vehicleType" >
															  <option value="twowheeler">Two wheeler</option>
															  <option value="fourwheeler">Four wheeler</option>
															  <option value="threewheeler">Three wheeler</option>
															  <option value="heavyvehicle">Heavy vehicle</option>
														</select>
													</td>
												</tr>
												<tr>
													<td>
														<label class="label">Engine No: </label>
													</td>
													<td>
														<input type="text" name="engineNo" id="engineNo" maxlength="10" />
													</td>
												</tr>
												<tr>
													<td>
														<label class="label">Model: </label>
													</td>
													<td>
														<input type="text" name="model" id="model" maxlength="25" />
													</td>
												</tr>
												<tr>
													<td>
														<label class="label">Make: </label>
													</td>
													<td>
														<input type="text" name="make" id="make" maxlength="25" />
													</td>
												</tr>
												<tr>
													<td>
														<label class="label">DL Number: </label>
													</td>
													<td>
														<input type="text" name="DLNumber" id="DLNumber" maxlength="15" />
													</td>
												</tr>																																																
											</table>										
										</td>
									</tr>
									<tr align="right">
										<td><input type="submit" name="register" id="register" value="Register" class="formButtons" /></td>
										<td></td>
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