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

import com.vr.model.Search;
import com.vr.model.Registration;
import com.vr.model.ViewRequest;

@Controller
public class AdminController {
	
	@RequestMapping(value = "/adminHome", method = RequestMethod.POST)
	public String adminHome(@Validated Search search, Model model, HttpSession httpSession) {
		System.out.println("------ Start newRegistration ---------");
		List<Registration> allReqList = (List<Registration>) httpSession.getAttribute("registrationList");
		List<Registration> resultList = new ArrayList<Registration>();
		try {
			String status = search.getStatus();
			String rtoOffice = search.getRTOOffice();
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
			httpSession.setAttribute("searchResultList", resultList);
			model.addAttribute("isRecord", isRecord);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("------ End newRegistration ---------");
		return "admin/searchRequest";
	}
	
	@RequestMapping(value = "/reqValidate", method = RequestMethod.GET)
	public String reqValidate(@RequestParam String requestId, HttpServletRequest request, HttpSession httpSession) {
		System.out.println("------ Start newRegistration ---------");
		
		List<Registration> allReqList = (List<Registration>) httpSession.getAttribute("registrationList");
		ViewRequest viewRequest = new ViewRequest();

		try {
			int reqtId = Integer.parseInt(requestId);
			System.out.println("requestId ::"+reqtId);
			//Match the id in allRecordlist and populate the data to ViewRequestbean
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
		System.out.println("------ End newRegistration ---------");
		return "admin/approvalPage";
	}
}
