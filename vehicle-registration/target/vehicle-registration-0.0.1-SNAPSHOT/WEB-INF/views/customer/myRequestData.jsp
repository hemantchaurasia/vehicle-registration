<%@page import="com.customer.RegistrationBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
	<table>
		<tr align="center">
			<td align="center">
				<%
					java.util.List<RegistrationBean> regList = (java.util.ArrayList<RegistrationBean>)session.getAttribute("registrationList"); 
                %>
			</td>
		</tr>
	</table>
	<table border = "1" class="TFtable">
		<tr>
			<th>Request ID</th>
			<th>Name</th>
			<th>Make</th>
			<th>Model</th>
			<th>RTO Office</th>
			<th>Plate Number</th>
			<th>Status</th>
		</tr>
    <%
    for(int i=0; i<regList.size();i++){%>
        <tr>
        	<td><%= ((RegistrationBean)regList.get(i)).getRequestId() %></td>
       		<td><%= ((RegistrationBean)regList.get(i)).getName() %></td>
            <td><%= ((RegistrationBean)regList.get(i)).getMake() %></td>
            <td><%= ((RegistrationBean)regList.get(i)).getModel() %></td>
            <td><%= ((RegistrationBean)regList.get(i)).getRTOOffice() %></td> 
            <td><%= ((RegistrationBean)regList.get(i)).getPlateNumber() %></td> 
            <td><%= ((RegistrationBean)regList.get(i)).getStatus() %></td> 
        </tr>
      <%}%>
</table>

</body>
</html>