package com.customer;

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

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	List<RegistrationBean> regList = new ArrayList<RegistrationBean>();
	int rId = 100000;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RegistrationBean registrationBean = new RegistrationBean();
		HttpSession session = request.getSession();
		try {
			String isError = null;

			boolean formDataOk = isFormOk (request.getParameter("name"),request.getParameter("address"),
					request.getParameter("gender"), request.getParameter("age"), request.getParameter("insuranceNumber"),
					request.getParameter("engineNo"), request.getParameter("model"), request.getParameter("make"), request.getParameter("DLNumber"));
			
			if(formDataOk) {
				registrationBean.setRequestId(rId++);
				registrationBean.setName(request.getParameter("name"));
				registrationBean.setAddress(request.getParameter("address"));
				registrationBean.setGender(request.getParameter("gender"));
				registrationBean.setAge(request.getParameter("age"));
				registrationBean.setRTOOffice(request.getParameter("RTOOffice"));
				registrationBean.setInsuranceNumber(request.getParameter("insuranceNumber"));
				registrationBean.setVehicleType(request.getParameter("vehicleType"));
				registrationBean.setEngineNo(request.getParameter("engineNo"));
				registrationBean.setModel(request.getParameter("model"));
				registrationBean.setMake(request.getParameter("make"));
				registrationBean.setDLNumber(request.getParameter("DLNumber"));
				registrationBean.setStatus("Pending");
				isError = "noError";
			regList.add(registrationBean);
			session.setAttribute("registrationList", regList);
			} else {
				isError = "error";
			}
			
			response.sendRedirect("customer/customer.jsp?isErr="+isError);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Function - To validate the form data
	public boolean isFormOk(String name, String address, String gender, String age, 
		 String insuranceNumber, String engineNo, String model, String make, String DLNumber) {
		
		boolean isDataCorrect = true;
		
		if(name.equalsIgnoreCase("") || !isAlpha(name)) {
			isDataCorrect = false;
		} else if (address.equalsIgnoreCase("")) {
			isDataCorrect = false;
		}else if (gender.equalsIgnoreCase("") || !isAlpha(gender)) {
			isDataCorrect = false;
		}else if (age.equalsIgnoreCase("") || (Integer.parseInt(age)<18) || (Integer.parseInt(age)>50)) {
			System.out.println("Error: Check the age field. Age should be between 18 to 50 yrs !");
			isDataCorrect = false;
		}else if (insuranceNumber.equalsIgnoreCase("") || !isAlphaNumeric(insuranceNumber) || (insuranceNumber.length()<6) || (insuranceNumber.length()>10)) {
			System.out.println("Error: Check the Insurance Number - Alphanumeric only, Min-6 & Max-10 !");
			isDataCorrect = false;
		}else if (engineNo.equalsIgnoreCase("") || (engineNo.length()<8) ||
				(engineNo.length()>10) || !isAlphaNumeric(engineNo)) {
			System.out.println("Error: Check the Engine number - Alphanumeric only, Min-8 & Max-10 !");
			isDataCorrect = false;
		}else if (model.equalsIgnoreCase("")) {
			isDataCorrect = false;
		}else if (make.equalsIgnoreCase("")) {
			isDataCorrect = false;
		}else if (DLNumber.equalsIgnoreCase("") || (DLNumber.length()<8) ||
				(DLNumber.length()>15) || !isAlphaNumeric(DLNumber)) {
			System.out.println("Error: Check the DL number - Alphanumeric only, Min-8 & Max-15 !");
			isDataCorrect = false;
		}
		
		return isDataCorrect;
	}
	
// Function - To check the string is only alphabets
	public boolean isAlpha(String s) {
		if (s == null) {
			System.out.println("Error: Check the field allows only the alphabates");
			return false;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
				System.out.println("Error: Check the field allows only the alphabates");
				return false;
			}
		}
		return true;
	}
	
// Function - To check string is AlphaNumeric
	public boolean isAlphaNumeric(String s) {
		return s != null && s.matches("^[a-zA-Z0-9]*$");
	}
}
