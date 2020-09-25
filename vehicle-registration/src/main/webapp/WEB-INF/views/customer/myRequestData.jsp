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
	<title>My Requests</title>
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
					java.util.List<Registration> regList = (java.util.ArrayList<Registration>)session.getAttribute("registrationList"); 
                %>
			</td>
		</tr>
	</table>
	<table border = "1" class="TFtable">
		<tr>
			<th><label>Request ID</label></th>
			<th><label>Name</label></th>
			<th><label>Make</label></th>
			<th><label>Model</label></th>
			<th><label>RTO Office</label></th>
			<th><label>Plate Number</label></th>
			<th><label>Status</label></th>
		</tr>
    <%
    int j=0;
    for(int i=0; i<regList.size();i++){
    	j++;
    %>
        <tr>
        	<td>
        		<input type="text" id="requestId<%=j%>" value=<%= ((Registration)regList.get(i)).getRequestId() %> readonly="readonly" />
        	</td>
        	<td>
        		<input type="text" id="name<%=j%>" value=<%= ((Registration)regList.get(i)).getName() %> readonly="readonly" />
        	</td>
        	<td>
        		<input type="text" id="make<%=j%>" value=<%= ((Registration)regList.get(i)).getMake() %> readonly="readonly" />
        	</td>
        	<td>
        		<input type="text" id="model<%=j%>" value=<%= ((Registration)regList.get(i)).getModel() %> readonly="readonly" />
        	</td> 
        	<td>
        		<input type="text" id="RTOOffice<%=j%>" value=<%= ((Registration)regList.get(i)).getRTOOffice() %> readonly="readonly" />
        	</td>
        	<td>
        		<input type="text" id="plateNo<%=j%>" value=<%= ((Registration)regList.get(i)).getPlateNumber() %> readonly="readonly" />
        	</td>  
        	<td>
        		<input type="text" id="status<%=j%>" value=<%= ((Registration)regList.get(i)).getStatus() %> readonly="readonly" />
        	</td>  
        </tr>
      <%}%>
</table>

</body>
</html>