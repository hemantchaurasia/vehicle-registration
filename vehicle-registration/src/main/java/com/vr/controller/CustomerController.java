package com.vr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vr.model.Registration;

@Controller
public class CustomerController {

	List<Registration> regList = new ArrayList<Registration>();
	int rId = 100000;
	
	@RequestMapping(value = "/newRegistration", method = RequestMethod.GET)
	public String newRegistration2(@Validated Registration registration, Model model, HttpSession httpSession) {
		return "customer/customer";
	}

	@RequestMapping(value = "/newRegistration", method = RequestMethod.POST)
	public String newRegistration(@Validated Registration registration, Model model, HttpSession httpSession) {
		try {
			String resMsgColor = "";

			boolean formDataOk = isFormOk (registration.getName(),registration.getAddress(),
					registration.getGender(), registration.getAge(), registration.getInsuranceNumber(),
					registration.getEngineNo(), registration.getModel(), registration.getMake(), registration.getDLNumber());
			
			if(formDataOk) {
				registration.setRequestId(rId++);
				registration.setStatus("Pending");
				model.addAttribute("resMsg", "Registration Successful");
				model.addAttribute("resMsgColor", "yellow");
			regList.add(registration);
			httpSession.setAttribute("registrationList", regList);
			} else {
				model.addAttribute("resMsg", "Invalid Input");
				model.addAttribute("resMsgColor", "red");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "customer/customer";
	}
	
	// Button to land on my request page
	@RequestMapping(value = "/myRequests", method = RequestMethod.GET)
	public String myRequests() {
		return "customer/myRequest";
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
