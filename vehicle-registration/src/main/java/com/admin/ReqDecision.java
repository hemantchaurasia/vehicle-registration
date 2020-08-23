package com.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customer.RegistrationBean;

@WebServlet("/requestdecision")
public class ReqDecision extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public int plateNoTN = 1000;
	public int plateNoDL = 1000;
	public int plateNoMH = 1000;
	public int plateNoAP = 1000;
	public int plateNoKA = 1000;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<RegistrationBean> allReqList = (List<RegistrationBean>) request.getSession().getAttribute("registrationList");
		//System.out.println("allReqList:"+ allReqList.isEmpty());
		ViewRequestBean requestBean = (ViewRequestBean)request.getSession().getAttribute("requestToShow");
		try {
			
			if(request.getParameter("approve") != null) {
				String nPlate = null;
				for(int i=0; i<allReqList.size(); i++) {
					if(allReqList.get(i).getRequestId()==requestBean.getRequestId()) {
						nPlate = numberPlate(requestBean.getRTOOffice());
						allReqList.get(i).setPlateNumber(nPlate);
						allReqList.get(i).setStatus("Approved");
					}
				}
				requestBean.setStatus("Approved");
				requestBean.setPlateNumber(nPlate);
				requestBean.setButtonStatus("disabled");
				
			}else if(request.getParameter("reject") != null) {
				for(int i=0; i<allReqList.size(); i++) {
					if(allReqList.get(i).getRequestId()==requestBean.getRequestId()) {
						allReqList.get(i).setPlateNumber("-");
						allReqList.get(i).setStatus("Rejected");
					}
				}
				requestBean.setPlateNumber("-");
				requestBean.setStatus("Rejected");
				requestBean.setButtonStatus("disabled");
			}
			response.sendRedirect("admin/approvalPage.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String numberPlate(String RTOOffice) {
		
		String numberPlate = null;
		
		if(RTOOffice.equalsIgnoreCase("chennai")) {
			String shortCode = "TN";
			String RTOOfficeCode = "11";
			numberPlate = shortCode + "-" + RTOOfficeCode + "-" + ++plateNoTN;
		}else if(RTOOffice.equalsIgnoreCase("hyderabad")) {
			String shortCode = "AP";
			String RTOOfficeCode = "42";
			numberPlate = shortCode + "-" + RTOOfficeCode + "-" + ++plateNoAP;
		}else if(RTOOffice.equalsIgnoreCase("delhi")) {
			String shortCode = "DL";
			String RTOOfficeCode = "03";
			numberPlate = shortCode + "-" + RTOOfficeCode + "-" + ++plateNoDL;
		}else if(RTOOffice.equalsIgnoreCase("pune")) {
			String shortCode = "MH";
			String RTOOfficeCode = "54";
			numberPlate = shortCode + "-" + RTOOfficeCode + "-" + ++plateNoMH;
		}else if(RTOOffice.equalsIgnoreCase("bangalore")) {
			String shortCode = "KA";
			String RTOOfficeCode = "15";
			numberPlate = shortCode + "-" + RTOOfficeCode + "-" + ++plateNoKA;
		}
		return numberPlate;
	}
	
}
