package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customer.RegistrationBean;
import com.admin.ViewRequestBean;

@WebServlet("/viewrequest")
public class ViewRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		List<RegistrationBean> allReqList = (List<RegistrationBean>) request.getSession().getAttribute("registrationList");
		System.out.println("allReqList:"+ allReqList.isEmpty());
		
		ViewRequestBean viewRequestBean = new ViewRequestBean();
		
		try {
			
			int requestId = Integer.parseInt(request.getParameter("requestId"));
			System.out.println("requestId ::"+requestId);
			//Match the id in allRecordlist and populate the data to ViewRequestbean
	        for (int i = 0; i < allReqList.size(); i++) {
	        	
	        	if((allReqList.get(i).getRequestId()== requestId)){
	        		viewRequestBean.setRequestId(requestId);
	        		viewRequestBean.setName(allReqList.get(i).getName());
	        		viewRequestBean.setAddress(allReqList.get(i).getAddress());
	        		viewRequestBean.setGender(allReqList.get(i).getGender());
	        		viewRequestBean.setAge(allReqList.get(i).getAge());
	        		viewRequestBean.setRTOOffice(allReqList.get(i).getRTOOffice());
	        		viewRequestBean.setInsuranceNumber(allReqList.get(i).getInsuranceNumber());
	        		viewRequestBean.setVehicleType(allReqList.get(i).getVehicleType());
	        		viewRequestBean.setEngineNo(allReqList.get(i).getEngineNo());
	        		viewRequestBean.setModel(allReqList.get(i).getModel());
	        		viewRequestBean.setMake(allReqList.get(i).getMake());
	        		viewRequestBean.setDLNumber(allReqList.get(i).getDLNumber());
	        		viewRequestBean.setPlateNumber(allReqList.get(i).getPlateNumber());
	        		if(allReqList.get(i).getStatus() != "Pending") {
	        			viewRequestBean.setButtonStatus("disabled");
	        		}
	        	}
	            
	        }
			request.getSession().setAttribute("requestToShow", viewRequestBean);
			response.sendRedirect("admin/approvalPage.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
