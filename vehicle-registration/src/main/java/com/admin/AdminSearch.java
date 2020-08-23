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

@WebServlet("/adminsearch")
public class AdminSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<RegistrationBean> allReqList = (List<RegistrationBean>) request.getSession().getAttribute("registrationList");
		List<RegistrationBean> resultList = new ArrayList<RegistrationBean>();
		
		try {
			String status = request.getParameter("status");
			String rtoOffice = request.getParameter("RTOOffice");
			String isRecord = null;
			if (allReqList != null) {
				for (int i = 0; i < allReqList.size(); i++) {
					if (allReqList.get(i).getStatus().equalsIgnoreCase(status) && allReqList.get(i).getRTOOffice().equalsIgnoreCase(rtoOffice)) {
						resultList.add(allReqList.get(i));
					}
				}
				
				if(resultList.size() == 0) {
					isRecord = "no"; 
				}else {
					isRecord = "yes"; 
				}
				 
			}
			request.getSession().setAttribute("searchResultList", resultList);
			response.sendRedirect("admin/searchRequest.jsp?isRecord="+isRecord);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
