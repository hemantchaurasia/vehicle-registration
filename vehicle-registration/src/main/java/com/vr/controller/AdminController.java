package com.vr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vr.model.Registration;
import com.vr.model.Search;
import com.vr.model.ViewRequest;

@Controller
public class AdminController {
	
	public int plateNoTN = 1000;
	public int plateNoDL = 1000;
	public int plateNoMH = 1000;
	public int plateNoAP = 1000;
	public int plateNoKA = 1000;

	@RequestMapping(value = "/adminHome", method = RequestMethod.GET)
	public String adminHome1() {
		return "admin/searchRequest";
	}
	
	@RequestMapping(value = "/adminHome", method = RequestMethod.POST)
	public String adminHome(@Validated Search search, Model model, HttpSession httpSession) {
		List<Registration> allReqList = (List<Registration>) httpSession.getAttribute("registrationList");
		List<Registration> resultList = new ArrayList<Registration>();
		try {
			String status = search.getStatus();
			String rtoOffice = search.getRTOOffice();
			if (allReqList != null) {
				for (int i = 0; i < allReqList.size(); i++) {
					if (allReqList.get(i).getStatus().equalsIgnoreCase(status) && allReqList.get(i).getRTOOffice().equalsIgnoreCase(rtoOffice)) {
						resultList.add(allReqList.get(i));
					}
				}
				if(resultList.size() == 0) {
					model.addAttribute("isRecord", "No records found"); 
				} 
			}
			httpSession.setAttribute("searchResultList", resultList);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/searchRequest";
	}
	
	@RequestMapping(value = "/reqValidate", method = RequestMethod.GET)
	public String reqValidate(@RequestParam String requestId, HttpSession httpSession) {
		List<Registration> allReqList = (List<Registration>) httpSession.getAttribute("registrationList");
		ViewRequest viewRequest = new ViewRequest();
		
		try {
			int reqtId = Integer.parseInt(requestId);
			System.out.println("requestId ::"+reqtId);
			//Match the id in allRecordlist and populate the data to ViewRequestBean
	        for (int i = 0; i < allReqList.size(); i++) {
	        	
	        	if((allReqList.get(i).getRequestId()== reqtId)){
	        		viewRequest.setRequestId(reqtId);
	        		viewRequest.setName(allReqList.get(i).getName());
	        		viewRequest.setAddress(allReqList.get(i).getAddress());
	        		viewRequest.setGender(allReqList.get(i).getGender());
	        		viewRequest.setAge(allReqList.get(i).getAge());
	        		viewRequest.setRTOOffice(allReqList.get(i).getRTOOffice());
	        		viewRequest.setInsuranceNumber(allReqList.get(i).getInsuranceNumber());
	        		viewRequest.setVehicleType(allReqList.get(i).getVehicleType());
	        		viewRequest.setEngineNo(allReqList.get(i).getEngineNo());
	        		viewRequest.setModel(allReqList.get(i).getModel());
	        		viewRequest.setMake(allReqList.get(i).getMake());
	        		viewRequest.setDLNumber(allReqList.get(i).getDLNumber());
	        		viewRequest.setPlateNumber(allReqList.get(i).getPlateNumber());
	        		if(allReqList.get(i).getStatus() != "Pending") {
	        			viewRequest.setButtonStatus("disabled");
	        		}
	        	}
	        }
	        httpSession.setAttribute("requestToShow", viewRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/approvalPage";
	}
	
	@RequestMapping(value = "/reqDecision", method = RequestMethod.POST)
	public String reqDecision(HttpServletRequest request, Model model, HttpSession httpSession) {
		List<Registration> allReqList = (List<Registration>) httpSession.getAttribute("registrationList");
		String ErrMsg = "";
		ViewRequest viewRequest = (ViewRequest)httpSession.getAttribute("requestToShow");
		try {
			
			if(request.getParameter("approve") != null) {
				String nPlate = null;
				for(int i=0; i<allReqList.size(); i++) {
					if(allReqList.get(i).getRequestId()==viewRequest.getRequestId()) {
						nPlate = numberPlate(viewRequest.getRTOOffice());
						allReqList.get(i).setPlateNumber(nPlate);
						allReqList.get(i).setStatus("Approved");
					}
				}
        		ErrMsg = "Request Processed Successfully";
        		model.addAttribute("resMsg", ErrMsg);
				viewRequest.setStatus("Approved");
				viewRequest.setPlateNumber(nPlate);
				viewRequest.setButtonStatus("disabled");
				
			}else if(request.getParameter("reject") != null) {
				for(int i=0; i<allReqList.size(); i++) {
					if(allReqList.get(i).getRequestId()==viewRequest.getRequestId()) {
						allReqList.get(i).setPlateNumber("-");
						allReqList.get(i).setStatus("Rejected");
					}
				}
        		ErrMsg = "Request Processed Successfully";
        		model.addAttribute("resMsg", ErrMsg);
				viewRequest.setPlateNumber("-");
				viewRequest.setStatus("Rejected");
				viewRequest.setButtonStatus("disabled");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/approvalPage";
	}
	
	
//Method to generate the Number Plate 	
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
